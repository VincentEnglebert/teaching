package configuration.pattern.example;

import org.apache.log4j.Logger;

import configuration.pattern.BadPreCondition;
import configuration.pattern.ConfigElement;

public class Repository implements ConfigElement {
	private Logger logger=Logger.getLogger(Repository.class);
	private Layer1 callback=null;
	

	public Layer1 getCallback() {
		return callback;
	}

	public void setCallback(Layer1 callback) {
		this.callback = callback;
	}

	@Override
	public void setup() throws BadPreCondition {
		logger.info("configure " + this.getClass().getSimpleName());
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

	public void store(String string) {
		logger.info("Repository.store :"+string);
		callback.ACK();
		
	}
}
