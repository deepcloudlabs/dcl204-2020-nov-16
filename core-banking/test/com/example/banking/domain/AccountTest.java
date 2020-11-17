package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Functional Test for Account class")
class AccountTest {

	@DisplayName("creates an account object successfuly")
	@ParameterizedTest
	@CsvFileSource(resources = "/accounts.csv")
	void createAccount(String iban, double balance) {
		// 1. Setup/Fixture + 2. Call exercise method
		Account acc = new Account(iban, balance);
		// 3. verification
		assertEquals(iban, acc.getIban());
		assertEquals(balance, acc.getBalance());
		assertEquals(AccountStatus.ACTIVE, acc.getStatus());
		// 4. tear-down
		// empty
	}

	@ParameterizedTest
	@ValueSource(doubles = { -1., 0.0, -0.1 })
	@DisplayName("withdraw negative amount should return false")
	void withdrawNegativeAmountShouldReturnFalse(double amount) {
		Account account = new Account("tr1", 10_000);
		assertFalse(account.withdraw(amount));
		assertEquals(10_000., account.getBalance());
	}

	@ParameterizedTest
	@ValueSource(doubles = { 10_001, 10_000.1, 10_100. })
	@DisplayName("withdraw amount greater than balance should return false")
	void withdrawOverBalanceShouldReturnFalse(double amount) {
		Account account = new Account("tr1", 10_000);
		assertFalse(account.withdraw(amount));
		assertEquals(10_000., account.getBalance());
	}

	@ParameterizedTest
	@ValueSource(doubles = { 0.1, 1.0, 10_000.0 })	
	@DisplayName("withdraw all balance should return true")
	void withdrawAllBalanceShouldReturnTrue(double balance) {
		Account account = new Account("tr1", balance);
		assertTrue(account.withdraw(balance));
		assertEquals(0., account.getBalance());
	}

	@ParameterizedTest
	@ValueSource(doubles = { -1., 0.0, -0.1 })	
	@DisplayName("deposit with negative amount should return false")
	void depositiveNegativeAmountShouldReturnFalse(double amount) {
		Account account = new Account("tr1", 10_000);
		assertFalse(account.deposit(amount));
		assertEquals(10_000, account.getBalance());
	}

	@ParameterizedTest
	@CsvSource({
		"0.0,1.0,1.0",
		"0.0,0.1,0.1",
		"100.0,100.0,200.0"
	})
	@DisplayName("deposit with positive amount should return true")
	void depositivePositiveAmountShouldReturnTrue(double balance,double amount,double newBalance) {
		Account account = new Account("tr1", balance);
		assertTrue(account.deposit(amount));
		assertEquals(newBalance, account.getBalance());
	}

	@Test
	@DisplayName("toString() should contain Account")
	void toStringShouldContainAccount() {
		Account account = new Account("tr1", 10_000);
		assertTrue(account.toString().contains("Account"));
	}

}
