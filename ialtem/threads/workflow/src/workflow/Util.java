package workflow;

/**
 * 
 * @author UNamur
 *
 */
public class Util {

	/**
	 * Sleep for a period of 0-10.000ms
	 */
	public static synchronized  void dodo() {
		try {
			Thread.sleep((int)(Math.random()*1000));
		} catch (InterruptedException e) {
			// no stress
		}
	}
	
	/**
	 * 
	 * @param seconds >=0
	 * Sleep for <pre>seconds</pre> seconds
	 */
	public static synchronized void dodo(int seconds){
		assert seconds>=0;
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// no stress
		}
		
	}

}
