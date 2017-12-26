package workflow;

/**
 * 
 * @author UNamur
 *
 */
public class TaskBill extends Task {

	public TaskBill(SharedQueue<Document>[] in, SharedQueue<Document>[] out) {
		super("BILL", in, out);
		
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
