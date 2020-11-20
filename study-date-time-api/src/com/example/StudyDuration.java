package com.example;

import java.time.Duration;
import java.time.LocalTime;

public class StudyDuration {

	public static void main(String[] args) {
		var daily = Duration.ofDays(1);
		var hourly = Duration.ofHours(1);	
		LocalTime time = LocalTime.of(9, 5);
		time = time.plus(daily).plus(hourly);
	}

}
