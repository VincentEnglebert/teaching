package workflow;

public abstract class Task extends Thread {
	final protected SharedQueue<Document>[] in;
	final protected SharedQueue<Document>[] out;
	final public String name;

	@SuppressWarnings("unchecked")
	public Task(String name, SharedQueue<Document>[] in, SharedQueue<Document>[] out) {
		assert name != null;

		this.name = name;
		this.in = (in == null) ? ((SharedQueue<Document>[]) (new SharedQueue[0])) : in;
		this.out = (out == null) ? ((SharedQueue<Document>[]) (new SharedQueue[0])) : out;
	}

}
