package visitor.structure;

import visitor.visitors.NodeVisitor;

public class PrintExpression extends Node {

	public final Expression expr;

	public PrintExpression(Expression expr) {
		assert expr!=null;
		
		this.expr = expr;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		assert visitor!=null;
		
		visitor.visitPrintExpression(this);
	}

}
