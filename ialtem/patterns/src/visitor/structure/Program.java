package visitor.structure;

import java.util.LinkedList;
import java.util.List;

import visitor.visitors.NodeVisitor;

public class Program extends Node {
	public final List<Node> statements = new LinkedList<Node>();

	public Program() {

	}

	public Program add(Node node) {
		assert node != null;

		statements.add(node);
		return this;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		assert visitor != null;

		visitor.visitProgram(this);
	}

}
