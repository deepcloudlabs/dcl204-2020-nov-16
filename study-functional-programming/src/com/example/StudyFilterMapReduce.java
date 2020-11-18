package com.example;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudyFilterMapReduce {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
		// Build-in Functional Interfaces: Predicate, Function, BinaryOperator
		Predicate<Integer> isEven = x -> x%2 == 0; 
		Function<Integer, Integer> squared = y -> y * y;
		BinaryOperator<Integer> accumulate = (acc,v) -> acc + v;
        int sum = numbers.stream()
        	//.parallel()
               .filter(isEven)
               .map(squared)
               .reduce(0, accumulate);
        System.out.println("sum= "+sum);
        sum = 0;
        for (int number : numbers) {
        	if (number%2 == 0)
        		sum = sum + number*number;
        }
        System.out.println("sum= "+sum);
	}

}
