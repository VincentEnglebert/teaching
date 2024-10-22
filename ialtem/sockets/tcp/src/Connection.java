import java.io.*;
import java.net.*;

class Connection extends Thread {
	// number of simultaneous connections
	static volatile int number = 0;
	protected Socket client;
	protected BufferedReader in;
	protected PrintStream out;
	boolean clean = false;

	public void finalize() throws Throwable {
		super.finalize();
		if (!clean) {
			number--;
			clean = true;
		}
	}

	public Connection(Socket client_soc) {
		synchronized (Connection.class) {
			number = number + 1;
		}
		client = client_soc;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			this.start();
		} catch (Exception e) {
			try {
				client.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void run() {
		boolean  stop = false;
		try {
			while (!stop) {
				String result = in.readLine().toUpperCase();
				stop = result.equals("?end".toUpperCase());
				if (!stop) {
					if (result.equals("?clients".toUpperCase())) {
						out.println(String.format("Nbr Clients = %d", number));
					} else {
						out.println(result);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			try {
				clean = true;
				synchronized (Connection.class) {
					number--;
				}
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
