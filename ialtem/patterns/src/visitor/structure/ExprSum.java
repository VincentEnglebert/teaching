package visitor.structure;

import visitor.visitors.NodeVisitor;

public class ExprSum extends Expression {
	public final Expression left;
	public final Expression right;

	public ExprSum(Expression left, Expression right) {
		assert left != null && right != null;

		this.left = left;
		this.right = right;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		assert visitor != null;

		visitor.visitExprSum(this);
	}

}
