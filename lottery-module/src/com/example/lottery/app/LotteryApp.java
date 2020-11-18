package com.example.lottery.app;

import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.RandomNumberService;

public class LotteryApp {

	public static void main(String[] args) {
		StandardLotteryService lotterySrv = 
				new StandardLotteryService();
		ServiceLoader<RandomNumberService> randomNumberServices =
				ServiceLoader.load(RandomNumberService.class);
		for (RandomNumberService rns : randomNumberServices) {
			System.out.println(rns.getClass());
		    lotterySrv.setRandomNumberService(rns);
		    lotterySrv.draw(70, 6, 1).forEach(System.out::println);
		}
	}

}
