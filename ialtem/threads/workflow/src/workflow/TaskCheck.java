package workflow;

/**
 * 
 * @author UNamur
 *
 */
public class TaskCheck extends Task {

	public TaskCheck(SharedQueue<Document>[] in, SharedQueue<Document>[] out) {
		super("CHECK", in, out);

		assert in.length == 1;
		assert out.length == 2;
	}

	@Override
	public void run() {
		while (true) {
			Document document = in[0].getItem();
			document.process(this);
			if (document.isConform()) {
				out[0].add(document);
			} else {
				out[1].add(document);
			}
		}
	}

}
