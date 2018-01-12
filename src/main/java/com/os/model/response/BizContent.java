package com.os.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.os.util.Pay;

public class BizContent {
	
	@JsonProperty("timeout_express")
	private String timeoutExpress = Pay.TIMEOUT_EXPRESS;
	
	@JsonProperty("product_code")
	private String productCode;
	
	@JsonProperty("total_amount")
	private String totalAmount;

	private String subject;
	private String body;
	
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
}
