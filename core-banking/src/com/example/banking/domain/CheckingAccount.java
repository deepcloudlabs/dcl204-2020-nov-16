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
	public boolean withdraw(double amount) {
		System.out.println("CheckingAccount::withdraw");
		// validation
		if (amount <= 0.) return false;
		// business rule
		if (amount > (balance+overdraftAmount)) return false;
		// business logic
		balance = balance - amount;
		return true;
	}



}
