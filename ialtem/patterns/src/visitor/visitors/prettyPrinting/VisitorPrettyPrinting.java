package visitor.visitors.prettyPrinting;

import visitor.structure.Assignment;
import visitor.structure.DeclVariable;
import visitor.structure.ExprSum;
import visitor.structure.Node;
import visitor.structure.PrintExpression;
import visitor.structure.Program;
import visitor.structure.Value;
import visitor.structure.Variable;
import visitor.visitors.NodeVisitor;

public class VisitorPrettyPrinting implements NodeVisitor {
	private StringBuffer buffer = new StringBuffer();

	public String toString() {
		return buffer.toString();
	}

	@Override
	public void visitDeclVariable(DeclVariable variable) {
		buffer.append(String.format("var %s", variable.name));
	}

	@Override
	public void visitExprSum(ExprSum sum) {
		buffer.append('(');
		sum.left.accept(this);
		buffer.append(" + ");
		sum.right.accept(this);
		buffer.append(')');
	}

	@Override
	public void visitProgram(Program program) {
		for (Node node : program.statements) {
			node.accept(this);
			buffer.append(" ;\n");
		}
	}

	@Override
	public void visitValue(Value value) {
		buffer.append(value.value);
	}

	@Override
	public void visitAssignment(Assignment assignment) {
		buffer.append(assignment.variable);
		buffer.append(" := ");
		assignment.expression.accept(this);
	}

	@Override
	public void visitVariable(Variable variable) {
		buffer.append(variable.name);
	}

	@Override
	public void visitPrintExpression(PrintExpression printExpression) {
		buffer.append("print(");
		printExpression.expr.accept(this);
		buffer.append(")");
	}

}
