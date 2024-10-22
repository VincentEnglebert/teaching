package decorator;

/**
 * @author Vincent Englebert
 */


public class MainDecorator {

	public static void main(String[] args) {
		IReal real = new Real();
		IReal decoCheck = new DecoratorCheckSyntax(real);
		IReal decoLog = new DecoratorLogging(decoCheck);

		for (String query : new String[] { "15", "-15", "foo15", "", null }) {
			System.out.printf("Evaluation of \"%s\" is %d.\n", query,decoLog.compute(query));
		}
	}

}
