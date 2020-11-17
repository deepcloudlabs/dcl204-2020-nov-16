package com.example.banking.domain;

public enum AccountStatus {
    ACTIVE(100), BLOCKED(200), CLOSED(300);
	private int code;

	private AccountStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
}
