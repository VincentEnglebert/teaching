package com.namur.sisters;

import java.util.Scanner;

/**
 * @author lab
 *
 */
public class Main {

	/** Mechanism for synchronizing and sending data between threads and processes
     */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

        System.out.print("Starting ...\n\n");
		Canal canal0 = new Canal("Canal0");
		Canal canal1 = new Canal("Canal1");
		Canal canal2 = new Canal("Canal2");

		new Person("wendy", canal0, canal1).start();
		Person marine = new Person("marine", null, canal1);
		marine.setConsumeTime(7000);
		marine.start();
		new SMTPServer(canal1, canal2).start();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the message: ");
		for (int i = 0; i < 3; i++) {
			String content = scanner.nextLine();
			Message messageFormat = new Message(content, "wendy@blabla.com");
			canal0.produce(messageFormat);
		}
		scanner.close();

		Thread.sleep(10000); // Waiting for 10s last message transmission
		System.out.println("Fin du programme");
		System.exit(0);
	}

}
