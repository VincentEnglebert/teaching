package interceptor;

/**
 * @author Vincent Englebert
 */


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Environment extends Thread {

	static final int PORT = 1333;
	static final int SIZE_BUFFER = 65536;
	private volatile boolean stop = false;

	public void stopThread() {
		stop = true;
	}

	public Environment() {
		this.start();
	}
	
	@Override
	public void run() {
		System.out.println("Receiver listening on port " + PORT);
		try {
			DatagramSocket socket = new DatagramSocket(PORT);			
			while (!stop) {
				byte buffer[] = new byte[SIZE_BUFFER];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				
				String sentence = new String( packet.getData(), 0, packet.getLength() );
				
				Framework.getInstance().event(new Event(sentence));
			}
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		System.out.println("Receiver stops here.");

	}

}
