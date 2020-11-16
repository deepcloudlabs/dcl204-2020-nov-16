package com.example.banking.app;

import com.example.banking.domain.Customer;

public class BankingApp {

// IntelliJ: psvm(tab), Alt+Insert
	public static void main(String[] args) {
          Customer jack ; // Ctrl+Shift+O
          jack = new Customer("11111111110", "jack bauer", 1956, 
        		  "jack@example.com", "555 5555");
          System.out.println(jack.getFullname());
          System.out.println(jack.getEmail());
          jack.setEmail("jack.bauer@example.com");
          System.out.println(jack.getEmail());
          System.out.println(jack);
          System.out.println(jack.toString());
          System.out.println(jack.getClass());
	}
}
