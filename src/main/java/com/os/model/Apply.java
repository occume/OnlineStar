package com.os.model;

public class Apply {
	
    private Long id;

    private Long jobId;

    private Long osId;

    private Integer applyStatusId;

    private String reason;
    
    public static Apply newApply(long jobId, long osId){
    	return new Apply(jobId, osId);
    }
    
    public Apply(){}
    
    public Apply(long jobId, long osId){
    	this.jobId = jobId;
    	this.osId = osId;
    	this.applyStatusId = 1;
    }

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

    public Long getOsId() {
        return osId;
    }

    public void setOsId(Long osId) {
        this.osId = osId;
    }

    public Integer getApplyStatusId() {
        return applyStatusId;
    }

    public void setApplyStatusId(Integer applyStatusId) {
        this.applyStatusId = applyStatusId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}