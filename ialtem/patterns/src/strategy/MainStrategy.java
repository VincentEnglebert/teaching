package strategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainStrategy {

	public static void main(String[] args) {

		// Main denotes here the context in the strategy pattern.

		System.out.println("Calculate the best path between 2 cities for each user\n"
				+ "according to their preferences (i. e. a specific strategy)\n");

		Map<String, Strategy> preferences = new HashMap<>();
		preferences.put("vincent", new StrategyTouristPath());
		preferences.put("albert", new StrategyFastestPath());
		preferences.put("sophie", new StrategyShortestPath());

		for (String user : preferences.keySet()) {
			String[] path = preferences.get(user).computePath("Cloudcity", "Suncity");
			System.out.printf("Path for %s is %s\n", user, Arrays.toString(path));
		}
	}

}
