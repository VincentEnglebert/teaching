package workflow;

public class TaskOrder extends Task {

	public TaskOrder(SharedQueue<Document>[] in, SharedQueue<Document>[] out) {
		super("ORDER",in, out);
		assert in.length == 1;
		assert out.length == 2;
	}

	@Override
	public void run() {
		while (true) {
			Document document = in[0].getItem();
			document.process(this);
			document.passedByOrder();
			out[0].add(document);
			out[1].add(document);
		}
	}

}
