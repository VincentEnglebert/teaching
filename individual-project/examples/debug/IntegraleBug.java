package debug;

public class IntegraleBug {

	interface Function {
		double call(double arg);
	}

	static public double integrale(Function f, double a, double b, double step) {
		if (distance(a, b) <= step) {
			return distance(a, b) * f.call(a);
		} else {
			return step * f.call(a) + integrale(f, a + step, b, step);
		}
	}

	static private double distance(double a, double b) {
		return absolute(a - b);
	}

	static private double absolute(double d) {
		return d < 0.0 ? -d : d;
	}

	public static void main(String args[]) {
		final Function f = new Function() {

			// Hint: integrale(2*x)=x^2

			@Override
			public double call(double arg) {
				return arg * 2;
			}
		};

		System.out.printf("%f\n", integrale(f, 0, 10, 0.01));
	}

}
