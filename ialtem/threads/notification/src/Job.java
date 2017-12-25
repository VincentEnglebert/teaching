
class Job {
	protected final int MAX = 2;
	final int tableau[];
	final Ressource ressource;
	final String name;

	Job(String n, Ressource res, int tab[]) {
		assert n!=null && !n.equals("");
		assert res!=null;
		assert tab!=null;
		
		ressource = res;
		tableau = tab;
		name = n;
	}
}