
public class Main {
	public static void main(String args[]) {
		final Ressource ressource = new Ressource(0);
		int tofree[] = { 3, 1 };
		int t1[] = { 5, 0 };
		int t2[] = { 5, 0 };
		int t3[] = { 1, 0 };
		int t4[] = { 1, 0 };
		JobFree free = new JobFree("", ressource, tofree);
		JobGet get1 = new JobGet("get1", ressource, t1);
		JobGet get2 = new JobGet("get2", ressource, t2);
		JobGet get3 = new JobGet("get3", ressource, t3);
		JobGet get4 = new JobGet("get4", ressource, t4);

		(new Thread(get1)).start();
		(new Thread(get2)).start();
		(new Thread(get3)).start();
		(new Thread(get4)).start();
		
		Thread threadFree = new Thread(free);
		threadFree.start();
		
		try {
			threadFree.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("Free completed");
	}
}
