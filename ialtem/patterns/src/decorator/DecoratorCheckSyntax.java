package decorator;

/**
 * 
 * @author V. Englebert
 * 
 * This decorator checks the syntax of the query.
 *
 */
public class DecoratorCheckSyntax extends Proxy {

	public DecoratorCheckSyntax(IReal real) {
		super(real);
	}

	@Override
	public long compute(String query) {
		if (check(query)) {
			return super.compute(query);
		} else {
			return Long.MIN_VALUE;
		}
	}

	private boolean check(String query) {
		return query!=null && query.matches("-?[0-9]+");
	}

}
