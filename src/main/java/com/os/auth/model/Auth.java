package com.os.auth.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	
	private int vcode;
	
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
	@Override
	public String toString() {
		return "Auth [id=" + id + ", phone=" + phone + ", password=" + password
				+ ", vcode=" + vcode + "]";
	}
}
