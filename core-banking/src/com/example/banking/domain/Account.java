package com.example.banking.domain;

// Entity
public class Account {
	private final String iban;
	private double balance;
	
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}
	
	public boolean deposit(double amount) {
		// validation
		if (amount <= 0.0) return false; 
		// business logic
		this.balance = this.balance + amount;
		return true;
	}
	
	public boolean withdraw(double amount) {
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
