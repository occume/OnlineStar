package com.os.util;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Http {
	
	private static Logger LOG = LoggerFactory.getLogger(Http.class);
	
	private static OkHttpClient client = new OkHttpClient();
	private static MediaType JSON = MediaType.parse("application/json; charset=UTF-8");
	
	public static String post(String url, String payload){
		RequestBody body = RequestBody.create(JSON, payload);
		return doPost(url, body);
	}
	
	public static String post(String url, Map<String, String> paramMap){
		
		FormBody.Builder builder = new FormBody.Builder();
		for(Entry<String, String> entry: paramMap.entrySet()){
			builder.add(entry.getKey(), entry.getValue());
		}
		
		RequestBody body = builder.build();
		
		return doPost(url, body);
	}
	
	private static String doPost(String url, RequestBody body){
		
		String result = null;
		Request request = new Request.Builder()
		.url(url)
		.post(body)
		.build();
		
		Call call = client.newCall(request);
		try {
			Response response = call.execute();
			if(response.isSuccessful()){
				result = response.body().string();
			}
			else{
				LOG.warn("Status code: {}", response.code());
			}
		} catch (IOException e) {
			LOG.error("", e);
		}
		return result;
	}
}
