
import java.util.ArrayList;
import java.util.List;

public class MainSample {

	private static final int NBR_THREADS = 100;

	public static void main(String[] args) {
		// create an account that will be shared amongst all the threads
		Account acc = new Account();
		// a collection to remember the threads
		List<Thread> threads = new ArrayList<Thread>();
		// Create and start the threads
		for (int i = 0; i < NBR_THREADS; i++) {
			Transfert t = new Transfert(acc, 1);
			threads.add(t);
			t.start();
		}
		// waiting for the end of every thread
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		System.out.println(acc.getValue());
		assert acc.getValue() == NBR_THREADS;
	}
}
