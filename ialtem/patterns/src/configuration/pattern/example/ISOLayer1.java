package configuration.pattern.example;

import org.apache.log4j.Logger;

import configuration.pattern.BadPreCondition;

public class ISOLayer1 extends ISOLayer {
	Logger logger = Logger.getLogger(ISOLayer1.class);

	@Override
	public void configure() throws BadPreCondition {
		logger.info("configure Layer 1 ");
	}

	@Override
	public void reset() {
		logger.info("reset Layer 1 ");

	}

}
