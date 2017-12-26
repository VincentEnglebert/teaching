package abstractFactory;

import abstractFactory.factory.AbstractFactory;
import abstractFactory.factory.Button;
import abstractFactory.factory.TextField;
import abstractFactory.factory.Window;
import abstractFactory.factory.swt.SwtFactory;

public class Main {
// 	static public final AbstractFactory factory=new SwingFactory();
	static public final AbstractFactory factory=new SwtFactory();

	public static void main(String[] args) {
		Window window=factory.buildWindow();
		Button ok=factory.buildButton("OK");
		Button cancel=factory.buildButton("Cancel");
		TextField login=factory.buildTextField("Login:", 30);
		
		window.add(ok).add(cancel).add(login);
		window.display();

	}

}
