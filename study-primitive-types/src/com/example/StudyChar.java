package com.example;

public class StudyChar {

	public static void main(String[] args) {
		char c = 'x'; // 2-byte, unicode encoded
		System.out.println((char)(c+1));
		char t = '\u20BA';
		System.out.println(t);
	}

}
