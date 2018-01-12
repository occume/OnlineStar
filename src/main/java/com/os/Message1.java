package com.os;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NativeHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.DefaultResult;
import cn.jpush.api.JPushClient;
import cn.jpush.api.device.OnlineStatus;
import cn.jpush.api.device.TagAliasResult;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.InterfaceAdapter;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.push.model.notification.PlatformNotification;

public class Message1 {

	protected static final Logger LOG = LoggerFactory.getLogger(Message1.class);

	private static final String APP_KEY = "5369f5a8027bb350c375e40c";
	private static final String MASTER_SECRET = "d35102a639a2b511bf0b0019";
	private static final String TAG1 = "tag1";
	private static final String ALIAS1 = "alias1";
	private static final String ALIAS2 = "alias2";
	private static final String REGISTRATION_ID1 = "13065ffa4e3242108ce";
	private static final String REGISTRATION_ID2 = "0a04ad7d8b4";
	
	private String registrationId;
	private String alert;
	private String title;
	private int fromGroupId;
	private long fromId;
	private String link;
	
	public Message1(){}
	
	public Message1(String registrationId, String alert, String title,
			int fromGroupId, long fromId, String link) {
		this.registrationId = registrationId;
		this.alert = alert;
		this.title = title;
		this.fromGroupId = fromGroupId;
		this.fromId = fromId;
		this.link = link;
	}

	public static PushPayload buildPayload(Message1 message) {
		
		Message msg = Message.newBuilder()
				.setContentType("application/json")
				.setMsgContent("You receive a message from Hongrz")
				.addExtra("fromGroupId", message.getFromGroupId())
                .addExtra("fromId", message.getFromId())
                .addExtra("link", message.getLink())
                .build();
		
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
//                .setAudience(Audience.registrationId(message.getRegistrationId()))
                .setAudience(Audience.all())
                .setMessage(msg)
//                .setNotification(Notification.newBuilder()
//                        .setAlert(message.getAlert())
//                        .addPlatformNotification(AndroidNotification.newBuilder()
//                                .setTitle(message.getTitle())
//                                .addExtra("fromGroupId", message.getFromGroupId())
//                                .addExtra("fromId", message.getFromId())
//                                .addExtra("link", message.getLink())
//                                .build())
//                        
//                        .build())
                .build();
        return payload;
    }

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFromGroupId() {
		return fromGroupId;
	}

	public void setFromGroupId(int fromGroupId) {
		this.fromGroupId = fromGroupId;
	}

	public long getFromId() {
		return fromId;
	}

	public void setFromId(long fromId) {
		this.fromId = fromId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	private static JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);

	public static void main(String[] args) {
		testSendPush();
//		testGetDeviceTagAlias();
//		testGetUserOnlineStatus();
	}
	
	public static void testGetDeviceTagAlias() {
		try {
			TagAliasResult result = jpushClient.getDeviceTagAlias(REGISTRATION_ID1);
			
			LOG.info(result.alias);
			LOG.info(result.tags.toString());
			
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
			
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	public static void testGetUserOnlineStatus() {
		try {
			Map<String, OnlineStatus> result =  jpushClient.getUserOnlineStatus(REGISTRATION_ID1, REGISTRATION_ID2);

			LOG.info(result.get(REGISTRATION_ID1).toString());
			LOG.info(result.get(REGISTRATION_ID2).toString());
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}

	public static void testBindMobile() {
		try {
			DefaultResult result =  jpushClient.bindMobile(REGISTRATION_ID1, "13000000000");
			LOG.info("Got result " + result);
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}
	
	public static void testSendPush() {
		ClientConfig clientConfig = ClientConfig.getInstance();
        final JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        String authCode = ServiceHelper.getBasicAuthorization(APP_KEY, MASTER_SECRET);
        // Here you can use NativeHttpClient or NettyHttpClient or ApacheHttpClient.
        NativeHttpClient httpClient = new NativeHttpClient(authCode, null, clientConfig);
        // Call setHttpClient to set httpClient,
        // If you don't invoke this method, default httpClient will use NativeHttpClient.
//        ApacheHttpClient httpClient = new ApacheHttpClient(authCode, null, clientConfig);
//        jpushClient.getPushClient().setHttpClient(httpClient);
        Message1 message = new Message1(REGISTRATION_ID1, "Hello", "Welcome", 2, 1, "www.hongrz.com");
        final PushPayload payload = buildPayload(message);
        System.out.println(payload);
//        // For push, all you need do is to build PushPayload object.
//        PushPayload payload = buildPushObject_all_alias_alert();
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

	//use String to build PushPayload instance
    public static void testSendPush_fromJSON() {
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(PlatformNotification.class, new InterfaceAdapter<PlatformNotification>())
                .create();
        // Since the type of DeviceType is enum, thus the value should be uppercase, same with the AudienceType.
        String payloadString = "{\"platform\":{\"all\":false,\"deviceTypes\":[\"IOS\"]},\"audience\":{\"all\":false,\"targets\":[{\"audienceType\":\"TAG_AND\",\"values\":[\"tag1\",\"tag_all\"]}]},\"notification\":{\"notifications\":[{\"soundDisabled\":false,\"badgeDisabled\":false,\"sound\":\"happy\",\"badge\":\"5\",\"contentAvailable\":false,\"alert\":\"Test from API Example - alert\",\"extras\":{\"from\":\"JPush\"},\"type\":\"cn.jpush.api.push.model.notification.IosNotification\"}]},\"message\":{\"msgContent\":\"Test from API Example - msgContent\"},\"options\":{\"sendno\":1429488213,\"overrideMsgId\":0,\"timeToLive\":-1,\"apnsProduction\":true,\"bigPushDuration\":0}}";
        PushPayload payload = gson.fromJson(payloadString, PushPayload.class);
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

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
}
