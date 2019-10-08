package generics;

public class Pair2<A, B> {

	public final A first;
	public final B second;

	public Pair2(A f, B s) {
		first = f;
		second = s;
	}

	public Pair2<A, B> setFirst(A f) {
		return new Pair2<A, B>(f, second);
	}

	public Pair2<A, B> setSecond(B s) {
		return new Pair2<A, B>(first, s);
	}

	@Override
	public String toString() {
		return String.format("(%s,%s)", first == null ? "null" : first.toString(),
				second == null ? "null" : second.toString());
	}

	public static void main(String[] args) {
		Pair2<String, String> p = new Pair2<String, String>("Vincent", "prof");
		System.out.println(p.toString());
		// Pair2<String, String> q = p.setSecond(20);
		// System.out.println(q.toString());
	}

}
