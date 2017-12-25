import java.net.*;

public class Server {
	protected static final int PORT = 8001;
	protected ServerSocket ecoute;

	public Server() {
		try {
			InetAddress address = null;
			address = Inet4Address.getLocalHost();
			assert address != null;
			// Creates a server socket on a specified port.
			ecoute = new ServerSocket(PORT);
			System.out.printf("Server listening on %s:%d\n", address.toString(), PORT);
			while (true) {
				// Listens for a connection to be made to this
				// socket and accepts it. The method blocks until
				// a connection is made.
				Socket client = ecoute.accept();
				System.out.printf("New connection from %s\n", client.getInetAddress().getHostAddress());
				new Connection(client);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}
