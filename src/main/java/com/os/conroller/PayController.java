package com.os.conroller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.os.IdGenerator;
import com.os.auth.model.Account;
import com.os.model.AlipayResult;
import com.os.model.Order;
import com.os.model.Result;
import com.os.model.response.AlipayParam;
import com.os.service.CommonService;
import com.os.util.Pay;

@Controller
@RequestMapping("/pay")
public class PayController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(PayController.class);
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
    public Object pay(HttpServletRequest request, @RequestBody Map<String, Object> map){
		Account account = checkAndGetAuth(request);
		LOG.info("Access by: {}", request.getRemoteHost());
		long jobId = getParamLong("job_id", map);
		double advanceAmount = getParamDouble("advance_amount", map);
		long authId = account.getAuthId();
		String tradeNo = IdGenerator.INSTANCE.nextId();
		
		Order order = Order.newOrder(tradeNo, jobId, authId, advanceAmount, getParamString("remark", map), 0);
		
		int createResult = commonService.createOrder(order);
		LOG.info("CreateResult: {}; {}", createResult, order);
		
		String subject = "红人赞发布工作预付";
		String body = "我是红人赞的测试数据";
		
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", 
				Pay.APP_ID, Pay.APP_PRIVATE_KEY, "json", Pay.CHARSET, Pay.ALIPAY_PUBLIC_KEY, Pay.SIGN_TYPE);
		
		
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest req = new AlipayTradeAppPayRequest();
		//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody(body);
		model.setSubject(subject);
		model.setOutTradeNo(tradeNo);
		model.setTimeoutExpress("15d");
		model.setTotalAmount("0.01");
		model.setProductCode("QUICK_MSECURITY_PAY");
		req.setBizModel(model);
//		req.setNotifyUrl("http://116.62.159.178:8080/notify/alipay");
		req.setNotifyUrl(Pay.NOTIFY_URL);
		
		String sign = "";
		try {
		        //这里和普通的接口调用不同，使用的是sdkExecute
		        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(req);
		        sign = response.getBody();
		        System.out.println("Result = " + sign);//就是orderString 可以直接给客户端请求，无需再做处理。
		    } catch (AlipayApiException e) {
		        e.printStackTrace();
		}
	
		
		AlipayParam param = AlipayParam.newAlipayParam(subject, body, tradeNo, String.valueOf(advanceAmount));
    	return Result.ok(sign);
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	@ResponseBody
    public Object payResult(HttpServletRequest request, @RequestBody Map<String, Object> map){
		checkAndGetAuth(request);
		LOG.info("Access by: {}", request.getRemoteHost());
		long jobId = getParamLong("job_id", map);
		String tradeNo = getParamString("trade_no", map);
		int result = getParamInt("result", map);
		String remark =  getParamString("remark", map);
		
		Order order = Order.newOrder(tradeNo, jobId, result, remark);
		
		int createResult = commonService.updateOrder(order);
		LOG.info("Update order: {}, {}", tradeNo, createResult);
		
    	return Result.OK;
	}
	
	@RequestMapping(value = "/notify/alipay", method = RequestMethod.POST)
	@ResponseBody
    public Object payNotify(HttpServletRequest request){
		LOG.info("Access by: {}", request.getRemoteHost());
		AlipayResult payResult = parseNotify0(request);
		int result = commonService.createAlipayResult(payResult);
		LOG.info("Create AlipayResult: {}; {}", result, payResult);
    	return "success";
	}
	
	private AlipayResult parseNotify0(HttpServletRequest request){
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
		    String name = (String) iter.next();
		    String[] values = (String[]) requestParams.get(name);
		    String valueStr = "";
		    for (int i = 0; i < values.length; i++) {
		        valueStr = (i == values.length - 1) ? valueStr + values[i]
		                    : valueStr + values[i] + ",";
		  	}
		    //乱码解决，这段代码在出现乱码时使用。
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
		    System.out.println(name + " " + valueStr);
			params.put(name, valueStr);
		}
		//切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
		//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
		try {
			boolean flag = AlipaySignature.rsaCheckV1(params, Pay.ALIPAY_PUBLIC_KEY, Pay.CHARSET, Pay.SIGN_TYPE);
			System.out.println(flag);
		} catch (AlipayApiException e) {
			LOG.error("", e);
		}
		
		return AlipayResult.convert(params);
	}
}