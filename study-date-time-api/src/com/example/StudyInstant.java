package com.example;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;

public class StudyInstant {

	public static void main(String[] args) {
		// LocalDate, LocalTime, LocalDateTime, ZonedDateTime
		// Period     Duration
		// Instant
		var now = ZonedDateTime.now();
		var t1 = now.toInstant();
		var t2 = Instant.parse("2018-07-18T17:15:00Z");
		System.out.println(t2);
		System.out.println(Duration.between(t1, t2));
	}

}
