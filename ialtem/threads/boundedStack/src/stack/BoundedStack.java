package stack;

/**
 * @author Vincent Englebert
 */

public class BoundedStack<E> implements MyStack<E> {
	private int max_size;
	private E stack[];
	private int top;

	@SuppressWarnings("unchecked")
	public BoundedStack(int max_size) {
		assert max_size >= 0;

		this.top = 0;
		this.max_size = max_size;
		stack = (E[]) new Object[max_size];
	}

	public synchronized void push(E item) {
		assert item != null;

		while (is_full()) {
			try {
				System.out.println("push waiting");
				wait();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		stack[top] = item;
		top++;
		notifyAll();
	}

	public synchronized E pop() {
		while (is_empty()) {
			try {
				System.out.println("pop waiting");
				wait();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		notifyAll();
		top--;
		return stack[top];
	}

	public synchronized E top() {
		while (is_empty()) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		notifyAll();
		return stack[top - 1];
	}

	protected boolean is_empty() {
		return top == 0;
	}

	protected boolean is_full() {
		return top == max_size;
	}
}
