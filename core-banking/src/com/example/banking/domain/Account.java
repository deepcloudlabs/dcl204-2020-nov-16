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

	public final double deposit(double amount) {
		// validation
		if (amount <= 0.0) 
			throw new IllegalArgumentException("amount cannot be negative."); 
		// business logic
		this.balance = this.balance + amount;
		return this.balance;
	}
	
	// There are two types of exceptions in Java
	// 1. Unchecked Exceptions: Runtime Exception -> extends RuntimeException
	// 2. Checked Exceptions: Business Exception  -> extends Exception
	public double withdraw(double amount) throws InsufficientBalanceException {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0.0) 
			throw new IllegalArgumentException("amount cannot be negative.");
		// business rule
		if (amount > this.balance) 
			throw new InsufficientBalanceException("amount cannot be larger than balance.",amount-balance); // Business Exception
		// business logic
		this.balance = this.balance - amount;
		return this.balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
}
