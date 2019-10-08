package design_patterns.observer.example;

import java.util.HashMap;
import java.util.Map;

import design_patterns.observer.ObservableOptim;

public class Data extends ObservableOptim {

	public class NotFound extends Exception {
		private static final long serialVersionUID = 1L;
	}

	public static final String SPORT = "sport";
	public static final String PHYSIQUE = "physique";
	public static final String MATH = "math";
	Map<Pair3<String, String>, Integer> points = new HashMap<Pair3<String, String>, Integer>();

	Data() {
		set("Tintin", MATH, 10);
		set("Tintin", PHYSIQUE, 10);
		set("Tintin", SPORT, 10);

		set("Spirou", MATH, 10);
		set("Spirou", PHYSIQUE, 10);
		set("Spirou", SPORT, 10);

		set("Spirou", MATH, 10);
		set("Spirou", PHYSIQUE, 10);
		set("Spirou", SPORT, 10);
	}

	public void set(String etudiant, String cours, int cote) {
		Pair3<String, String> key = new Pair3<String, String>(etudiant, cours);
		Integer old = points.get(key);
		if (old == null) {
			points.put(key, cote);
			setChanged();
		} else {
			if (old.intValue() != cote) {
				points.remove(key);
				points.put(key, cote);
				setChanged();
			} else {
				// cote non modifiée !
			}
		}
		notifyObservers();
	}

	public int get(String etudiant, String cours) throws NotFound {
		Integer old = points.get(new Pair3<String, String>(etudiant, cours));
		if (old == null) {
			throw new NotFound();
		} else {
			return old.intValue();
		}
	}

}
