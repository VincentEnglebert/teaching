package anonymous;

public class MainG {

	private static final GFunction<Double> sinus = new GFunction<Double>() {

		@Override
		public Double call(Double arg) {
			return Math.sin(arg);
		}
	};

	@SuppressWarnings("unused")
	static public void main(String[] args) {

		final double result = sinus.call(2.0);

	}

}
