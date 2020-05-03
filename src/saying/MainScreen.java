package saying;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainScreen extends JFrame {
	private LoginScreen loginscreen;
	protected JButton[] btn = new JButton[10];
	protected JButton back;
	
	public MainScreen(int flag, String name, String pwd) {
		setTitle("Japanese Saying Main Screen");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setResizable(false);
		setLocation(600, 350);
		
		//panel
		JPanel panel = new JPanel();
		placeMainPanel(panel);
		
		//add
		add(panel);
		
		//visible
		setVisible(true);
	}


	public void placeMainPanel(JPanel panel) {
		panel.setLayout(null);
		
	}
	
}
