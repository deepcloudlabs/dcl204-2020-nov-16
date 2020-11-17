package com.example.banking.domain;

// Entity
public class Account {
	private final String iban;
	// default permission, package private
	protected double balance; // information hiding principle
	private AccountStatus status = AccountStatus.ACTIVE;
	
	public Account(final String iban,final double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}
	
	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public final boolean deposit(double amount) {
		// validation
		if (amount <= 0.0) return false; 
		// business logic
		this.balance = this.balance + amount;
		return true;
	}
	
	public boolean withdraw(double amount) {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0.0) return false;
		// business rule
		if (amount > this.balance) return false;
		// business logic
		this.balance = this.balance - amount;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
}
