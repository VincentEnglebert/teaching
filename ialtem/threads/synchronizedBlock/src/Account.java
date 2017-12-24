
/**
 * 
 * @author UNamur
 * 
 * This resource is not protected by the 'synchronized' prefix.
 * Threads will share it within a synchronized block to avoid
 * concurrency
 *
 */
public class Account {
	private long value = 0;

	public long getValue() {
		return value;
	}

	public void setValue(long val) {
		value = val;
	}

}
