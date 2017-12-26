package interceptor;

import java.util.Date;

import org.apache.log4j.Logger;

public class Framework extends Thread {
	static private final Logger logger = Logger.getLogger(Framework.class);	

	private static Framework singleton=null;
	private final Dispatcher dispatcher;

	private Framework(){
		dispatcher=new Dispatcher();
	}
	
	public static Framework getInstance() {
		if (singleton==null){
			singleton=new Framework();
		}
		return singleton;
	}

	public Dispatcher getDispatcher(){
		return dispatcher;
	}
	
	public void event(Event event) {
		assert event !=null;
		
		Context ctx=new Context(new Date(), event);
		boolean mustContinue = getDispatcher().callback(ctx);
		if (mustContinue){
			processEvent(event);
		}
	}

	private void processEvent(Event event) {
		logger.info(String.format("Application has received and processed event: %s", event.toString()));
	}
}