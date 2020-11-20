package com.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class CreatingSpecificDateAndTime {

	public static void main(String[] args) {
		var birthDate1 = LocalDate.of(1973, Month.JULY, 11);
		var birthDate2 = LocalDate.of(1973, 7, 11);
		var time1 = LocalTime.of(9, 5);
		var time2 = LocalTime.of(9, 5, 30);
		var time3 = LocalTime.of(9, 5, 30, 200);
        LocalDate.of(2020, Month.FEBRUARY, 30);
	}

}
