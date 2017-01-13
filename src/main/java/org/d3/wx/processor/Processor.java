package org.d3.wx.processor;

import org.d3.wx.vo.Message;

public interface Processor {
	
	String process(Message msg);
}
