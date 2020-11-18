package com.example.lottery.service;

import java.util.List;

public interface LotteryService {
	List<Integer> draw(int max,int length);
	List<List<Integer>> draw(int max,int length,int column);
}
