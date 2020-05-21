package saying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MainView extends JFrame {
	protected int saying_cnt = 50;
	private SayingDAO dao;
	private LoginView loginscreen;
	private int flag;
	protected JButton[] btn = new JButton[saying_cnt];
	protected JScrollPane scrollPane;
	protected JButton registerOrder;
	protected JButton inquiryOrder;
	protected JButton userRankingOrder;
	protected String id;
	protected String pwd;
	protected String[] datas;
	Font font;
	
	ImageIcon i = new ImageIcon("./src/Image/mainLogo.png");
	Image im = i.getImage();
	

	public MainView(String id, String pwd, int flag) {
		this.flag = flag;
		font = new Font("휴먼고딕", Font.PLAIN, 12);
		// setting
		setTitle("Japanese Saying Main Screen");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(600, 350);

		setLayout(new FlowLayout());


		// panel
		
		MyPanel imagePanel = new MyPanel();
		JPanel mainPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		
		imagePlacePanel(imagePanel);
		btnPlacePanel(btnPanel);
		mainPlacePanel(mainPanel);
		
		
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
	
	private void btnPlacePanel(JPanel panel) {
		// TODO Auto-generated method stub
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		panel.setPreferredSize(new Dimension(400, 50));
		panel.setBackground(Color.white);
		
		registerOrder = new JButton("Register Order");
		inquiryOrder = new JButton("Inquiry Order");
		userRankingOrder = new JButton("User Ranking");
		
		createBtn(registerOrder, panel);
		createBtn(inquiryOrder, panel);
		createBtn(userRankingOrder, panel);
		
		
		add(panel);
		
	}

	
	private void createBtn(JButton btn, JPanel panel) {
		// TODO Auto-generated method stub
		
		btn.setPreferredSize(new Dimension(400/3, 50));
		btn.setBorderPainted(true);
		LineBorder btnBorder = new LineBorder(Color.BLACK,1);
		btn.setBorder(btnBorder);

		btn.setOpaque(true);
		btn.setBackground(Color.WHITE);
		btn.setForeground(Color.BLACK);
		btn.setFont(font);
		panel.add(btn);
	}


	private void imagePlacePanel(MyPanel panel) {
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		panel.setPreferredSize(new Dimension(400, 50));
		
		add(panel);
		
	}
	
	public void mainPlacePanel(JPanel panel) {
		
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
