package com.example.banking.app;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.Customer;

@SuppressWarnings("unused")
public class StudyPolymorphism {

	public static void main(String[] args) {
		Account account; // Account, CheckingAccount
		
		boolean headOrTail = ThreadLocalRandom.current().nextBoolean();
		
		if (headOrTail)
			account = new Account("tr1", 10_000);
		else
			account = new CheckingAccount("tr2", 5_000, 1_000);
        System.out.println(account.getClass().getName());
		account.withdraw(2_500); // ???
		
		Object o;
		o = 42;
		o = 3.1415;
		o = "jack";
		o = true;
		o = new Account("tr3", 10_000);
		A a = new A();
		  a = new B();
		  a = new C();
		  a = new D();
		C c = new C();
		 // Error: c = new D();
		B b = new B();
		  b = new D();
		// Error:  b = new A();
	}

	public static double getTotalBalance(List<Customer> customers) {
		return customers.stream()
				        .mapToDouble(Customer::getBalance)
				        .sum();
	}
}

class A { void fun() {} }
class B extends A { }
class C extends A { }
class D extends B { } // D -> B -> A
