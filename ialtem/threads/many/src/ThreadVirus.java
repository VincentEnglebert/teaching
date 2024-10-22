
import java.lang.Math;

/**
 * author V. Englebert 
 */


public class ThreadVirus extends Thread {
	private static long Load;
	private final ThreadVirus left;
	private final ThreadVirus right;

	/**
	 * 
	 * @param level ~ 2^ (level) will be created
	 */
	public ThreadVirus(int level) {
		assert level>=0;
		System.out.print('c');

		if (level > 0) {
			left = new ThreadVirus(level - 1);
			right = new ThreadVirus(level - 1);
		} else {
			left = null;
			right = null;
		}
	}

	/**
	 * Defines the load for all the threads to be executed.
	 * @param l The load of the CPU (number of Cosinus)
	 */
	static void setLoad(long l) {
		assert l >= 0;
		Load = l;
	}

	public void run() {
		System.out.print('.');
		if (left != null) {
			left.start();
		}
		if (right != null) {
			right.start();
		}
		loadCPU();
		System.out.print('+');
	}

	/**
	 * Simulates processor load by invoking 'load' operations.
	 */
	private void loadCPU() {
		for (long i = 1L; i <= Load; i++) {
			Math.cos(1.2);
		}
	}

}
