package com.example;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		byte b = 127; // 1 Byte -> signed int -> [-128..127]
		System.out.println("b="+b);
		b+=2; // b = (byte) (b + 2);
		b++; // b = (byte)(b + 1);
		System.out.println("b="+b);
		short s = Short.MAX_VALUE; // 2 Byte, [-32768..32767]
		System.out.println("s="+s);
        s++;
        System.out.println("s="+s);
        int i= Integer.MAX_VALUE; // 4 Byte
        long l= 108; // 8 Byte
        l = 12345 + 5432L;
        l = i + 1L;
        System.out.println("l= "+l);
        byte x=3, y=5,z;
        z = (byte) (x + y);
        l = Long.MAX_VALUE;
        System.out.println("l="+l);
        l++;
        System.out.println("l="+l);
        // Immutable Class 
        BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println("bi="+bi);
        bi = bi.add(BigInteger.ONE);
        System.out.println("bi="+bi);
        String jack = "Jack"; // Immutablle
        jack = jack.toUpperCase();
        System.out.println(jack);
        // Wrapper Classes: primitive -> Class, Immutable
        // int -> Integer
        // byte -> Byte
        // short -> Short
        // long -> Long
        // char -> Character
        // boolean -> Boolean
        // float -> Float
        // double -> Double
        // int: 4B, 1M ints -> 4MB
        // Integer -> Object Header -> 12B + 4B -> 16B -> 16MB (12MB overhead)
        // Class -> OOP
        ThreadLocalRandom.current()
                         .ints(1, 60) // int
                         .distinct()
                         .limit(6)
                         .sorted()
                         .boxed() // int -> Integer
                         .collect(Collectors.toList())
                         .forEach(System.out::println);
        int []array1 = {1,2,3,4,5};
        Integer []array2 = {1,2,3,4,5};
        Integer u = Integer.valueOf(42); // Java SE 5: Auto Boxing
        int v = u.intValue(); // Unboxing
        Integer w = 108;
        u = Integer.valueOf(u.intValue() + w.intValue());
        int r = 0/0;
        System.out.println(r);
        
	}

}
