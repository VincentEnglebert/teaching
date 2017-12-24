import java.net.*;

public class Sender {
	static final int PORT = 1333;

	public static void main(String arg[]) {
		try {
			// Constructs a datagram socket and binds it
			// to any available port on the local host machine.
			DatagramSocket socket = new DatagramSocket();
			System.out.println("Socket is bound on port " + socket.getLocalPort());
			// allocate the data buffer and fill it
			byte[] data = new byte[256];
			for (int i = 0; i < 255; i++) {
				data[i] = (byte) i;
			}
			System.out.println("Sending 256 bytes on port " + PORT + " ...");
			// Constructs a datagram packet for sending packets
			// of length length to the specified port number on
			// the specified host
			DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), PORT);
			// Send a datagram packet from this socket. The DatagramPacket
			// includes information indicating the data to be sent, its
			// length, the IP address of the remote host, and the port number
			// on the remote host.
			socket.send(packet);
			System.out.println("Message sent !");
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Sender stops here.");
	}
}
