package workflow;

import java.util.HashSet;
import java.util.Set;

public class TaskBackup extends Task {

	public TaskBackup(SharedQueue<Document>[] in, SharedQueue<Document>[] out) {
		super("BACKUP", in, out);
		assert in.length == 2;
		assert out.length == 0;
	}

	@Override
	public void run() {
		Set<Document> waiting0 = new HashSet<>();
		Set<Document> waiting1 = new HashSet<>();
		while (true) {
			Document item0;
			do {
				item0 = in[0].getItem();
			} while (item0.isPassedByOrder() == false);
			waiting0.add(item0);

			Document item1;
			do {
				item1 = in[1].getItem();
			} while (item1.isPassedByOrder() == false);
			waiting1.add(item1);
			Set<Document> intersection = new HashSet<>(waiting0);
			intersection.retainAll(waiting1);
			for (Document doc : intersection) {
				doc.process(this);
			}
			waiting0.removeAll(intersection);
			waiting1.removeAll(intersection);
			intersection.clear();
		}
	}

}
