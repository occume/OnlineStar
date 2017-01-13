package org.d3.wx.util;

import org.d3.http.Http;

public class PlayerSource {
	
	private static String URL11 = "";

	public static boolean is11(String name){
		String result = Http.get(URL11 + name);
		return result.equals("0");
	}
}
