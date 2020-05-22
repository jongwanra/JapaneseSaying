package saying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class MainView extends JFrame {

	private LoginView loginscreen;
	private int flag = 0;

	protected int saying_cnt = 50;
	protected JButton[] btn = new JButton[saying_cnt];
	protected JScrollPane scrollPane;
	protected JButton registerOrder;
	protected JButton inquiryOrder;
	protected JButton userRankingOrder;
	protected JButton backBtn;
	protected String id;
	protected String pwd;
	protected String[] datas;
	Font font;
	LineBorder btnBorder;

	ImageIcon i = new ImageIcon("./src/Image/mainLogo.png");
	Image im = i.getImage();

	ImageIcon originIcon1 = new ImageIcon("./src/Image/Gold.png");
	Image originImg1 = originIcon1.getImage();
	Image changedImg1 = originImg1.getScaledInstance(18, 42, Image.SCALE_SMOOTH);

	ImageIcon originIcon2 = new ImageIcon("./src/Image/Silver.png");
	Image originImg2 = originIcon2.getImage();
	Image changedImg2 = originImg2.getScaledInstance(18, 42, Image.SCALE_SMOOTH);

	ImageIcon originIcon3 = new ImageIcon("./src/Image/Bronze.png");
	Image originImg3 = originIcon3.getImage();
	Image changedImg3 = originImg3.getScaledInstance(18, 42, Image.SCALE_SMOOTH);
	
	ImageIcon originIcon4 = new ImageIcon("./src/Image/EmptyLogo.png");
	Image originImg4 = originIcon4.getImage();
	Image changedImg4 = originImg4.getScaledInstance(18, 42, Image.SCALE_SMOOTH);

	ImageIcon gold = new ImageIcon(changedImg1);
	ImageIcon silver = new ImageIcon(changedImg2);
	ImageIcon bronze = new ImageIcon(changedImg3);
	ImageIcon empty = new ImageIcon(changedImg4);

	public MainView(String id, String pwd, int flag, String[] datas) {
		this.flag = flag;
		this.datas = datas;
		font = new Font("휴먼고딕", Font.PLAIN, 12);

		// setting
		setTitle("Japanese Saying Main Screen");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(600, 100);

		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		// panel

		MyPanel imagePanel = new MyPanel();
		JPanel mainPanel = new JPanel();

		imagePlacePanel(imagePanel);
		registerOrder = new JButton("Register Order");
		inquiryOrder = new JButton("Inquiry Order");
		userRankingOrder = new JButton("User Ranking");
		backBtn = new JButton("Back");

		if (flag == 0) {
			mainCreateBtn(registerOrder);
			createBtn(inquiryOrder);
			createBtn(userRankingOrder);
		} else if (flag == 1) {
			createBtn(registerOrder);
			mainCreateBtn(inquiryOrder);
			createBtn(userRankingOrder);
		} else if (flag == 2) {
			createBtn(registerOrder);
			createBtn(inquiryOrder);
			mainCreateBtn(userRankingOrder);
		}

		createBtn(backBtn);

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

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);

		}

	}

	private void createBtn(JButton btn) {
		// TODO Auto-generated method stub

		btn.setPreferredSize(new Dimension(400 / 4, 50));
		btn.setBorderPainted(true);
		LineBorder btnBorder = new LineBorder(Color.BLACK, 1);
		btn.setBorder(btnBorder);

		btn.setOpaque(true);
		btn.setBackground(Color.WHITE);
		btn.setForeground(Color.BLACK);
		btn.setFont(font);
		add(btn);
	}

	private void mainCreateBtn(JButton btn) {
		btn.setPreferredSize(new Dimension(400 / 4, 50));
		btn.setBorderPainted(true);
		LineBorder btnBorder = new LineBorder(Color.BLACK, 1);
		btn.setBorder(btnBorder);
		btn.setOpaque(true);
		btn.setBackground(Color.BLACK);
		btn.setForeground(Color.WHITE);
		btn.setFont(font);
		add(btn);
	}

	private void imagePlacePanel(MyPanel panel) {
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel.setPreferredSize(new Dimension(400, 50));

		add(panel);

	}

	public void mainPlacePanel(JPanel panel) {

		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 0));
		panel.setPreferredSize(new Dimension(340, 100 * saying_cnt));
		panel.setBackground(Color.WHITE);

		//when registerOrder
		if (flag == 0) {
			for (int i = 0; i < 5; i++) {
				btn[i] = new JButton(datas[i], empty);
				btnDesign(btn[i], panel);
			}
		} 
		//else
		else {
			for (int i = 0; i < 5; i++) {
				if (i >= 0 && i <= 2 && datas[i] != null) {
					if (i == 0)
						btn[i] = new JButton(datas[i], gold);
					else if (i == 1)
						btn[i] = new JButton(datas[i], silver);
					else if (i == 2)
						btn[i] = new JButton(datas[i], bronze);
				} else
					btn[i] = new JButton(datas[i], empty);

				btnDesign(btn[i], panel);
			}
		}

		scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(400, 500));
		add(scrollPane);

	}

	private void btnDesign(JButton btn, JPanel panel) {
		// TODO Auto-generated method stub

		btn.setPreferredSize(new Dimension(341, 120));
		btn.setBorderPainted(true);
		btn.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));
		btn.setHorizontalAlignment(SwingConstants.LEFT);
		btn.setVerticalAlignment(SwingConstants.BOTTOM);
		btn.setOpaque(true);
		btn.setBackground(Color.WHITE);
		btn.setForeground(Color.BLACK);
		font = new Font("휴먼고딕", Font.PLAIN, 15);
		btn.setFont(font);
		panel.add(btn);

	}

	public void addButtonActionListener(ActionListener listener) {
		// Register Event Listener
		for (int i = 0; i < 5; i++)
			btn[i].addActionListener(listener);
		registerOrder.addActionListener(listener);
		inquiryOrder.addActionListener(listener);
		userRankingOrder.addActionListener(listener);
		backBtn.addActionListener(listener);
	}

}
