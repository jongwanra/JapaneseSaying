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
	private SayingDAO dao;
	private LoginScreen loginscreen;
	private int flag;
	protected JButton[] btn = new JButton[saying_cnt];
	protected JScrollPane scrollPane;

	protected JToolBar toolBar = new JToolBar();
	protected JButton registerOrder = new JButton("Register Order");
	protected JButton inquiryOrder = new JButton("Inquiry Order");
	protected JButton userRankingOrder = new JButton("User Ranking");
	protected String id;
	protected String pwd;
	protected String[] datas;
	
	ImageIcon i = new ImageIcon("./src/Image/Background.jpeg");
	Image im = i.getImage();
	

	public MainUI(String id, String pwd, int flag) {
		this.flag = flag;
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
		toolBar.add(userRankingOrder);
		// panel
		placeMainPanel();
		setSize(400, 600);
		

		this.id = id;
		this.pwd = pwd;
		System.out.println(id);
		System.out.println(pwd);

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

		
		//get Data in Dao
			dao = new SayingDAO();
			datas = new String[50];
			if(flag == 0)
				datas = dao.getSayingRegister();
			else if(flag == 1) 
				datas = dao.getSayingInquiry();
			else if(flag == 2)
				datas = dao.getUserRanking();
		
		for (int i = 0; i < saying_cnt; i++) {
			
			btn[i] = new JButton(datas[i]);
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
		for(int i=0; i < saying_cnt; i++)
			btn[i].addActionListener(listener);
		registerOrder.addActionListener(listener);
		inquiryOrder.addActionListener(listener);
		userRankingOrder.addActionListener(listener);
    }

}
