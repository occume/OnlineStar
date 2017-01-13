package com.os.db.domain;

public class Result {
	
	public static Result OK = new Result(0, "OK");

	private int err;
	private String desc;
	
	public Result(){}
	
	public Result(int err, String desc){
		this.err = err;
		this.desc = desc;
	}
	
	public int getErr() {
		return err;
	}
	public void setErr(int err) {
		this.err = err;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
