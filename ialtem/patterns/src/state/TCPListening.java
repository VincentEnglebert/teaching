package state;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPListening extends TCPState {
	protected Socket client=null;
	protected BufferedReader in=null;
	protected ServerSocket ecoute=null;

	protected TCPListening(Context ctx, BufferedReader in, Socket client, ServerSocket ecoute) {
		super(ctx);
		this.in=in;
		this.client=client;
		this.ecoute=ecoute;	
	}

	@Override
	public void close() throws IllegalState {
		try {
			ecoute.close();
			client.close();
			context.setState(new TCPClosed(context));
		} catch (IOException e) {
			context.setState(new TCPError(context));
		}
	}

	@Override
	public String receive() throws IllegalState {
		try {
			return in.readLine();
		} catch (IOException e) {
			context.setState(new TCPError(context));
			return null;
		}
	}
}
