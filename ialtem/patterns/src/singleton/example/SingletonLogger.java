package singleton.example;

import java.io.PrintStream;

/**
 * 
 * @author V. Englebert
 * This class must be copied/pasted and adapted for every class that
 * is a singleton. This code is just a template.
 *
 */
public class SingletonLogger {

	private static SingletonLogger instance=null;
	private final PrintStream out;
	
	private SingletonLogger(PrintStream stream){
		assert stream!=null;
		this.out=stream;
		
	}
	
	public static SingletonLogger getInstance(){
		if (instance==null){
			instance=new SingletonLogger(System.err);
		}
		return instance;
	}
	
	public void info(String msg){
		assert msg!=null;
		out.println("WARNING: "+msg);
	}
	public void warning(String msg){
		assert msg!=null;
		out.println("WARNING: "+msg);
	}

	public void error(String msg){
		assert msg!=null;
		out.println("ERROR: "+msg);
	}

	
	
}
