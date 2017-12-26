package workflow;

public class TaskDispatch extends Task {

	public TaskDispatch(SharedQueue<Document>[] in, SharedQueue<Document>[] out) {
		super("DISPATCH",in, out);
		assert in.length == 1;
		assert out.length == 3;
	}

	@Override
	public void run() {
		while (true) {
			Document document = in[0].getItem();
			document.process(this);
			switch (document.getStatus()) {
			case bill:
				out[2].add(document);
				break;
			case send:
				out[1].add(document);
				break;
			case order:
				out[0].add(document);
				break;
			default:
				assert false : "forgotten enum";
			}

		}
	}

}
