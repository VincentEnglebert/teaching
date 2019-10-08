package swing.compMachineRPN;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

/**
 * Refine the Normal class to let it unchanged.
 * 
 * @author Vincent
 * 
 */

public class SimpleGUICustom extends SimpleGUI implements Observer {
	private static final long serialVersionUID = 1L;
	private final ModelCalculator model;
	private final static Logger logger = Logger.getLogger(SimpleGUICustom.class);

	/**
	 * @pre _model is not null.
	 * @param _model
	 *            the model of the calculator.
	 */
	public SimpleGUICustom(ModelCalculator _model) {
		assert _model != null;
		this.model = _model;

		textField.setText(model.getDisplay());
		textField.setEditable(false);

		button_k0.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				logger.debug("mouseReleased");

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				logger.debug("mousePressed");

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				logger.debug("mouseExited");
				button_k0.setBackground(Color.red);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				logger.debug("mouseEntered");
				button_k0.setBackground(Color.green);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				logger.debug("mouseClicked");
			}
		});

		button_k0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(0);
				logger.debug("Key 0 pressed");
			}
		});
		button_k1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(1);
			}
		});
		button_k2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(2);
			}
		});
		button_k3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(3);
			}
		});
		button_k4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(4);
			}
		});
		button_k5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(5);
			}
		});
		button_k6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(6);
			}
		});
		button_k7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(7);
			}
		});
		button_k8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(8);
			}
		});
		button_k9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.key(9);
			}
		});
		button_point.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.point();
			}
		});
		button_plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.plus();
			}
		});
		button_minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.minus();
			}
		});
		button_divide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.divide();
			}
		});
		button_times.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.times();
			}
		});
		button_Enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.enter();
			}
		});

		pack();

	}

	@Override
	public void update(Observable o, Object arg) {
		textField.setText(model.getDisplay());
	}

}
