package painter;

public class Painter  extends Thread {
	
	private final Tableau tableau;
	private final Color color;
	
	public Painter(Tableau t, Color c) {
		assert t!=null;
		assert c!=null;
		
		tableau=t;
		color=c;
	}
	
	public void run() {
		
		tableau.paint(color);
		
	}

}
