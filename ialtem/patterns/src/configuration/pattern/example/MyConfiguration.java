package configuration.pattern.example;

import configuration.MainConfiguration;
import configuration.pattern.Configuration;

public class MyConfiguration extends Configuration {

	@Override
	protected void assembly() {
		Layer1 layer1 = (Layer1) components.get(MainConfiguration.LAYER_1);
		Layer2 layer2 = (Layer2) components.get(MainConfiguration.LAYER_2);
		Layer3 layer3 = (Layer3) components.get(MainConfiguration.LAYER_3);
		Repository repository= (Repository) components.get(MainConfiguration.REPOSITORY);
		Audit audit=(Audit) components.get(MainConfiguration.AUDIT);
		Front front=(Front) components.get(MainConfiguration.FRONT);
		
		front.setLayer3(layer3);
		front.setAudit(audit);
		layer3.setLayer2(layer2);
		layer3.setAudit(audit);
		layer2.setAudit(audit);
		layer2.setLayer1(layer1);
		layer1.setAudit(audit);
		layer1.setRepository(repository);
		repository.setCallback(layer1);
				
	}

}



