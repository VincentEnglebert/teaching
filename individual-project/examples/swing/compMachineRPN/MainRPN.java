package swing.compMachineRPN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * That applications implements RPN calculators.
 * 
 * @author Vincent
 * 
 */

public class MainRPN extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(MainRPN.class);
	private final JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		logger.info("INFO OK");
		logger.debug("DEBUG OK");

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					final MainRPN frame = new MainRPN();
					frame.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainRPN() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 516);

		final JMenuBar menuBar = new JMenuBar();
		// menuBar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		this.setJMenuBar(menuBar);

		final JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		final JMenuItem menuFileSave = new JMenuItem("Save");
		menuFile.add(menuFileSave);

		final JMenuItem menuFileClose = new JMenuItem("Close");
		menuFile.add(menuFileClose);

		final JMenu menuConfiguration = new JMenu("Configuration");
		menuBar.add(menuConfiguration);

		final JMenuItem menuConfigurationNormal = new JMenuItem("--Normal");
		menuConfigurationNormal.setAction(new ActionNormal());

		menuConfiguration.add(menuConfigurationNormal);

		final JMenuItem menuConfigurationScientific = new JMenuItem("Scientific");
		menuConfiguration.add(menuConfigurationScientific);

		final JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.blue);

		setContentPane(contentPane);
	}

}
