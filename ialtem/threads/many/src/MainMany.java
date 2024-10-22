import java.util.Scanner;

/**
 * @author Vincent Englebert x
 * 
 *         This program simulates the operation of an exponential number of
 *         threads with a simulated load.
 */

public class MainMany {

	public static void main(String[] args) {
		System.out.print("This program simulates the operation of an exponential number of threads with a simulated load.\n" + "\tc: a thread has been created\n"
				+ "\t.: a thread has started to load the cpu\n" + "\t+: a thread has stopped its job.\n\n");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 'Return' to continue...");
		// Wait for the user to press 'Return
		scanner.nextLine();

		System.out.println("You pressed 'Return'. The programme continues...");
		scanner.close();

		ThreadVirus virus = new ThreadVirus(10);
		ThreadVirus.setLoad(10000000L);
		virus.start();

	}

}
