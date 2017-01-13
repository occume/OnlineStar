package org.d3.wx.api;

import java.util.Arrays;

import com.google.common.base.Joiner;
import com.os.util.EncryptUtil;

public class In {

	public static boolean checkSignature(String timeStamp, String nonce, String signature){
		String[] tmp = {Base.getToken(), timeStamp, nonce};
		Arrays.sort(tmp);
		String bf = Joiner.on("").join(tmp);
		String after = EncryptUtil.sha(bf);
		return signature.equals(after);
	}
	
	public static void main(String...strings){
		String[] tmp = {"1426239851", "289187281", "UleYPhau9hM0kbjzln9qLLb2T1t62YO_2QUkcpOeGQh9Xl_K4GAc9jxModwAqoE_xpIOf8O43H5mSC0_PWuQaepcLIPju41ApiV_BHscn9g"};
		Arrays.sort(tmp);
		String bf = Joiner.on("").join(tmp);
		System.out.println(bf);
		String after = EncryptUtil.sha(bf);
		System.out.println(after);
	}
}
