package generics;

import java.util.LinkedList;
import java.util.List;

public class ExampleNative {

	static void pass(List<Number> listnum) {
		listnum.add(3.1416); // this operation should be eligible for every
								// list<Number>
	}

	static void main(String args[]) {
		final List<Integer> listint = new LinkedList<Integer>();
		listint.add(2);
		// pass(listint);
	}

}
