package stack;


/**
 * 
 * @author V. Englebert
 *
 * @param <E> Type of elements
 * 
 */

public interface MyStack<E> {
	public void push(E item);

	public E pop();

	public E top();
}