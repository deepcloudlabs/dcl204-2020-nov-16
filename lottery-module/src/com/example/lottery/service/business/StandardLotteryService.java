package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberService;

public class StandardLotteryService implements LotteryService {
	private RandomNumberService randomNumberService;
	
	public void setRandomNumberService(RandomNumberService randomNumberService) {
		this.randomNumberService = randomNumberService;
	}

	@Override
	public List<Integer> draw(int max, int length) {
		return IntStream.generate( () -> randomNumberService.generate(1, max))
				     .distinct()
				     .limit(length)
				     .sorted()
				     .boxed()
				     .collect(Collectors.toList());
	}

	@Override
	public List<List<Integer>> draw(int max, int length, int column) {
		return IntStream.range(0, column)
				     .mapToObj(i -> this.draw(max, length))
				     .collect(Collectors.toList());
	}

}
