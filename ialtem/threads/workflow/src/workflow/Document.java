package workflow;

import java.util.Random;

/**
 * 
 * @author UNamur 
 * Documents can be shared between Send and Bill Tasks -->
 * methods must be synchronized also.
 *
 */
public class Document {
	// Number of seconds between each process to slow down the display
	static private int speed=0;
	static final private Random random = new Random();
	// to assign unique Id to documents and facilitate the display
	static private long last = 0;
	public final long oid = ++last;

	// status is assigned randomly

	public enum Status {
		bill, send, order
	};

	private final Status status = Status.values()[random.nextInt(3)];

	// to remember if a document must be backuped.
	// The Backup task can delete it otherwise.
	private boolean byorder = false;

	public synchronized boolean isConform() {
		return random.nextBoolean();
	}

	public synchronized Status getStatus() {
		return status;
	}

	public synchronized void process(Task task) {
		Util.dodo(speed);
		System.out.printf("Document %d processed by task %s\n", oid, task.name);
		Util.dodo(speed);
	}

	// The document has been processed by order and must be later backuped.
	public synchronized void passedByOrder() {
		byorder = true;
	}


	public synchronized boolean isPassedByOrder() {
		return byorder;
	}
	
	static public void setSpeed(int s){
		speed=s;
	}
}
