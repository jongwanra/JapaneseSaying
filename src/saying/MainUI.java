package saying;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class MainUI extends JFrame {
	protected int saying_cnt = 50;
	private LoginScreen loginscreen;
	protected JButton[] btn = new JButton[saying_cnt];
	protected JScrollPane scrollPane;

	protected JToolBar toolBar = new JToolBar();
	protected JButton item = new JButton("Item");
	protected String id;
	protected String pwd;

	// String id, String pwd
	public MainUI() {
		// setting
		setTitle("Japanese Saying Main Screen");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(600, 350);

		setLayout(new FlowLayout());
		add(toolBar);
		toolBar.add(item);
		// panel
		placeMainPanel();
		setSize(400, 600);
		
		// Create toolBar
		

//		this.id = id;
//		this.pwd = pwd;

		// visible
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void placeMainPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(400, 100 * saying_cnt));

		for (int i = 0; i < saying_cnt; i++) {
			btn[i] = new JButton("" + (i + 1) + "");
			//btn[i].setBounds(10, (i * 90), 380, 90);
			btn[i].setPreferredSize(new Dimension(380, 90));
			panel.add(btn[i]);

		}

		scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(400, 500));
		add(scrollPane);

	}

}
