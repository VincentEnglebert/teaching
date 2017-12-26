package workflow;

/**
 * 
 * @author UNamur
 *
 */
public class MainWorkflow {

	public static void main(String[] args) {
		int nbrDocuments;

		if (args == null || args.length != 2) {
			System.err
					.println("Usage: <delay> <nbrdocuments>\n" + "\t<delay>:\tnumber of seconds between each process\n"
							+ "\t<nbrdocuments>:\tnumber of documents generated\n"
							+ "\tdefault values are 1 (seconds) 5 (documents)");
			args = new String[] { "1", "5" };
		}
		try {
			Document.setSpeed(Integer.parseInt(args[0]));
			nbrDocuments = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err
					.println("Usage: <delay> <nbrdocuments>\n" + "\t<delay>:\tnumber of seconds between each process\n"
							+ "\t<nbrdocuments>:\tnumber of documents generated\n"
							+ "\tdefault values are 1 (seconds) 5 (documents)");
			Document.setSpeed(1);
			nbrDocuments = 5;
		}

		SharedQueue<Document> queueBeforeCheck = new SharedQueue<>();
		SharedQueue<Document> queueBeforeDispatch = new SharedQueue<>();
		SharedQueue<Document> queueBeforeBill = new SharedQueue<>();
		SharedQueue<Document> queueBeforeSend = new SharedQueue<>();
		SharedQueue<Document> queueBeforeOrder = new SharedQueue<>();
		SharedQueue<Document> queueBeforeTrash = new SharedQueue<>();
		SharedQueue<Document> queueAfterBill = new SharedQueue<>();
		SharedQueue<Document> queueAfterSend = new SharedQueue<>();

		new TaskCheck(make(queueBeforeCheck), make(queueBeforeDispatch, queueBeforeTrash)).start();
		new TaskDispatch(make(queueBeforeDispatch), make(queueBeforeOrder, queueBeforeSend, queueBeforeBill)).start();
		new TaskBill(make(queueBeforeBill), make(queueAfterBill)).start();
		new TaskSend(make(queueBeforeSend), make(queueAfterSend)).start();
		new TaskOrder(make(queueBeforeOrder), make(queueBeforeSend, queueBeforeBill)).start();
		new TaskTrash(make(queueBeforeTrash), make()).start();
		new TaskBackup(make(queueAfterBill, queueAfterSend), make()).start();

		for (int i = 0; i < nbrDocuments; i++) {
			queueBeforeCheck.add(new Document());
		}
		
	}

	/**
	 * 
	 * 
	 * Utilities to bypass a limitation of Java
	 * see https://stackoverflow.com/questions/14917375/cannot-create-generic-array-of-how-to-create-an-array-of-mapstring-obje/14917529
	 * 
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	private static SharedQueue<Document>[] make() {
		return (SharedQueue<Document>[]) new SharedQueue[] {};
	}

	@SuppressWarnings("unchecked")
	private static SharedQueue<Document>[] make(SharedQueue<Document> a) {
		return (SharedQueue<Document>[]) (new SharedQueue[] { a });
	}

	@SuppressWarnings("unchecked")
	private static SharedQueue<Document>[] make(SharedQueue<Document> a, SharedQueue<Document> b) {
		return (SharedQueue<Document>[]) new SharedQueue[] { a, b };
	}

	@SuppressWarnings({ "unchecked" })
	private static SharedQueue<Document>[] make(SharedQueue<Document> a, SharedQueue<Document> b,
			SharedQueue<Document> c) {
		return (SharedQueue<Document>[]) new SharedQueue[] { a, b, c };
	}


}
