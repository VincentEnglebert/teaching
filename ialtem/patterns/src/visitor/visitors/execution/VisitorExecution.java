package visitor.visitors.execution;

import visitor.structure.DeclVariable;
import visitor.structure.ExprSum;
import visitor.structure.Node;
import visitor.structure.PrintExpression;
import visitor.structure.Program;
import visitor.structure.Value;
import visitor.structure.Variable;

import java.util.HashMap;
import java.util.Map;

import visitor.structure.Assignment;
import visitor.visitors.NodeVisitor;

public class VisitorExecution implements NodeVisitor {

	private final Map<String, Integer> store = new HashMap<>();
	private int lastResult;

	@Override
	public void visitDeclVariable(DeclVariable variable) {
		store.put(variable.name, 0);
	}

	@Override
	public void visitExprSum(ExprSum sum) {
		sum.left.accept(this);
		int leftvalue = lastResult;
		sum.right.accept(this);
		int rightvalue = lastResult;
		lastResult = leftvalue + rightvalue;
	}

	@Override
	public void visitProgram(Program program) {
		for (Node node : program.statements) {
			node.accept(this);
		}
	}

	@Override
	public void visitValue(Value value) {
		lastResult = value.value;
	}

	@Override
	public void visitAssignment(Assignment assignment) {
		assignment.expression.accept(this);
		store.put(assignment.variable, lastResult);
	}

	@Override
	public void visitVariable(Variable variable) {
		lastResult = store.get(variable.name);
	}

	@Override
	public void visitPrintExpression(PrintExpression printExpression) {
		printExpression.expr.accept(this);
		System.out.printf(">%d\n", lastResult);
	}

}
