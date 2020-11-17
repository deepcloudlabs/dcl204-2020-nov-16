package moon;

import earth.A;

public class D {
	public void gun(A a) {
		// private -> a.x++;
		a.y++;
		// error:  a.z++; // protected -> default
		// error: a.u++;
	}
}
