package design_patterns.singleton;

public class Singleton {
	static private Singleton singleton = null;

	private Singleton() {

	}

	static public Singleton getSingleton() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

	public void foo() {
		System.out.printf("coucou");
	}

	static public void main(String args[]) {
		Singleton.getSingleton().foo();
		Singleton.getSingleton().foo();
		Singleton.getSingleton().foo();
		// don't worry how singleton is created.
	}
}
