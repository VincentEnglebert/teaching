package observer.example;

import org.apache.log4j.Logger;

import observer.Observable;
import observer.Observer;

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
