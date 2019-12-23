package decorator;

/**
 * 
 * @author V. Englebert
 * 
 * This decorator logs all the calls before and after the delegation.
 *
 */
public class DecoratorLogging extends Proxy {

	public DecoratorLogging(IReal real) {
		super(real);
	}

	@Override
	public long compute(String query) {
		System.out.printf("Query sent :%s\n", (query==null) ? "<null>": query);
		long result= super.compute(query);
		System.out.printf("Answer is %d\n", result);
		return result;
	}

}
