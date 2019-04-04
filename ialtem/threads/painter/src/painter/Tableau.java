package painter;

 

public class Tableau {
	/**
	 * This table indicates whether the index color'i' has been applied to the tableau.
	 * The first position facilitates the implementation and generalizes the algorithm.
	 * 
	 */
	private boolean flag[]=new boolean[] { true , false, false, false };
	static private int i=0;
	
	public synchronized void paint(Color couleur) {
		assert couleur!=null;
		
		while (flag[couleur.getIndex()-1]==false){
			/**
			 * The painter of a C color can only start his/her work if the previous painter (in RGB order) has finished.
			 */
			try {
				wait();
			} catch (InterruptedException e) {
				assert false: "Unexpected exception !";
				e.printStackTrace();
			}
		}
		
		
		System.out.printf("%d) Color \"%s\" completed.\n",++i,couleur);
		
		flag[couleur.getIndex()]=true;
		notifyAll();
		
	}

}
