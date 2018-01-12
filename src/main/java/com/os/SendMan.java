package com.os;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.os.util.Http;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NativeHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

public class SendMan {
	
	protected static final Logger LOG = LoggerFactory.getLogger(SendMan.class);
	
	private static final String APP_KEY = "5369f5a8027bb350c375e40c";
	private static final String MASTER_SECRET = "d35102a639a2b511bf0b0019";
	
	public static void send(Message1 message) {
		
		ClientConfig clientConfig = ClientConfig.getInstance();
        final JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        String authCode = ServiceHelper.getBasicAuthorization(APP_KEY, MASTER_SECRET);
        
//        NativeHttpClient httpClient = new NativeHttpClient(authCode, null, clientConfig);
        // Call setHttpClient to set httpClient,
        // If you don't invoke this method, default httpClient will use NativeHttpClient.
//        ApacheHttpClient httpClient = new ApacheHttpClient(authCode, null, clientConfig);
//        jpushClient.getPushClient().setHttpClient(httpClient);
//        Message message = new Message();
        final PushPayload payload = Message1.buildPayload(message);

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
            System.out.println(result);
            // 如果使用 NettyHttpClient，需要手动调用 close 方法退出进程
            // If uses NettyHttpClient, call close when finished sending request, otherwise process will not exit.
            // jpushClient.close();
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            LOG.error("Sendno: " + payload.getSendno());
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
        }
    }
	
	public static void sms(String phone, int vcode){
		Map<String, String> paramMap = Maps.newHashMap();
		paramMap.put("apikey", "b4f2a1363ea5797f1d4129f162191caf");
		paramMap.put("text", String.format("【红人赞】您的验证码是：%d，请勿出示给其他人", vcode));
		paramMap.put("mobile", phone);
		Http.post("https://sms.yunpian.com/v2/sms/single_send.json", paramMap);
	}
	
	public static void main(String...strings){
		String a = String.format("【红人赞】您的验证码是：%d，请勿出示给其他人", 1123);
		System.out.println(a);
		sms("13585908235", 1123);
	}
}
