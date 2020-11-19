package com.example.banking.domain;

// Account -> Super class/Base Class
// CheckingAccount -> Sub-class/Derived Class
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public double withdraw(double amount) throws InsufficientBalanceException {
		System.out.println("CheckingAccount::withdraw");
		// validation
		if (amount <= 0.) 
			throw new IllegalArgumentException("amount cannot be negative.");
		// business rule
		if (amount > (balance+overdraftAmount)) 
			throw new InsufficientBalanceException("amount cannot be larger than balance.",amount-balance-overdraftAmount);		
		// business logic
		balance = balance - amount;
		return this.balance;
	}



}
