package observer.example;

import java.util.HashMap;
import java.util.Map;

import observer.ObservableOptim;

public class Data extends ObservableOptim {

	public class NotFound extends Exception {
		private static final long serialVersionUID = 1L;
	}

	public static final String SPORT = "sport";
	public static final String PHYSICS = "physics";
	public static final String MATH = "math";
	Map<Pair<String, String>, Integer> points = new HashMap<Pair<String, String>, Integer>();

	public Data() {
		set("Tintin", MATH, 10);
		set("Tintin", PHYSICS, 10);
		set("Tintin", SPORT, 10);

		set("Spirou", MATH, 10);
		set("Spirou", PHYSICS, 10);
		set("Spirou", SPORT, 10);

		set("Spirou", MATH, 10);
		set("Spirou", PHYSICS, 10);
		set("Spirou", SPORT, 10);
	}

	public void set(String student, String lesson, int score) {
		Pair<String, String> key = new Pair<String, String>(student, lesson);
		Integer old = points.get(key);
		if (old == null) {
			points.put(key, score);
			setChanged();
		} else {
			if (old.intValue() != score) {
				points.remove(key);
				points.put(key, score);
				setChanged();
			} else {
				// unmodified score __
			}
		}
		notifyObservers();
	}

	public int get(String student, String lesson) throws NotFound {
		Integer old = points.get(new Pair<String, String>(student, lesson));
		if (old == null) {
			throw new NotFound();
		} else {
			return old.intValue();
		}
	}

}
