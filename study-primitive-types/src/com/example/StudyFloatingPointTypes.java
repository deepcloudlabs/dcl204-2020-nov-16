package com.example;

import java.math.BigDecimal;

public class StudyFloatingPointTypes {

	public static void main(String[] args) {
		// IEEE-754 -> FPU
		float f = 3.1415F; // 4 Byte
		double g = 2.0; // 8 Byte
		g = g - 1.10;
		if (g == 0.9) {

		}
		System.out.println(String.format("%16.16f", g));
		f = 1_000_000_000;
		f = f + 50;
		System.out.println(String.format("%16.3f", f));
		double u = (0.1 + 0.2) + 0.3;
		double v = 0.1 + ( 0.2 + 0.3);
		System.out.println(u == v);
		// BigDecimal immutable
        BigDecimal bd = BigDecimal.valueOf(1_000_000_000.);
        bd = bd.add(BigDecimal.valueOf(50));
        System.out.println(bd);
        double q = 0.0/0.0;
        System.out.println(q);
        q++;
        System.out.println(u==u);
        System.out.println((q==q)==false);
        Double.isNaN(q);
	}

}
