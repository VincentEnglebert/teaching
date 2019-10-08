package design_patterns.observer.example;

import org.apache.log4j.Logger;

import design_patterns.observer.Observable;
import design_patterns.observer.Observer;

public class Camembert implements Observer {
	private static Logger logger = Logger.getLogger(Camembert.class);

	public Camembert(Data data) {
		data.addObserver(this);
	}

	@Override
	public void notify(Observable subject) {
		logger.info("camembert notified");

	}

}
