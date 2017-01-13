package org.d3.wx.test;

import org.d3.wx.api.Base;

public class BaseTest {

	public static void main(String...strings){
		getQrcodeTicket();
	}
	
	public static void getQrcodeTicket(){
		String ticket = Base.qrcodeTicket();
		System.out.println(ticket);
	}
}
