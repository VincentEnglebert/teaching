package configuration.pattern.example;

import configuration.pattern.Configuration;

public class ISOConfiguration extends Configuration {

	@Override
	protected void assembly() {
		ISOLayer1 l1 = (ISOLayer1) components.get("Layer 1");
		ISOLayer2 l2 = (ISOLayer2) components.get("Layer 2");
		ISOLayer3 l3 = (ISOLayer3) components.get("Layer 3");

		l1.setUp(l2);
		l2.setUp(l3);
		l3.setDown(l2);
		l2.setDown(l1);
	}

}
