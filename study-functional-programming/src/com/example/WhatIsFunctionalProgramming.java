package com.example;

@SuppressWarnings("unused")
public class WhatIsFunctionalProgramming {

	public static void main(String[] args) {
		// value -> primitive types: byte, short, int, long, float, double, char, boolean
		int x = 42; 
        String y = "jack" ; // Class -> String, Reference Variable
        // 1. Anonymous Class
        Fun z1 = new Fun() {

			@Override
			public int f(int u) {
				return u*u*u;
			}
        	
        };
        System.out.println(z1.f(2));
        // 2. Lambda Expression
        Fun z2 = (int u) -> { return u*u*u; };
        Fun z3 = (u) -> { return u*u*u; };
        Fun z4 = u -> { return u*u*u; };
        Fun z5 = u -> u*u*u ;
        // 3. Method Reference ::
        Fun z6 = Gun::sun;
        A a= new A();
        Fun z7 = a::run;
        // Method Reference -> Lambda Expression
        // Object Oriented Programming -> Class
        // Functional Programming      -> Functional Interface
	}

}
class A {
	public int run(int v) {
		return v*v;
	}
}
class Gun {
	public static int sun(int y) {
		return y*y*y*y;
	}
}
@FunctionalInterface
interface Fun {
	int f(int x); // SAM: Single Abstract Method
}
