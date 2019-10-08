package design_patterns.observer.example;

import org.apache.log4j.BasicConfigurator;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BasicConfigurator.configure();

		Data donnee = new Data();
		Histogram histogram = new Histogram(donnee);
		Camembert camembert = new Camembert(donnee);
		Camembert camembert2 = new Camembert(donnee);

		donnee.set("Vincent", Data.MATH, 9); // -> OK
		donnee.set("Tintin", Data.MATH, 10); // -> NO
		donnee.set("Vincent", Data.MATH, 9); // -> NO
		donnee.set("Vincent", Data.MATH, 0); // -> OK
	}

}
