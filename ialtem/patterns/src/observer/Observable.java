package observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Observable {
	private final Set<Observer> observers = new HashSet<Observer>();

	public void addObserver(Observer o) {
		assert o != null;

		observers.add(o);
	}

	public void deleteObserver(Observer o) {
		assert o != null;

		observers.remove(o);
	}

	public void notifyObservers() {
		for (final Observer o : observers) {
			o.notify(this);
		}
	}

}
