package configuration.pattern.example;

import org.apache.log4j.Logger;

import configuration.pattern.BadPreCondition;
import configuration.pattern.ConfigElement;

public class Front implements ConfigElement {
	Logger logger = Logger.getLogger(Front.class);
	private Layer3 layer3=null;
	private Audit audit=null;
	
	public Layer3 getLayer3() {
		return layer3;
	}

	public void setLayer3(Layer3 layer3) {
		this.layer3 = layer3;
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

	public void sendMessage(String string) {
		assert string!=null;
		
		logger.info("Front.sendMessage");
		audit.trace("Front sending message:"+string);
		layer3.send(string);		
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

}
