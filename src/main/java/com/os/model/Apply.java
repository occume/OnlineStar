package com.os.model;

public class Apply {
	
    private Long id;

    private Long jobId;

    private Long authId;

    private Integer statusId;

    private String reason;
    
    private Integer type;
    
    public static Apply newApply(long jobId, long authId){
    	return new Apply(jobId, authId);
    }
    
    public static Apply newApply(long jobId, long authId, int type){
    	return new Apply(jobId, authId, type);
    }
    
    public Apply(){}
    
    public Apply(long jobId, long authId, int type){
    	this.jobId = jobId;
    	this.authId = authId;
    	this.type = type;
    	this.statusId = 1;
    }
    
    public Apply(long jobId, long authId){
    	this.jobId = jobId;
    	this.authId = authId;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
    
}