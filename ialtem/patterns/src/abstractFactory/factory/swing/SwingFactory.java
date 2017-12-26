package abstractFactory.factory.swing;

import abstractFactory.factory.AbstractFactory;
import abstractFactory.factory.Button;
import abstractFactory.factory.Label;
import abstractFactory.factory.TextField;
import abstractFactory.factory.Window;

public class SwingFactory extends AbstractFactory{
	
	public SwingFactory(){
		
	}

	@Override
	public Window buildWindow() {
		return new SwingWindow();
	}

	@Override
	public Button buildButton(String label) {
		return  new SwingButton(label);
	}

	@Override
	public TextField buildTextField(String label, int length) {
		return new SwingTextField(label,length);
	}

	@Override
	public Label buildLabel(String label) {
		return new SwingLabel(label);
	}

}
