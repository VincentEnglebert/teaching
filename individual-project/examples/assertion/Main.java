package assertion;

public final class Main {

	static {
		// ensures that the class has not been renamed.
		// may be useful if that class is referenced from shell scripts for
		// instance.
		assert "Main".equals(new Main().getClass().getSimpleName());
	}

	static protected int factrec(int arg) {
		assert arg >= 0;
		final int r = (arg == 0) ? 1 : arg * factrec(arg - 1);
		// assert r==factorial(arg);
		return r;
	}

	static protected int factorial(final int arg) {
		assert arg >= 0 : "arg must be >=0";
		int i = arg;
		int r = 1;
		while (i > 0) {
			r = r * i;
			i--;
		}
		assert r == factrec(arg);
		return r;
	}

	public static void main(String[] args) {
		System.out.printf("10!=%d\n", factorial(10));
		System.out.printf("-1!=%d\n", factorial(-1));
	}

}
