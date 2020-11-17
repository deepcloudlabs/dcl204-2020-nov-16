package moon;

import earth.A;

public class C extends A {
	public void fun() {
		// error: x is private in A -> x++;
		y++;
		z++;
		// error: u is package private in A -> u++;
	}
}
