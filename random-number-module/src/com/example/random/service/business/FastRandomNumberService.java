package com.example.random.service.business;

import java.util.concurrent.ThreadLocalRandom;

import com.example.random.service.RandomNumberService;

public class FastRandomNumberService implements RandomNumberService {

	@Override
	public int generate(int begin, int end) {
		return ThreadLocalRandom.current().nextInt(begin, end);
	}

}
