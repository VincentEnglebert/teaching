package design_patterns.observer.example;

import org.apache.log4j.Logger;

import design_patterns.observer.Observable;
import design_patterns.observer.Observer;

public class Histogram implements Observer {
	static private Logger logger = Logger.getLogger(Histogram.class);

	public Histogram(Data data) {
		data.addObserver(this);
	}

	@Override
	public void notify(Observable subject) {
		logger.info("histogram notified");
	}

}
