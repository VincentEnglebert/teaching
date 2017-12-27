package state;

import state.TCPState.IllegalState;

public class Context implements TCPOperations {
	private TCPState current = new TCPClosed(this);

	public void setState(TCPState state) {
		assert state != null;

		current = state;
	}

	@Override
	public void open(int port) throws IllegalState {
		current.open(port);
	}

	@Override
	public void close() throws IllegalState {
		current.close();
	}

	@Override
	public String receive() throws IllegalState {
		return current.receive();
	}

	@Override
	public void reset() throws IllegalState {
		current.reset();
	}
}
