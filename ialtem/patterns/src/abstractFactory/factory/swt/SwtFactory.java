package abstractFactory.factory.swt;

import abstractFactory.factory.AbstractFactory;
import abstractFactory.factory.Button;
import abstractFactory.factory.Label;
import abstractFactory.factory.TextField;
import abstractFactory.factory.Window;

public class SwtFactory extends AbstractFactory{

	@Override
	public Window buildWindow() {
		return new SwtWindow();
	}

	@Override
	public Button buildButton(String label) {
		return  new SwtButton(label);
	}

	@Override
	public TextField buildTextField(String label, int length) {
		return new SwtTextField(label,length);
	}

	@Override
	public Label buildLabel(String label) {
		return new SwtLabel(label);
	}

}
