package com.os.model;

import java.util.Date;
import java.util.Map;

import com.os.util.TimeUtil;

public class AlipayResult {
	
	public static AlipayResult convert(Map<String, String> params){
		AlipayResult result = new AlipayResult();
		result.setNotifyTime(TimeUtil.parse(params.get("notify_time")));
		result.setNotifyType(params.get("notify_type"));
		result.setNotifyId(params.get("notify_id"));
		result.setAppId(params.get("app_id"));
		result.setCharset(params.get("charset"));
		result.setVersion(params.get("version"));
		result.setSignType(params.get("sign_type"));
		result.setSign(params.get("sign"));
		result.setTradeNo(params.get("trade_no"));
		result.setOutTradeNo(params.get("out_trade_no"));
		result.setOutBizNo(params.get("out_biz_no"));
		result.setBuyerId(params.get("buyer_id"));
		result.setBuyerLogonId(params.get("buyer_logon_id"));
		result.setSellerId(params.get("seller_id"));
		result.setSellerEmail(params.get("seller_email"));
		result.setTradeStatus(params.get("trade_status"));
		result.setTotalAmount(Double.parseDouble(params.get("total_amount")));
		result.setReceiptAmount(Double.parseDouble(params.get("receipt_amount")));
		result.setInvoiceAmount(Double.parseDouble(params.get("invoice_amount")));
		result.setBuyerPayAmount(Double.parseDouble(params.get("buyer_pay_amount")));
		result.setPointAmount(Double.parseDouble(params.get("point_amount")));
		result.setRefundFee(Double.parseDouble(params.get("refund_fee")));
		result.setSubject(params.get("subject"));
		result.setBody(params.get("body"));
		result.setGmtCreate(TimeUtil.parse(params.get("gmt_create")));
		result.setGmtPayment(TimeUtil.parse(params.get("gmt_payment")));
		result.setGmtRefund(TimeUtil.parse(params.get("gmt_refund")));
		result.setGmtClose(TimeUtil.parse(params.get("gmt_close")));
		result.setFundBillList(params.get("fund_bill_list"));
		result.setVoucherDetailList(params.get("voucher_detail_list"));
		return result;
	}
	
    private Long id;

    private Date notifyTime;

    private String notifyType;

    private String notifyId;

    private String appId;

    private String charset;

    private String version;

    private String signType;

    private String sign;

    private String tradeNo;

    private String outTradeNo;

    private String outBizNo;

    private String buyerId;

    private String buyerLogonId;

    private String sellerId;

    private String sellerEmail;

    private String tradeStatus;

    private Double totalAmount;

    private Double receiptAmount;

    private Double invoiceAmount;

    private Double buyerPayAmount;

    private Double pointAmount;

    private Double refundFee;

    private String subject;

    private String body;

    private Date gmtCreate;

    private Date gmtPayment;

    private Date gmtRefund;

    private Date gmtClose;

    private String fundBillList;

    private String passbackParams;

    private String voucherDetailList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType == null ? null : notifyType.trim();
    }

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId == null ? null : notifyId.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset == null ? null : charset.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo == null ? null : outBizNo.trim();
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId == null ? null : buyerLogonId.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail == null ? null : sellerEmail.trim();
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Double receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Double getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(Double buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    public Double getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(Double pointAmount) {
        this.pointAmount = pointAmount;
    }

    public Double getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Double refundFee) {
        this.refundFee = refundFee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(Date gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    public Date getGmtRefund() {
        return gmtRefund;
    }

    public void setGmtRefund(Date gmtRefund) {
        this.gmtRefund = gmtRefund;
    }

    public Date getGmtClose() {
        return gmtClose;
    }

    public void setGmtClose(Date gmtClose) {
        this.gmtClose = gmtClose;
    }

    public String getFundBillList() {
        return fundBillList;
    }

    public void setFundBillList(String fundBillList) {
        this.fundBillList = fundBillList == null ? null : fundBillList.trim();
    }

    public String getPassbackParams() {
        return passbackParams;
    }

    public void setPassbackParams(String passbackParams) {
        this.passbackParams = passbackParams == null ? null : passbackParams.trim();
    }

    public String getVoucherDetailList() {
        return voucherDetailList;
    }

    public void setVoucherDetailList(String voucherDetailList) {
        this.voucherDetailList = voucherDetailList == null ? null : voucherDetailList.trim();
    }
}