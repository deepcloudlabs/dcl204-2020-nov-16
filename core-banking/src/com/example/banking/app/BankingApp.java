package com.example.banking.app;

import java.util.Optional;
import java.util.function.Consumer;

import com.example.banking.domain.Account;
import com.example.banking.domain.Customer;
import com.example.banking.domain.InsufficientBalanceException;

public class BankingApp {

// IntelliJ: psvm(tab), Alt+Insert
	public static void main(String[] args) throws InsufficientBalanceException {
		Customer jack; // Ctrl+Shift+O
		jack = new Customer("11111111110", "jack bauer", 1956, "jack@example.com", "555 5555");
		System.out.println(jack.getFullname());
		System.out.println(jack.getEmail());
		jack.setEmail("jack.bauer@example.com");
		System.out.println(jack.getEmail());
		System.out.println(jack);
		System.out.println(jack.toString());
		System.out.println(jack.getClass());
		jack.addAccount(new Account("tr1", 10_000));
		jack.addAccount(new Account("tr2", 20_000));
		jack.addAccount(new Account("tr3", 30_000));
		System.out.println("Number of accounts is " + jack.getNumberOfAccounts());
		System.out.println(jack.getAccount(1));
		jack.getAccount("tr4").ifPresent(account -> withdraw(account, 1_000));
		jack.getAccount("tr4").ifPresent(account -> withdraw(account, 1_000));

		// Alt + Shift + L -> Extract to Local variable
		// Lambda Expression
		Consumer<Account> withdraw1k = account -> withdraw(account, 1_000);
		Consumer<Account> printAccount = System.out::println;
		jack.getAccount("tr2").ifPresent(withdraw1k.andThen(printAccount));
		Optional<Account> acc = jack.getAccount("tr2");
		if (acc.isPresent()) {
			acc.get().withdraw(1_000);
			System.out.println(acc.get());
		}
		System.out.println("Total balance: " + jack.getBalance());
		System.out.println("Total balance8: " + jack.getBalance8());
	}
	public static void withdraw(Account account, double amount){
		try {
			account.withdraw(1_000);
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}
	}
}
