package visitor.visitors.checking;

import java.util.HashSet;
import java.util.Set;

import visitor.structure.Assignment;
import visitor.structure.DeclVariable;
import visitor.structure.ExprSum;
import visitor.structure.Node;
import visitor.structure.PrintExpression;
import visitor.structure.Program;
import visitor.structure.Value;
import visitor.structure.Variable;
import visitor.visitors.NodeVisitor;

public class VisitorChecking implements NodeVisitor {
	private final Set<String> variables = new HashSet<>();
	private int errors = 0;
	private int warning = 0;

	public int getErrors() {
		return errors;
	}

	public int getWarning() {
		return warning;
	}

	@Override
	public void visitDeclVariable(DeclVariable variable) {
		if (variables.contains(variable.name)) {
			warning++;
		}
		if (variable.name.equals("")) {
			errors++;
		}
		variables.add(variable.name);
	}

	@Override
	public void visitExprSum(ExprSum sum) {
		// nothing to do
	}

	@Override
	public void visitProgram(Program program) {
		for (Node node : program.statements) {
			node.accept(this);
		}
	}

	@Override
	public void visitValue(Value value) {
		// nothing to do
	}

	@Override
	public void visitAssignment(Assignment assignment) {
		if (variables.contains(assignment.variable) == false) {
			errors++;
		}
	}

	@Override
	public void visitVariable(Variable variable) {
		if (variables.contains(variable.name) == false) {
			errors++;
		}
	}

	@Override
	public void visitPrintExpression(PrintExpression printExpression) {
		// nothing todo
	}

}
