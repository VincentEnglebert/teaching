package generics;

import java.util.HashSet;
import java.util.Set;

public class GenericMethod {

	/**
	 * 
	 * @param set
	 *            a set of T elements.
	 * @param element
	 *            a T element.
	 * @pre element and set are not null
	 * @return the member of <code>set</code> that equals <code>element</code>
	 *         and <code>null</code> otherwise.
	 */
	public static <T> T findSet(Set<T> set, T element) {
		assert set != null && element != null;
		for (T e : set) {
			if (element.equals(e)) {
				return e;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(findSet(set, 4));
		// System.out.println(findSet(set,"4"));
	}
}
