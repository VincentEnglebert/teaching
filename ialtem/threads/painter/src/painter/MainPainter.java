package painter;

public class MainPainter {

	public static void main(String args[]) {
		Painter p1, p2, p3;
		Tableau tableau = new Tableau();

		try {

			System.out.println("This program should display Red, Green and then Blue in order.");

			p3 = new Painter(tableau, Color.blue);
			p1 = new Painter(tableau, Color.red);
			p2 = new Painter(tableau, Color.green);

			p1.start();
			p2.start();
			p3.start();

			p1.join();
			p2.join();
			p3.join();
			
			System.out.println("Programme completed.");
			
		} catch (InterruptedException e) {
			assert false: "Unexpected exception.";
			e.printStackTrace();
		}

	}
}
