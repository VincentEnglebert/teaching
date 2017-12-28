package configuration.pattern.example;

import org.apache.log4j.Logger;

import configuration.pattern.BadPreCondition;

public class ISOLayer2bug extends ISOLayer2 {
	Logger logger = Logger.getLogger(ISOLayer2bug.class);

	@Override
	public void configure() throws BadPreCondition {
		logger.info("problem while configuring Layer 2 ");
		throw new BadPreCondition();
	}

}
