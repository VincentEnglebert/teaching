package generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Question2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		Collection<Integer> col = list;
		for (int e : col) {
			System.out.printf("%d\n", e);
		}

	}

}
