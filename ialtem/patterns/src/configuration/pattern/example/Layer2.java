package configuration.pattern.example;

import org.apache.log4j.Logger;

import configuration.pattern.BadPreCondition;

public class Layer2 extends Layer {
	private Logger logger = Logger.getLogger(Layer2.class);
	private Audit audit=null;
	private Layer1 layer1=null;


	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public Layer1 getLayer1() {
		return layer1;
	}

	public void setLayer1(Layer1 layer1) {
		this.layer1 = layer1;
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

	public void send(String string) {
		logger.info("Layer2.send");
		audit.trace(string);
		layer1.send(string);		
	}



}
