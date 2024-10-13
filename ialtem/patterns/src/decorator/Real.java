package decorator;

/**
 * @author Vincent Englebert
 */


public class Real implements IReal {

	/*
	 * (non-Javadoc)
	 * 
	 * @see Proxy.IReal#compute(java.lang.String)
	 * 
	 * Compute the numerical expression of query.
	 * @pre query must not be null and must denote a correct expression.
	 */
	@Override
	public long compute(String query) {
		return Long.parseLong(query);
	}

}
