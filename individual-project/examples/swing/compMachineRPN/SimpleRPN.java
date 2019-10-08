package swing.compMachineRPN;

import javax.swing.JDialog;

/**
 * The controller for a simple RPN personal calculator.
 * 
 * @author Vincent
 * 
 */
public class SimpleRPN {

	private final ModelCalculator model;
	private final SimpleGUICustom view;
	private final SimpleGUICustom view2;
	private final SimpleGUICustom view3;

	public SimpleRPN() {
		model = new ModelCalculator();
		view = new SimpleGUICustom(model);
		view2 = new SimpleGUICustom(model);
		view3 = new SimpleGUICustom(model);
		model.addObserver(view2);
		model.addObserver(view);
		model.addObserver(view3);

	}

	/**
	 * Display and run the calculator.
	 */
	public void run() {
		view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		view2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		view3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		view.setVisible(true);
//		view2.setVisible(true);
//		view3.setVisible(true);
	}

}
