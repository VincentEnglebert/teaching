
class Ressource {
    private volatile int count;
    static int pass=1;

    public Ressource(int m){
	count=m;
    }

    public synchronized void getRessource(int n){
	int appel;
	
	appel=pass++;
	System.out.println("["+appel+"] Try getRessource: "+n);
	while (true){
	    if (count-n>=0) {
		count=count-n;
		System.out.println("["+appel+"] success count="+count);
		break;
	    } else {
		try {
		    System.out.println("["+appel+"] waiting...");
		    wait();
		}
		catch (Exception e){}
	    }
	}
    }

    public synchronized void freeRessource(int n){
	count=count+n;
	System.out.println("Free ressource: "+n+" count="+count);
	notify();
    }
}