package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeOperations {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2100, 2, 27);
		System.out.println(date);
		date = date.plusDays(2);
		System.out.println(date);
		LocalTime time = LocalTime.of(9, 5);
		System.out.println(time);
		time = time.minusMinutes(10);
		System.out.println(time);
		// fluent api -> method chaining
		LocalDateTime ldt = LocalDateTime.of(date,time);
		System.out.println(ldt);
		ldt = ldt.minusDays(1).minusHours(10).minusSeconds(30);
		System.out.println(ldt);
	}

}
