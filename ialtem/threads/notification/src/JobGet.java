
class JobGet extends Job implements Runnable {
	
	JobGet(String n, Ressource res, int tab[]) {
		super(n, res, tab);
	}

	public void run() {
		int i;
		for (i = 0; i < MAX; i++) {
			System.out.println(name);
			ressource.getRessource(tableau[i]);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}