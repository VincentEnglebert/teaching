package test_unitaire;

/**
 * 
 * @author Gaston Lagaffe
 *
 */
public class SuperBugger {

	public static class BadPrecondition extends Exception {
		private static final long serialVersionUID = 1L;
	}

	/**
	 * 
	 * @param nà
	 *            >=0
	 * @return the factorial of <code> n</code>
	 * @throws BadPrecondition
	 */
	static public int factorial(int n) throws BadPrecondition {
		if (n<0) {
			throw new BadPrecondition();
		}
		if (n == 0) {
			return 1;
		} else {
			return (n == 1) ? 1 : n * factorial(n - 1);
		}
	}

}
