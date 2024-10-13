/**
 * @author V. Englebert
 *
 */

package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
	// Création d'un logger
	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		// BasicConfigurator.configure();
		Logger LOGGER = LogManager.getRootLogger();

		LOGGER.debug("Debug Message Logged !!");
		LOGGER.info("Info Message Logged !!");
		LOGGER.debug("Another Debug Message !!");
	}
}
