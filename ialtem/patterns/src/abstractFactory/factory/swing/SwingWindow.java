package abstractFactory.factory.swing;

import abstractFactory.factory.Window;

class SwingWindow extends Window {

	@Override
	public void display() {
		super.display();
		System.out.println("with Swing");
	}

}
