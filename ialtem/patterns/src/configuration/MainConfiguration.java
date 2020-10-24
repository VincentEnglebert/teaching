package configuration;

import org.apache.log4j.Logger;

import configuration.pattern.BadPreCondition;
import configuration.pattern.example.Audit;
import configuration.pattern.example.Front;
import configuration.pattern.example.MyConfiguration;
import configuration.pattern.example.Layer1;
import configuration.pattern.example.Layer2;
import configuration.pattern.example.Layer3;
import configuration.pattern.example.Repository;

public class MainConfiguration {

	public static final String FRONT = "Front";
	public static final String REPOSITORY = "Repository";
	public static final String AUDIT = "Audit";
	public static final String LAYER_3 = "Layer 3";
	public static final String LAYER_2 = "Layer 2";
	public static final String LAYER_1 = "Layer 1";

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(MainConfiguration.class);

		Front front=new Front();
		Repository repository=new Repository();
		Audit audit=new Audit();
		Layer1 layer1 = new Layer1();
		Layer2 layer2 = new Layer2();
		Layer3 layer3 = new Layer3();

		try {
			MyConfiguration config = new MyConfiguration();
			config.addComponent(LAYER_1, layer1);
			config.addComponent(LAYER_2, layer2);
			config.addComponent(LAYER_3, layer3);
			config.addComponent(AUDIT, audit);
			config.addComponent(REPOSITORY, repository);
			config.addComponent(FRONT, front);
			config.configure();
		} catch (BadPreCondition e) {
			logger.error("Problem during configuration");
		}

		front.sendMessage("Oufti, this works !");

	}
}

