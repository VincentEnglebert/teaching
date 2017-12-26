package workflow;

/**
 * 
 * @author UNamur
 *
 */
public class TaskSend extends Task {

	public TaskSend(SharedQueue<Document>[] in, SharedQueue<Document>[] out) {
		super("SEND",in, out);
		assert in.length == 1;
		assert out.length == 1;
	}

	@Override
	public void run() {
		while (true) {
			Document document = in[0].getItem();
			document.process(this);
			out[0].add(document);
		}
	}

}
