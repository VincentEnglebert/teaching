package be.unamur.impl;

import be.unamur.interfaces.INotificationChannel;

public class EmailNotification implements INotificationChannel {

	@Override
	public void process()  {
		// TODO Auto-generated method stub
		// Temps d'execution
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n$$$ Envoi de MAIL au client $$$");
	}

}
