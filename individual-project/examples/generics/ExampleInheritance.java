package generics;

import java.util.LinkedList;
import java.util.List;

public class ExampleInheritance {

	static public void main(String args[]) {
		final List<Integer> listint = new LinkedList<Integer>();
		final List nlist = listint;
		final List<String> liststring = nlist;
		liststring.add("I'm not an integer !");
		for (final String s : liststring) {
			System.out.println(s);
		}
		System.out.flush();
		for (final Integer i : listint) {
			System.out.println(i);
		}
	}

}
