package debug;

public class Integrale {

	interface Function {
		double call(double arg);
	}

	static public double integrale(Function f, double a, double b, double step) {
		if (distance(a, b) < step) {
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
		Function f = new Function() {

			@Override
			public double call(double arg) {
				return Math.sin(arg);
			}
		};
		System.out.printf("%f\n", integrale(f, 0, Math.PI, 0.001));
	}

}
