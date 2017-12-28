package strategy;

public class StrategyTouristPath implements Strategy {

	@Override
	public String[] computePath(String fromCity, String toCity) {
		return new String[] { fromCity, "Paris", "Namur", "Tournai", "Bruxelles", toCity };
	}

}
