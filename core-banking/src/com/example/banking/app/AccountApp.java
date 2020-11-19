package com.example.banking.app;

import com.example.banking.domain.Account;
import com.example.banking.domain.InsufficientBalanceException;

public class AccountApp {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc1 = new Account("tr1", 100_000.0);
		try {
			acc1.withdraw(75_000.);
			acc1.deposit(10_000);
			acc1.withdraw(50_000);			
		} catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			System.out.println("Deficit: "+e.getDeficit());
			throw e; // ? re-throw
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(acc1.getBalance());
	}

}
