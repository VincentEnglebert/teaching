package interceptor;

/**
 * @author Vincent Englebert
 */


import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MainInterceptor {

	public static void main(String[] args) {
		
		Logger logger = LogManager.getRootLogger();	
		logger.setLevel(Level.ALL);

		
		IInterceptor audit = new InterceptorAudit();
		IInterceptor secur = new InterceptorInstallValidCommand();		
		// IInterceptor black = new InterceptorBlackHole();

		Framework.getInstance().getDispatcher().register(audit);
		Framework.getInstance().getDispatcher().register(secur);
		// Framework.getInstance().getDispatcher().register(black);
		
		new Environment();

	}
}
