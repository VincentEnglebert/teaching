/**
 * @author Vincent Englebert
 */

package configuration.pattern;

public class BadPreCondition extends Exception {
	private static final long serialVersionUID = 1L;
	private final String msg;
	
	public BadPreCondition(String s) {
		msg=s;
	}
	
	public BadPreCondition() {
		this("");
	}

	public String getMsg() {
		return msg;
	}

}
