package com.example;

import java.time.ZoneId;

public class StudyZone {

	public static void main(String[] args) {
		ZoneId.getAvailableZoneIds()
		      .stream()
		      .filter(zone -> zone.contains("Asia"))
		      .sorted()
		      .forEach(System.out::println);

	}

}
