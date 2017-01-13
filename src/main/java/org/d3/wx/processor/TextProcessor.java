package org.d3.wx.processor;

import org.d3.wx.ResponseMaker;
import org.d3.wx.vo.Message;
import org.springframework.stereotype.Component;

@Component
public class TextProcessor implements Processor {
	
	@Override
	public String process(Message msg) {
		String content = msg.getContent();
		String from = msg.getFromUserName();
		String to = msg.getToUserName();
		return ResponseMaker.textXml(to, from, "你好");
	}
}
