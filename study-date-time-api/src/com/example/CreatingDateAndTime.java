package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class CreatingDateAndTime {

	public static void main(String[] args) {
		var tr = new Locale("tr","TR");
		LocalDate localDate;
		LocalTime localTime;
		LocalDateTime localDateTime;
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
		DateTimeFormatter dtf = 
			DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
			                 .withLocale(Locale.CHINA);
		System.out.println(dtf.format(now));
	}

}
