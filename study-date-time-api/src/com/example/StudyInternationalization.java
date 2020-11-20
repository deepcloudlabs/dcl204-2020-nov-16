package com.example;

import java.text.DecimalFormat;
import java.util.Locale;

public class StudyInternationalization {

	public static void main(String[] args) {
		//i18n
		Locale locale = new Locale("tr","TR"); //ISO2
		String city = "izmir";
		System.out.println(city.toUpperCase(locale));
		double money = 123456.78;
		DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.ITALY);
		System.out.println(df.format(money));
	}

}
