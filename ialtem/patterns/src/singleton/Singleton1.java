package singleton;

/**
 * 
 * @author V. Englebert
 * This class must be copied/pasted and adapted for every class that
 * is a singleton. This code is just a template.
 *
 */
public class Singleton1 {

	private static Singleton1 singleton=null;
	
	private Singleton1(){
		
	}
	
	public static Singleton1 getInstance(){
		if (singleton==null){
			singleton=new Singleton1();
		}
		return singleton;
	}
	
	
}
