package state;

public abstract class TCPState implements TCPOperations {
	protected final Context context;

	protected TCPState(Context ctx) {
		context = ctx;
	}

	public class IllegalState extends Exception {
		private static final long serialVersionUID = 1L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state.TCPOperations#open(int)
	 */
	@Override
	public void open(int Port) throws IllegalState {
		throw new IllegalState();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state.TCPOperations#close()
	 */
	@Override
	public void close() throws IllegalState {
		throw new IllegalState();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state.TCPOperations#receive()
	 */
	@Override
	public String receive() throws IllegalState {
		throw new IllegalState();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see state.TCPOperations#reset()
	 */
	@Override
	public void reset() throws IllegalState {
		throw new IllegalState();
	}
}
