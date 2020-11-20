package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class StudyPeriod {

	public static void main(String[] args) {
		var annually = Period.ofYears(1);
		var quarterly = Period.ofMonths(3);
		var everyYearAndAWeek = Period.of(1, 0, 7);
		LocalDate date = LocalDate.of(2020, 7, 11);
		LocalTime time = LocalTime.of(6, 15);
		LocalDateTime ldt = LocalDateTime.of(date,time);
		ldt = ldt.plus(quarterly);
	}

}
