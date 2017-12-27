package command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	private final List<Command> commands = new ArrayList<>();

	public Invoker() {

	}

	public Invoker add(Command c) {
		assert c != null;

		commands.add(c);
		return this;
	}

	public void execute() {
		for (Command command : commands) {
			command.doIt();
		}
	}

	public boolean Undo() {
		if (canBeUndone()) {
			for (int i = commands.size() - 1; i >= 0; i--) {
				commands.get(i).UndoIt();
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean canBeUndone() {
		boolean ok = true;
		for (Command c : commands) {
			ok &= c.canBeUndone();
			if (!ok)
				break;
		}
		return ok;
	}

	public void clear() {
		commands.clear();
	}

}
