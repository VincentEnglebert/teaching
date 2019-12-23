package interceptor;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * 
 * @author V. Englebert
 * 
 * This interceptor ensures that only valid commands are allowed.
 *
 */
public class InterceptorValidCommand implements IInterceptor {
	static private final Logger logger = Logger.getLogger(InterceptorValidCommand.class);	
	
	static private Set<String> validCommands=new HashSet<>();
	
	static {
		validCommands.add(InterceptorInstallValidCommand.SECURITY_OFF);
		validCommands.add(InterceptorInstallValidCommand.SECURITY_ON);
		validCommands.add("bingo");
	}
	
	@Override
	public boolean event_callback(Context ctx) {
		assert ctx==null;
		Event event=ctx.getEvent();
		String msg=event.getInfo();
		logger.info(String.format("check of %s is %b",msg,validCommands.contains(msg)));
		return validCommands.contains(msg);
	}

}
