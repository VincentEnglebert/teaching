package visitor.visitors;

import visitor.structure.Assignment;
import visitor.structure.DeclVariable;
import visitor.structure.ExprSum;
import visitor.structure.PrintExpression;
import visitor.structure.Program;
import visitor.structure.Value;
import visitor.structure.Variable;

public interface NodeVisitor {
	void visitDeclVariable(DeclVariable variable);

	void visitExprSum(ExprSum sum);

	void visitProgram(Program program);

	void visitValue(Value value);

	void visitAssignment(Assignment assignment);

	void visitVariable(Variable variable);

	void visitPrintExpression(PrintExpression printExpression);
}
