package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Functional Test for Account class")
class AccountTest {

	@DisplayName("creates an account object successfuly")
    @ParameterizedTest
	@CsvFileSource(resources = "/accounts.csv")
	void createAccount(String iban,double balance) {
		// 1. Setup/Fixture + 2. Call exercise method
		Account acc = new Account(iban, balance);
		// 3. verification
		assertEquals(iban, acc.getIban());
		assertEquals(balance, acc.getBalance());
		// 4. tear-down
		// empty
	}

}
