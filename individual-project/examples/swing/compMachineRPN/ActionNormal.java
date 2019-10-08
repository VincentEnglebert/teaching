package swing.compMachineRPN;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ActionNormal extends AbstractAction {

	public ActionNormal() {
		super("Normal");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			new SimpleRPN().run();
		} catch (final Exception e1) {
			e1.printStackTrace();
		}

	}

}
