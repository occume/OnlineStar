package com.os.model;

public class Apply {
	
    private Long id;

    private Long jobId;

    private Long osId;

    private Integer statusId;

    private String reason;
    
    public static Apply newApply(long jobId, long osId){
    	return new Apply(jobId, osId);
    }
    
    public Apply(){}
    
    public Apply(long jobId, long osId){
    	this.jobId = jobId;
    	this.osId = osId;
    	this.statusId = 1;
    }
    
    public Apply(long id, int applyStatusId){
    	this.id = id;
    	this.statusId = applyStatusId;
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

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}