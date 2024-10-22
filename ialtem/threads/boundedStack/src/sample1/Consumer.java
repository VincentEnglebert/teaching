package sample1;

/**
 * @author Vincent Englebert
 */

import java.util.Random;

import stack.MyStack;

public class Consumer extends Thread {
	private final Random r = new Random();
	private final MyStack<Integer> stack;

	public Consumer(MyStack<Integer> stack) {		
		assert stack != null;

		this.stack = stack;
		start();
	}

	public void run() {
		while (true) {
			System.out.printf("r(%d)", stack.pop());
			try {
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
