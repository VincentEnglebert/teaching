package workflow;

/**
 * 
 * @author V. Englebert
 *
 */
public class TaskTrash extends Task {

	public TaskTrash(SharedQueue<Document>[] in, SharedQueue<Document>[] out) {
		super("TRASH",in, out);
		assert in.length == 1;
		assert out.length == 0;
	}

	@Override
	public void run() {
		while (true) {
			in[0].getItem().process(this);;
			// just throw away
		}
	}

}
