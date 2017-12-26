package interceptor;

import org.apache.log4j.Logger;

public class InterceptorAudit implements IInterceptor {
	static private final Logger logger = Logger.getLogger(InterceptorAudit.class);	

	@Override
	public boolean event_callback(Context ctx) {
		
		logger.info(String.format("At %s, command <%s> received", ctx.getTimestamp().toString(), ctx.getEvent().getInfo()));
		return true;
	}

}
