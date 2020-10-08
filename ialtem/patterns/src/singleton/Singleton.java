package singleton;

/**
 * 
 * @author V. Englebert
 * This class must be copied/pasted and adapted for every class that
 * is a singleton. This code is just a template.
 *
 */
public class Singleton {

	private static Singleton instance=null;
	
	private Singleton(){
		// nothing is nothing
	}
	
	/**
	 * 
	 * @return The unique instance of Singleton
	 */
	public static Singleton getInstance(){
		if (instance==null){
			instance=new Singleton();
		}
		return instance;
	}
	
}
