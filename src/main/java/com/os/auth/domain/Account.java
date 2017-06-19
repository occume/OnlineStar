package com.os.auth.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Account {
	
	@Id
	@GeneratedValue
	private long id;
	@Pattern(regexp = "^1\\d{10}", message = "Invalid phone number")
	private String phone;
	@NotNull
	@Size(min=1, max=20)
	private String name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", phone=" + phone + ", name=" + name
				+ "]";
	}
}
