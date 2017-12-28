package strategy;

public class StrategyFastestPath implements Strategy {

	@Override
	public String[] computePath(String fromCity, String toCity) {
		return new String[] { fromCity, "SpeedCity", "FastCity", toCity };
	}

}
