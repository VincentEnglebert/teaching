package visitor;

import visitor.structure.Assignment;
import visitor.structure.DeclVariable;
import visitor.structure.ExprSum;
import visitor.structure.PrintExpression;
import visitor.structure.Program;
import visitor.structure.Value;
import visitor.structure.Variable;
import visitor.visitors.checking.VisitorChecking;
import visitor.visitors.execution.VisitorExecution;
import visitor.visitors.prettyPrinting.VisitorPrettyPrinting;

public class MainVisitor {

	public static void main(String[] args) {
		Program program = new Program();
		program.add(new DeclVariable("x"))
				.add(new Assignment("x", new ExprSum(new Value(5), new ExprSum(new Value(6), new Variable("x")))))
				.add(new PrintExpression(new Variable("x")));
		VisitorPrettyPrinting prettyPrinter = new VisitorPrettyPrinting();
		VisitorExecution execution = new VisitorExecution();
		VisitorChecking checking = new VisitorChecking();

		// printing
		program.accept(prettyPrinter);
		System.out.println(prettyPrinter.toString());
		// checking
		program.accept(checking);
		System.out.printf("Errors=%d ; Warnings=%d\n\n", checking.getErrors(), checking.getWarning());
		// execution
		System.out.println("Execution");
		if (checking.getErrors() == 0) {
			program.accept(execution);
		} else {
			System.out.println("Execution aborted due to errors");
		}
	}

}
