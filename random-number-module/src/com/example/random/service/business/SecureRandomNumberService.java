package com.example.random.service.business;

import java.security.SecureRandom;

import com.example.random.service.RandomNumberService;

public class SecureRandomNumberService implements RandomNumberService {
	private SecureRandom random = new SecureRandom();

	@Override
	public int generate(int begin, int end) {
		System.out.println("SecureRandomNumberService::generate");
		return random.nextInt(end - begin + 1) + begin;
	}

}
