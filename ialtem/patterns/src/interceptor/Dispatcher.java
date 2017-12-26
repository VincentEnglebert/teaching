package interceptor;

import java.util.LinkedList;
import java.util.List;

//import org.apache.log4j.Logger;

/**
 * 
 * @author UNamur
 * 
 *         This object is shared between the main thread and the Environment
 *         thread.
 *
 */
public class Dispatcher {
//	static private final Logger logger = Logger.getLogger(Dispatcher.class);

	private volatile List<IInterceptor> interceptors = new LinkedList<>();

	public synchronized boolean callback(Context ctx) {
		assert ctx != null;

		boolean mustContinue = true;

		for (IInterceptor interceptor : new LinkedList<>(interceptors)) {
			mustContinue = interceptor.event_callback(ctx);
			if (!mustContinue) {
				break;
			}
		}
		return mustContinue;

	}

	public synchronized void register(IInterceptor inter) {
		assert inter != null;

		interceptors.add(inter);
	}

	public synchronized void unregister(IInterceptor inter) {
		assert inter != null;

		interceptors.remove(inter);
	}
}
