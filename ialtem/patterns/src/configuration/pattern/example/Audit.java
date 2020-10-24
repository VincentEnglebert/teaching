package configuration.pattern.example;

import org.apache.log4j.Logger;

import configuration.pattern.BadPreCondition;
import configuration.pattern.ConfigElement;

public class Audit implements ConfigElement {
	Logger logger = Logger.getLogger(Audit.class);

	@Override
	public void setup() throws BadPreCondition {
		logger.info("configure "+ this.getClass().getSimpleName());
	}

	@Override
	public void reset() {
		logger.info("reset "+ this.getClass().getSimpleName());
	}

	@Override
	public void turnOn() {
		logger.info("Turn on "+ this.getClass().getSimpleName());		
	}

	@Override
	public void turnOff() {
		logger.info("Turn off  "+ this.getClass().getSimpleName());		
	}

	public void trace(String string) {
		logger.info("Audit.trace("+string+")");
	}


}
