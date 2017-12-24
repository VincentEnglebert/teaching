import java.net.*;



public class Receiver {
	static final int PORT = 1333;
	static final int SIZE_BUFFER = 65536;

	static public void main(String arg[]) {
		System.out.println("Receiver listening on port " + PORT);
		try {
			// Constructs a datagram socket and binds it
			// to the specified port on the local host machine.
			DatagramSocket socket = new DatagramSocket(PORT);
			byte buffer[] = new byte[SIZE_BUFFER];
			// Constructs a DatagramPacket for receiving packets of length 'length'.
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			// Receives a datagram packet from this socket.
			socket.receive(packet);
			InetAddress fromAddress = packet.getAddress();
			int fromPort = packet.getPort();
			int length = packet.getLength();
			byte[] data = packet.getData();
			socket.close();
			System.out.println("Received " + length + " bytes from " + fromAddress + ":" + fromPort);
			for (int i = 0; i < length; i++) {
				System.out.print(data[i] + ",");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Receiver stops here.");
	}
}
