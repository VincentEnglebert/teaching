package be.unamur.impl;

import be.unamur.Client;
import be.unamur.interfaces.INotificationChannel;

public class SMSNotification implements INotificationChannel{
	@Override
	public void process(Client client) {
		// TODO Auto-generated method stub
		// Temps d'execution
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("\n$$$ Envoi de SMS à %s $$$\n", client.getIdentite());
	}
}