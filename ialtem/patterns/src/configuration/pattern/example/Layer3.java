package configuration.pattern.example;

import org.apache.log4j.Logger;

import configuration.pattern.BadPreCondition;

public class Layer3 extends Layer {
	private Logger logger = Logger.getLogger(Layer3.class);
	private Layer2 layer2=null;
	public Layer2 getLayer2() {
		return layer2;
	}

	public void setLayer2(Layer2 layer2) {
		this.layer2 = layer2;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	private Audit audit=null;
	

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
		logger.info("Layer3.send");
		audit.trace(string);
		layer2.send(string);		
	}

}
