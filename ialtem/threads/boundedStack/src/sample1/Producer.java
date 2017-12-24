package sample1;

import java.util.Random;

import stack.MyStack;

public class Producer extends Thread {
	private Random r=new Random();
	private MyStack<Integer> stack;

	public Producer(MyStack<Integer> stack) {
		assert stack != null;

		this.stack = stack;
		start();
	}

	public void run() {
		while (true) {
			int n = 0;

			while (true) {
				stack.push(++n);
				try {
					Thread.sleep(r.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
	}
}
