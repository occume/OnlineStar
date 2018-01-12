package com.os.model;

public class Order {
	
	public static Order newOrder(String tradeNo, Long jobId, 
			Long authId, double advanceAmount, String remark, int result){
		Order order = new Order();
		order.setTradeNo(tradeNo);
		order.setJobId(jobId);
		order.setAuthId(authId);
		order.setAdvanceAmount(advanceAmount);
		order.setRemark(remark);
		order.setResult(result);
		return order;
	}
	
	public static Order newOrder(String tradeNo, Long jobId,  int result, String remark){
		return newOrder(tradeNo, jobId, 0L, 0L, remark, result);
	}

	private Long id;
	
	private String tradeNo;

    private Long jobId;

    private Long authId;

    private Integer statusId;
    
    private Integer type;
    
    private double totalAmount;
    private double advanceAmount;
    private String remark;
    private int result;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getAuthId() {
		return authId;
	}
	public void setAuthId(Long authId) {
		this.authId = authId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(double advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", tradeNo=" + tradeNo + ", jobId=" + jobId
				+ ", authId=" + authId + ", statusId=" + statusId + ", type="
				+ type + ", totalAmount=" + totalAmount + ", advanceAmount="
				+ advanceAmount + ", remark=" + remark + "]";
	}
    
}
