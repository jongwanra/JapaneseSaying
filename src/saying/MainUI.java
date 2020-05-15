package saying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	protected JButton registerOrder = new JButton("Register Order");
	protected JButton inquiryOrder = new JButton("Inquiry Order");
	protected String id;
	protected String pwd;
	ImageIcon i = new ImageIcon("./src/Image/Background.jpeg");
	Image im = i.getImage();
	
	// String id, String pwd
	public MainUI(String id, String pwd) {
		// setting
		setTitle("Japanese Saying Main Screen");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(600, 350);

		setLayout(new FlowLayout());
		
		// Create toolBar
		toolBar.setBackground(Color.LIGHT_GRAY); //toolBar Background Color
		toolBar.setFloatable(false); //toolBar fixed
		add(toolBar);
		
		toolBar.add(registerOrder); // register Order(basic)
		toolBar.add(inquiryOrder); //inquiry Order
		// panel
		placeMainPanel();
		setSize(400, 600);
		

		this.id = id;
		this.pwd = pwd;

		// visible
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0,0, getWidth(),getHeight(),this);
			
		}
		
	}

	public void placeMainPanel() {
		
		MyPanel panel = new MyPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel.setPreferredSize(new Dimension(400, 100 * saying_cnt));

		for (int i = 0; i < saying_cnt; i++) {
			btn[i] = new JButton("" + (i + 1) + "");
			btn[i].setPreferredSize(new Dimension(371, 120));
			panel.add(btn[i]);
		}

		scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane.setPreferredSize(new Dimension(400, 500));
		add(scrollPane);

	}
	
	public void addButtonActionListener(ActionListener listener) {
        // Register Event Listener
		for(int i=0; i < saying_cnt; i++) {
			btn[i].addActionListener(listener);
		}
//		ok_30.addActionListener(listener);
//		ok_10.addActionListener(listener);
//		info.addActionListener(listener);
//		back.addActionListener(listener);
    }

}
