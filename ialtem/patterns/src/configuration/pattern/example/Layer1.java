package configuration.pattern.example;

import org.apache.log4j.Logger;

import configuration.pattern.BadPreCondition;

public class Layer1 extends Layer {
	private Logger logger = Logger.getLogger(Layer1.class);
	private Repository repository = null;

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	private Audit audit = null;

	@Override
	public void setup() throws BadPreCondition {
		logger.info("configure " + this.getClass().getSimpleName());
	}

	@Override
	public void reset() {
		logger.info("reset " + this.getClass().getSimpleName());
	}

	@Override
	public void turnOn() {
		logger.info("Turn on " + this.getClass().getSimpleName());
	}

	@Override
	public void turnOff() {
		logger.info("Turn off  " + this.getClass().getSimpleName());
	}

	public void send(String string) {
		logger.info("Layer1.send");
		audit.trace(string);
		repository.store(string);
	}

	public void ACK() {
		logger.info("Layer1.ACK");
	}

}
