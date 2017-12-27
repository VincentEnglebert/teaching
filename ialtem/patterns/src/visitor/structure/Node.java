package visitor.structure;

import visitor.visitors.NodeVisitor;

public abstract class Node {
	
	public abstract void accept(NodeVisitor visitor);

}
