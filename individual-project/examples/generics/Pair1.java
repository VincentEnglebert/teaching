/**
 * 
 */
package generics;

public class Pair1 {

	public final Object first;
	public final Object second;

	public Pair1(Object f, Object s) {
		first = f;
		second = s;
	}

	public Pair1 setFirst(Object f) {
		return new Pair1(f, second);
	}

	public Pair1 setSecond(Object s) {
		return new Pair1(first, s);
	}

	@Override
	public String toString() {
		return String.format("(%s,%s)", first == null ? "null" : first.toString(),
				second == null ? "null" : second.toString());
	}

	public static void main(String[] args) {
		Pair1 pair = new Pair1("Vincent", "prof");
		pair = pair.setSecond(new Integer(20));
		String role = (String) pair.second;
		System.out.println(role);
	}

}
