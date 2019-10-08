package swing.compMachineRPN;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class SimpleGUI extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JButton button_divide;
	protected JButton button_k7;
	protected JButton button_k8;
	protected JButton button_k9;
	protected JButton button_times;
	protected JButton button_k4;
	protected JButton button_k5;
	protected JButton button_k6;
	protected JButton button_minus;
	protected JButton button_k1;
	protected JButton button_k2;
	protected JButton button_k3;
	protected JButton button_plus;
	protected JButton button_k0;
	protected JButton button_point;
	protected JButton button_Enter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			final SimpleGUI dialog = new SimpleGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SimpleGUI() {
		setBackground(UIManager.getColor("MenuItem.selectionBackground"));
		setResizable(false);
		setTitle("Normal");
		setBounds(100, 100, 225, 189);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][][][]", "[][][][][]"));

		textField = new JTextField();
		textField.setBackground(Color.YELLOW);
		contentPanel.add(textField, "cell 0 0 3 1,growx");
		textField.setColumns(10);

		button_divide = new JButton("/");
		contentPanel.add(button_divide, "cell 3 0,growx");

		button_k7 = new JButton("7");
		contentPanel.add(button_k7, "cell 0 1");

		button_k8 = new JButton("8");
		contentPanel.add(button_k8, "cell 1 1");

		button_k9 = new JButton("9");
		contentPanel.add(button_k9, "cell 2 1");

		button_times = new JButton("*");
		contentPanel.add(button_times, "cell 3 1,growx");

		button_k4 = new JButton("4");
		contentPanel.add(button_k4, "cell 0 2");

		button_k5 = new JButton("5");
		contentPanel.add(button_k5, "cell 1 2");

		button_k6 = new JButton("6");
		contentPanel.add(button_k6, "cell 2 2");

		button_minus = new JButton("-");

		contentPanel.add(button_minus, "cell 3 2,growx");

		button_k1 = new JButton("1");
		contentPanel.add(button_k1, "cell 0 3");

		button_k2 = new JButton("2");
		contentPanel.add(button_k2, "cell 1 3");

		button_k3 = new JButton("3");
		contentPanel.add(button_k3, "cell 2 3");

		button_plus = new JButton("+");
		contentPanel.add(button_plus, "cell 3 3,growx");

		button_k0 = new JButton("0");
		contentPanel.add(button_k0, "cell 0 4 2 1,growx");

		button_point = new JButton(".");
		contentPanel.add(button_point, "cell 2 4");

		button_Enter = new JButton("ENTER");
		contentPanel.add(button_Enter, "cell 3 4");
	}

}
