package org.d3.wx;

import java.util.List;

import org.d3.wx.vo.ArticleItem;

public class ResponseMaker {
	
	public static String textXml(String from, String to, String content){
		
		StringBuffer buf = baseXml(from, to, "text");
		buf.append("<Content><![CDATA["+ content +"]]></Content>");
		buf.append("</xml>");

		return buf.toString();
	}
	
	public static String newsXml(String from, String to, List<ArticleItem> items){
		
		StringBuffer buf = baseXml(from, to, "news");
		
		buf.append("<ArticleCount>"+ items.size() +"</ArticleCount>");
		buf.append("<Articles>");
		
		for(ArticleItem item: items){
			buf.append("<item>");
			buf.append("<Title><![CDATA["+ item.getTitle() +"]]></Title>");
			buf.append("<Description><![CDATA["+ item.getDescription() +"]]></Description>");
			buf.append("<PicUrl><![CDATA["+ item.getPicurl() +"]]></PicUrl>");
			buf.append("<Url><![CDATA["+ item.getUrl() +"]]></Url>");
			buf.append("</item>");
		}
		
		buf.append("</Articles>");
		buf.append("</xml>");
		
		return buf.toString();
	}
	
	private static StringBuffer baseXml(String from, String to, String type){
		StringBuffer buf = new StringBuffer();
		buf.append("<xml>");
		buf.append("<FromUserName><![CDATA[" + from + "]]></FromUserName>");
		buf.append("<ToUserName><![CDATA[" + to + "]]></ToUserName>");
		buf.append("<CreateTime>"+"</CreateTime>");
		buf.append("<MsgType><![CDATA["+ type +"]]></MsgType>>");
		return buf;
	}
}
