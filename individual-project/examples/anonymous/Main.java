package anonymous;

public class Main {

	private static final Function sinus = new Function() {

		@Override
		public double call(double arg) {
			return Math.sin(arg);
		}
	};

	@SuppressWarnings("unused")
	static public void main(String[] args) {

		final double result = sinus.call(2);

		final double cosoftwo = new Function() {
			@Override
			public double call(double arg) {
				return Math.cos(arg);
			}
		}.call(2);

	}

}
