package interceptor;

public interface IInterceptor {

	/**
	 * 
	 * @param ctx
	 *            Context about the event.
	 * @return true if event must be processed; false means that the event has
	 *         been consumed and must no more have consequences.
	 */
	boolean event_callback(Context ctx);

}
