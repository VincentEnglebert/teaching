import java.io.*;
import java.net.*;

public class Client {
	protected static final int PORT = 8001;

	public static void main(String[] args) {
		Socket s = null;
		BufferedReader canalLecture;
		PrintStream canalEcriture ;
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		

		
		try {
			if (args==null || args.length != 1) {
				System.err.println("Usage: \n\tjava Client <hote>");
				args = new String[] { Inet4Address.getLocalHost().getHostAddress()};
				System.err.printf("\tUse default value: %s\n", args[0]);

			}
			// Creates a stream socket and connects it to the specified port
			// number at the specified IP address.
			s = new Socket(args[0], PORT);
			canalLecture = new BufferedReader(new InputStreamReader(s.getInputStream()));
			canalEcriture = new PrintStream(s.getOutputStream());
			System.out.printf("Connection opened from:  %s:%d\n", s.getInetAddress().getHostAddress(), s.getPort());
			System.out.printf("Type\n"
					+ "\t?end : to end the connection\n"
					+ "\t?clients : to obtain the number of simultaneous connections on the server\n"
					+ "\tanything else will be sent to the server to be translated in uppercase\n",null);


			while (true) {
				System.out.print("?> ");
				System.out.flush();
				String request = console.readLine();
				canalEcriture.println(request);
				String result = canalLecture.readLine();
				if (result == null) {
					System.out.println("connection closed");
					System.exit(0);
				}
				System.out.printf("!> %s\n" , result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			try {
				if (s != null) {
					s.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
