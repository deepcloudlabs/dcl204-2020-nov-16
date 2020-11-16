package com.example.banking.app;

import com.example.banking.domain.Account;

public class AccountApp {

	public static void main(String[] args) {
		Account acc1 = new Account("tr1", 100_000.0);
		acc1.withdraw(75_000);
		acc1.deposit(10_000);
		acc1.withdraw(50_000);
		System.out.println(acc1);
	}

}
