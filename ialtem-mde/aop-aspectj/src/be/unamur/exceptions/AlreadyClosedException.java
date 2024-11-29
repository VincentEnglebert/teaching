package be.unamur.exceptions;

public class AlreadyClosedException extends Exception {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyClosedException() {
	    super("System.in already closed"); // Call superclass constructor with message
	  }
}