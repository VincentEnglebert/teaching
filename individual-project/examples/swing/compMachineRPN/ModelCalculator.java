package swing.compMachineRPN;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * A model for a RPN calculator. That model provides both the states and the
 * operations of a calculator.
 * 
 * @author Vincent
 * 
 */
public class ModelCalculator extends java.util.Observable {
	// / the internal stack of the calculator.
	private final Stack<Number> stack = new Stack<Number>();
	// / the input buffer when keys are pressed.
	private final StringBuffer buffer = new StringBuffer();
	// / the information displayed by the calculator.
	private String display = "0";

	/**
	 * A number.
	 * 
	 * @author Vincent
	 * 
	 */
	static class Number {
		public static final Number ZERO = new Number(0.0);
		final double value;

		Number(double v) {
			value = v;
		}

		@Override
		public String toString() {
			return Double.toString(value);
		}
	}

	/**
	 * An error is interpreted as the 0 value but is displayed as "ERR"
	 * 
	 * @author Vincent
	 * 
	 */
	static class Error extends Number {
		public Error() {
			super(0.0);
		}

		@Override
		public String toString() {
			return "ERR";
		}
	}

	/**
	 * A digit has been pressed.
	 * 
	 * @Pre 0 <= i <= 9
	 * @param i
	 */
	public void key(int i) {
		assert i >= 0 && i <= 9;
		buffer.append(Integer.toString(i));
		setDisplay(buffer.toString());
		setChanged();
		notifyObservers();
	}

	/**
	 * A "." has been pressed.
	 */
	public void point() {
		if (buffer.toString().indexOf('.') == -1) {
			buffer.append('.');
			setDisplay(buffer.toString());
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * 
	 * @return the top element of the stack and 0 otherwise. That element is
	 *         removed.
	 */
	private Number myPop() {
		try {
			return stack.pop();
		} catch (final EmptyStackException e) {
			return Number.ZERO;
		}
	}

	/**
	 * 
	 * @return the top element of the stack and 0 otherwise.
	 */
	private Number myPeek() {
		try {
			return stack.peek();
		} catch (final EmptyStackException e) {
			return Number.ZERO;
		}
	}

	/**
	 * Initializes the content of the display with val.
	 * 
	 * @pre val not null.
	 * @param val
	 */
	private void setDisplay(Number val) {
		assert val != null;
		display = val.toString();
		setChanged();
	}

	/**
	 * Initializes the content of the display with val.
	 * 
	 * @pre val not null.
	 * @param val
	 */
	private void setDisplay(String string) {
		assert string != null;
		display = string;
		setChanged();
	}

	/**
	 * Executes an addition (2 operands)
	 */
	public void plus() {
		consume();
		final Number b = myPop();
		final Number a = myPop();
		stack.push(new Number(a.value + b.value));
		setDisplay(myPeek());
		setChanged();
		notifyObservers();
	}

	/**
	 * executes a substraction (2 operands)
	 */
	public void minus() {
		consume();
		final Number b = myPop();
		final Number a = myPop();
		stack.push(new Number(a.value - b.value));
		setDisplay(myPeek());
		setChanged();
		notifyObservers();

	}

	/**
	 * Executes a division.
	 */
	public void divide() {
		consume();
		final Number b = myPop();
		final Number a = myPop();
		Number r;
		try {
			r = new Number(a.value / b.value);
		} catch (final Exception e) {
			r = new Error();
		}
		stack.push(r);
		setDisplay(myPeek());
		setChanged();
		notifyObservers();
	}

	/**
	 * Executes a multiplication.
	 */
	public void times() {
		consume();
		final Number b = myPop();
		final Number a = myPop();
		stack.push(new Number(a.value * b.value));
		setDisplay(myPeek());
		setChanged();
		notifyObservers();
	}

	/**
	 * Push the buffer on the stack.
	 */
	public void enter() {
		consume();
		setDisplay(getPeek());
		setChanged();
		notifyObservers();
	}

	/**
	 * Consumes the buffer and add its value on the stack. The buffer is
	 * cleaned.
	 */
	private void consume() {
		if (buffer.length() > 0) {
			try {
				final double d = Double.parseDouble(buffer.toString());
				stack.push(new Number(d));
			} catch (final NumberFormatException e) {
				stack.push(new Error());
			}
			buffer.delete(0, buffer.length());
		}
	}

	/**
	 * 
	 * @return the value of the display.
	 */
	public String getDisplay() {
		return display.toString();
	}

	/**
	 * 
	 * @return the element on the stack.
	 */
	private Number getPeek() {
		return myPeek();
	}

}
