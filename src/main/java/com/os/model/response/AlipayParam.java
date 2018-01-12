package com.os.model.response;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.os.util.Pay;
import com.os.util.TimeUtil;

public class AlipayParam {
	
	public static AlipayParam newAlipayParam(String subject, String body, String outTradeNo, String totalAmount){
		AlipayParam param = new AlipayParam(subject, body, outTradeNo, totalAmount);
		return param;
	}
	
	private String appId = Pay.APP_ID;
	private String method = Pay.METHOD;
	private String charset = Pay.CHARSET;
	private String format = Pay.FORMAT;
	
	@JsonProperty("sign_type")
	private String signType = Pay.SIGN_TYPE;
	
	private String timestamp = TimeUtil.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
	private String version = Pay.VERSION;

	@JsonProperty("notify_url")
	private String notifyUrl = Pay.NOTIFY_URL;
	
	@JsonProperty("biz_content")
	private BizContent bizContent;
	
	private String sign;
	
	public AlipayParam(){}
	
	public AlipayParam(String subject, String body, String outTradeNo,
			String totalAmount) {
		bizContent = new BizContent();
		bizContent.setBody(body);
		bizContent.setOutTradeNo(outTradeNo);
		bizContent.setSubject(subject);
		bizContent.setTotalAmount(totalAmount);
		bizContent.setProductCode(Pay.PRODUCT_CODE);
		sign = computeSign();
	}
	
	private String computeSign(){
//		app_id=2015052600090779&
//				biz_content={"timeout_express":"30m","product_code":"QUICK_MSECURITY_PAY","total_amount":"0.01","subject":"1","body":"我是测试数据","out_trade_no":"IQJZSRC1YMQB5HU"}&
//				charset=utf-8&
//				format=json&
//				method=alipay.trade.app.pay&
//				notify_url=http://domain.merchant.com/payment_notify&
//					sign_type=RSA2&
//					timestamp=2016-08-25 20:26:31&
//					version=1.0
		Gson gson = new Gson();
		String bizC = gson.toJson(bizContent);
		StringBuffer sb = new StringBuffer();
		sb
		.append("app_id=").append(appId).append("&")
		.append("biz_content=").append(bizC).append("&")
		.append("charset=").append(charset).append("&")
		.append("format=").append(format).append("&")
		.append("method=").append(method).append("&")
		.append("notify_url=").append(notifyUrl).append("&")
		.append("sign_type=").append(signType).append("&")
		.append("timestamp=").append(timestamp).append("&")
		.append("version=").append(version);
		
		String content = sb.toString();
		try {
			return AlipaySignature.rsaSign(content, Pay.APP_PRIVATE_KEY, charset, signType);
		} catch (AlipayApiException e) {
			return "";
		}
	}
	
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BizContent getBizContent() {
		return bizContent;
	}

	public void setBizContent(BizContent bizContent) {
		this.bizContent = bizContent;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String getSign(){
		return this.sign;
	}
}
