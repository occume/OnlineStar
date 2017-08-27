package com.os.model;

public class Wallet {
    private Integer id;

    private Long authId;

    private Double balance = 0.0;

    private String password;

    private String alipayName;

    private String wxpayName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName == null ? null : alipayName.trim();
    }

    public String getWxpayName() {
        return wxpayName;
    }

    public void setWxpayName(String wxpayName) {
        this.wxpayName = wxpayName == null ? null : wxpayName.trim();
    }
}