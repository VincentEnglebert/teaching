package interceptor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
//import java.nio.charset.StandardCharsets;

public class MainInterceptorSender {
	static final int PORT = 1333;

	public static void main(String arg[]) {
		System.out.println("Usage:\n"
				+ "\tenter commands and RETURN\n"
				+ "\t1) 'securityON' command activates the remote firewall (only commands 1,2, and 3 are allowed)\n"
				+ "\t2) 'securityOFF' commande desactivtates the remote firewall\n"
				+ "\t3) 'bingo' is a valid command for the firewall\n"
				+ "\t4) 'exit' ends the sender app.\n"
				+ "Enjoy !\n");
		try {
			DatagramSocket socket = new DatagramSocket();
			System.out.println("Socket is bound on port " + socket.getLocalPort());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s="";
			while (s.toLowerCase().equals("exit") == false) {
				System.out.print("Enter command:");
				s = br.readLine();
				byte[] data = s.getBytes(StandardCharsets.UTF_8);
//				byte[] data=Util.stringToBytesUTFCustom(s);
				DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), PORT);
				socket.send(packet);
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Sender stops here.");
	}
}
