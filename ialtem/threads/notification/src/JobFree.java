
class JobFree extends Job implements Runnable {
	
	JobFree(String n, Ressource res, int tab[]) {
		super(n, res, tab);
	}

	public void run() {
		for (int i = 0; i < MAX; i++) {
			System.out.println(name);
			ressource.freeRessource(tableau[i]);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}