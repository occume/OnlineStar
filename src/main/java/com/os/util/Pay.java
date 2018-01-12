package com.os.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

public class Pay {
	
	private static Logger LOG = LoggerFactory.getLogger(Pay.class);
	
	public static String APP_ID = "2017091008655273";
	public static String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCVBatR06SFxYrOUsFCk+Qxx0nqTftEc9kQjlnsISolxwWbdfp29Bg4P8dsgusEbXAze4ssLsMWlb/M2gpzHY/tQ0r1DIghMeMr3MG2Yj7+S/5FEBUbb00rQ1U2dHl/bYdGu9UTObT37Vuk64DPrl6Li3VGkphTS9O4+0+gP2deIlegr70ht32SXKlMIhjA2Ta6uOzgObbrHMenO3VhGojlvtmUoJpicHG6PaEW/Gs2G+G93dMasobC60x/GqZ3HKJ3Gg0wO9VagyUAJ321MEgjIV9MmT5sl8BVbPaTtev/cDHaqE4S8SjzsC2n8KIDGN5Ku09f1nd12pWGx820GTJjAgMBAAECggEAZBFygXgFOm70Tqfzbqmwylxwng3PdJ/2Ws+8QnviuYtzkHkgv1AaE2uAlrUy674xYeDMC9c62aelLAIekj5/r2tIolTP9LpzObj7u2Utt8V/8RBjnBCZWTvVtMNx8sex1yW6ZzaQ9wtERvJ9hPgqNLpo/gLilsyMV+MqDQmGeAbBHDW9SI2kv6MoHUouT9jbyp7zBi+tfa+sBK1rnBBnL98PSX5dZmf9eYcRQ1Il4sgN4ZgJpZC5iqrmXWQHYgO+7ECCr0S+f2GeU1rt1Kt3N9cuUVFipGa/6tnPE47MawF/4j18jaw44JzcKcHxCIw1nVC3YcJ1zS025obAuPsjgQKBgQDLH1WtPgRzqYccVn+OAAgs2VLkcvMTzx3BbZ8YMd6VNG4w31ATJgC4sH3XiBfcrrvVfEQrh1dIwdZOhVZ4NKy6rbfjAPWWI6Zc6YtpF227MNdSvlnsoJL9X9A/c/UWfjxbrHrFNhu8fnuw3WXFYrdTfPvKB5nZY/HiflkQBt27uwKBgQC70O/PNoSoMpiKxQl1/GOEEP1uc95Ti+M7WFEcrPQsR6+xRJGvvfbMEBkrLcv6a18007EjDVzUZF25MTl5AmJPqECeJ/iuyTh5CiFm8UlMkQlHv3BMyKjrQEtDrlrfIJqS0dE2VYvPgch+bZKSGzVL1I1fis/RB7MoeHX1Yg11eQKBgCAmTIRILaI08fqtQjEylhirKTCZdRnsjVQhSq4krotFKi+4GM9/E1woKzLjCovWaEqJCa0uFcWhUI9LEX2jMLe3aUSX0Uc7S0inenZey/J1747cLBWE8N8DvE1eyCsQPfNwoFn4j3lNN7ytvj74ufWP8bZvb412AUINJ4Ge5JejAoGAGogXeGQxNTmAhwnynjI7NKrZwkKoA5FdVkLRooVkMOUnkpknI3ZoaMdVZt4fVI7acjH9cgAvPum2u7SSc9+8V5hjGHR5EufmDGM7+LjZK/HJJ9OJX69w/VqlxzfYKnEGpPry3QQUrgmdcw6zh+REESRDnF2Voee+jVcHAtUJJbECgYBNyndkl+60e2X1al1IVJWLaED9JsndHhHpgFQhdDjiok2fDWKTjwp/hdA+lOd+2W6VzGceoI2v/x2vvPg5yKpyu2fsNmcG9E5CnRUn7c4y8azQkrVGMSzlp6FXsUZHbTeSqDdIl7oF08wkO+BCRk4EGTjKFgPvvoGkJGjihypnaA==";
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoH6l6bmWxxOdarpLO2TFo51p+lDseOY0NVoznV1p5Ujc0WTDCgi4eaWWoNZ/RHEgrO45ouT049HmYy9/bvl1u0S1CV6XqIqom0sJuC9Ir3n3nsLbK/yvF/kDFKtI6trG1WXkmqY1neDeq1Blq5+0g9VhpBwmffcjYUT3Ao8daZntUND3GAlUqOFWjHFTTQBwY7gGc8iyu1NwcUvwnnzqjlwaOf9/+H1xNnWaGTicAJVJAW5V0sDsc4qbPzi4qzw8UnxnY80yj13ZWgSnPzA04Px+KaJ38OXkCCCU3SWy+zdyQoWoFEDfZrTyKF9K0zjICfgVkpkpwOkW33D37+Nb5wIDAQAB";
	public static String CHARSET = "UTF-8";
	public static String FORMAT = "json";
	public static String SIGN_TYPE = "RSA2";
	public static String PRODUCT_CODE = "QUICK_MSECURITY_PAY";
	public static String NOTIFY_URL = "http://116.62.159.178:8080/hrz/pay/notify/alipay";
	public static String METHOD = "alipay.trade.app.pay";
	public static String VERSION = "1.0";
	public static String TIMEOUT_EXPRESS = "15d";
	
	private static void createOrder(){
//		String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCVBatR06SFxYrOUsFCk+Qxx0nqTftEc9kQjlnsISolxwWbdfp29Bg4P8dsgusEbXAze4ssLsMWlb/M2gpzHY/tQ0r1DIghMeMr3MG2Yj7+S/5FEBUbb00rQ1U2dHl/bYdGu9UTObT37Vuk64DPrl6Li3VGkphTS9O4+0+gP2deIlegr70ht32SXKlMIhjA2Ta6uOzgObbrHMenO3VhGojlvtmUoJpicHG6PaEW/Gs2G+G93dMasobC60x/GqZ3HKJ3Gg0wO9VagyUAJ321MEgjIV9MmT5sl8BVbPaTtev/cDHaqE4S8SjzsC2n8KIDGN5Ku09f1nd12pWGx820GTJjAgMBAAECggEAZBFygXgFOm70Tqfzbqmwylxwng3PdJ/2Ws+8QnviuYtzkHkgv1AaE2uAlrUy674xYeDMC9c62aelLAIekj5/r2tIolTP9LpzObj7u2Utt8V/8RBjnBCZWTvVtMNx8sex1yW6ZzaQ9wtERvJ9hPgqNLpo/gLilsyMV+MqDQmGeAbBHDW9SI2kv6MoHUouT9jbyp7zBi+tfa+sBK1rnBBnL98PSX5dZmf9eYcRQ1Il4sgN4ZgJpZC5iqrmXWQHYgO+7ECCr0S+f2GeU1rt1Kt3N9cuUVFipGa/6tnPE47MawF/4j18jaw44JzcKcHxCIw1nVC3YcJ1zS025obAuPsjgQKBgQDLH1WtPgRzqYccVn+OAAgs2VLkcvMTzx3BbZ8YMd6VNG4w31ATJgC4sH3XiBfcrrvVfEQrh1dIwdZOhVZ4NKy6rbfjAPWWI6Zc6YtpF227MNdSvlnsoJL9X9A/c/UWfjxbrHrFNhu8fnuw3WXFYrdTfPvKB5nZY/HiflkQBt27uwKBgQC70O/PNoSoMpiKxQl1/GOEEP1uc95Ti+M7WFEcrPQsR6+xRJGvvfbMEBkrLcv6a18007EjDVzUZF25MTl5AmJPqECeJ/iuyTh5CiFm8UlMkQlHv3BMyKjrQEtDrlrfIJqS0dE2VYvPgch+bZKSGzVL1I1fis/RB7MoeHX1Yg11eQKBgCAmTIRILaI08fqtQjEylhirKTCZdRnsjVQhSq4krotFKi+4GM9/E1woKzLjCovWaEqJCa0uFcWhUI9LEX2jMLe3aUSX0Uc7S0inenZey/J1747cLBWE8N8DvE1eyCsQPfNwoFn4j3lNN7ytvj74ufWP8bZvb412AUINJ4Ge5JejAoGAGogXeGQxNTmAhwnynjI7NKrZwkKoA5FdVkLRooVkMOUnkpknI3ZoaMdVZt4fVI7acjH9cgAvPum2u7SSc9+8V5hjGHR5EufmDGM7+LjZK/HJJ9OJX69w/VqlxzfYKnEGpPry3QQUrgmdcw6zh+REESRDnF2Voee+jVcHAtUJJbECgYBNyndkl+60e2X1al1IVJWLaED9JsndHhHpgFQhdDjiok2fDWKTjwp/hdA+lOd+2W6VzGceoI2v/x2vvPg5yKpyu2fsNmcG9E5CnRUn7c4y8azQkrVGMSzlp6FXsUZHbTeSqDdIl7oF08wkO+BCRk4EGTjKFgPvvoGkJGjihypnaA==";
		//实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", 
				APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
		
		
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("我是红人赞的测试数据");
		model.setSubject("App支付测试Java");
		model.setOutTradeNo("20170001");
		model.setTimeoutExpress("30m");
		model.setTotalAmount("0.01");
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl("http://116.62.159.178:8080/notify/alipay");
		try {
		        //这里和普通的接口调用不同，使用的是sdkExecute
			
		        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
		        System.out.println("Result = " + response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
		    } catch (AlipayApiException e) {
		        e.printStackTrace();
		}
	}
	
	public static void main(String...strings) throws UnsupportedEncodingException{
		createOrder();
		
//		String sign = URLDecoder.decode("JFxraRo1BtyVNDwSqtsjA9J4Bvessiv7lx0XAl7IoBBBm3fa6B3e19WkxSNmGcpgghP8wZJF%2B8MfWP%2FxY05yRyPfSIdFRDmFZ2k0Nig2w0c8P73sP62%2BXcpTElE2O6btfxeB6B1ODZyATMhCUx2n8D3%2Fdo6YKkPsEpsckO2iZqKRXxdqJskaYZZYcMKY9nXbmyt1k%2FeZkuTyniiitdAgiWQycOw9oRKKBBvVR8L8taWOsQPTwi6LQwF%2Fzx3nVDHRET3ZzxzkIUZ9Jvll5kKdQSWiaQcdd8yLtfk%2FO2m%2F%2BuN9a8R7t19Z%2FR%2F2jPja%2BVGtC6TR0u24ryPfKyhisdu8GQ%3D%3D", 
//				"UTF-8");
//		System.out.println(sign);
		
	}
}
