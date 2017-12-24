package sample1;

import stack.BoundedStack;
import stack.MyStack;

/**
 * @author UNamur
 *
 */
public class Main1 {


	public static void main(String[] args) {
		MyStack<Integer> stack=new BoundedStack<>(10);
		
		for (int i=0;i<10;i++){
			new Consumer(stack);
		}
		
		for (int i=0;i<100;i++){
			new Producer(stack);
		}
		
	}

}
