package com.os.auth.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Auth {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Pattern(regexp = "^1\\d{10}", message = "Invalid phone number")
	private String phone;
	
	@NotNull
	@Size(min=6, max=20)
	private String password;
	
	private String registionid;
	
	private int vcode;
	
	private int type;
	
	private String token;
	
	@JsonProperty("open_key")
	private String openKey;
	
	private String openKeyWx;
	
	private String openKeyWeibo;
	
	private String openKeyQq;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getVcode() {
		return vcode;
	}
	public void setVcode(int vcode) {
		this.vcode = vcode;
	}
	
	public String getRegistionid() {
		return registionid;
	}
	public void setRegistionid(String registionid) {
		this.registionid = registionid;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getOpenKey() {
		return openKey;
	}
	public void setOpenKey(String openKey) {
		this.openKey = openKey;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getOpenKeyWx() {
		return openKeyWx;
	}
	public void setOpenKeyWx(String openKeyWx) {
		this.openKeyWx = openKeyWx;
	}
	public String getOpenKeyWeibo() {
		return openKeyWeibo;
	}
	public void setOpenKeyWeibo(String openKeyWeibo) {
		this.openKeyWeibo = openKeyWeibo;
	}
	public String getOpenKeyQq() {
		return openKeyQq;
	}
	public void setOpenKeyQq(String openKeyQq) {
		this.openKeyQq = openKeyQq;
	}
	@Override
	public String toString() {
		return "Auth [phone=" + phone + ", password=" + password
				+ ", registionid=" + registionid + ", vcode=" + vcode
				+ ", type=" + type + ", openKey=" + openKey + "]";
	}
	
}
