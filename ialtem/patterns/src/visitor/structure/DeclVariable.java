package visitor.structure;

import visitor.visitors.NodeVisitor;

public class DeclVariable extends Node {

	public final String name;

	public DeclVariable(String name) {
		assert name!=null;
		
		this.name = name;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		assert visitor!=null;
		
		visitor.visitDeclVariable(this);
	}

}
