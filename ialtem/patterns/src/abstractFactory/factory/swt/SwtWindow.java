package abstractFactory.factory.swt;

import abstractFactory.factory.Window;

class SwtWindow extends Window {

	@Override
	public void display() {
		super.display();
		System.out.println("with SWT");
		
	}

}
