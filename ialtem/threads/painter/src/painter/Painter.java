package painter;

public class Painter  extends Thread {
	
	private final Tableau tableau;
	private final Color color;
	
	public Painter(Tableau t, Color c) {
		tableau=t;
		color=c;
	}
	
	public void run() {
		
		tableau.paint(color);
		
	}

}
