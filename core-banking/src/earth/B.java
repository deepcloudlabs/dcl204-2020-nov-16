package earth;

public class B extends A {
	public void fun() {
		// error: x is private in A -> x++;
		y++;
		z++;
		u++;
	}
}
