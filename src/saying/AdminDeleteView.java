package saying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class AdminDeleteView extends JFrame {
	private SayingDAO dao;
	private LoginView loginView;
	protected String id;
	protected String pwd;
	protected JScrollPane sayingScroll;
	protected JScrollPane koreanScroll;

	protected JTextArea sayingArea;
	protected JTextArea koreanArea;

	protected JButton createBtn;
	protected JButton readBtn;
	protected JButton updateBtn;
	protected JButton deleteBtn;
	protected JButton addBtn;
	protected JButton backBtn;

	Font font;

	ImageIcon i = new ImageIcon("./src/Image/mainLogo.png");
	Image im = i.getImage();
	private JScrollPane userScrollPane;
	private JScrollPane sayingScrollPane;
	protected JButton[] userBtn;
	protected JButton[] sayingBtn;
	private String[] userDatas;
	private String[] sayingDatas;
	protected int userCnt;
	protected int sayingCnt;

	public AdminDeleteView(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;

		System.out.println(id + "!!");
		System.out.println(pwd + "!!");

		font = new Font("휴먼고딕", Font.PLAIN, 12);

		setTitle("Japanese Admain View");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(600, 100);

		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		MyPanel imagePanel = new MyPanel();

		imagePlacePanel(imagePanel);

		createBtn = new JButton("Create");
		readBtn = new JButton("Read");
		updateBtn = new JButton("Update");
		deleteBtn = new JButton("Delete");
		backBtn = new JButton("Back");

		BtnMethod(createBtn);
		BtnMethod(readBtn);
		BtnMethod(updateBtn);
		mainBtnMethod(deleteBtn);
		BtnMethod(backBtn);

		JPanel userPanel = new JPanel();
		deleteUserPlace(userPanel);

		JPanel sayingPanel = new JPanel();
		deleteSayingPlace(sayingPanel);

		setSize(400, 600);

		// visible
		setVisible(true);

	}

	//User Place
	private void deleteUserPlace(JPanel panel) {
		dao = new SayingDAO();
		this.userCnt = dao.SelectUserNum();
		
		userDatas = new String[userCnt];
		userDatas = dao.getAdminUserRegister();
		
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 0));
		panel.setPreferredSize(new Dimension(340, 50 * userCnt));
		panel.setBackground(Color.WHITE);
		
		userBtn = new JButton[userCnt];
		for (int i = 0; i < userCnt; i++) {
			userBtn[i] = new JButton("<html>" + userDatas[i] + "</html>");
			userBtn[i].setPreferredSize(new Dimension(350, 50));
			btnDesign(userBtn[i], panel);
			
		}

		userScrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		userScrollPane.setPreferredSize(new Dimension(400, 230));
		
		add(userScrollPane);

	}
	
	
	//Saying Place
	private void deleteSayingPlace(JPanel panel) {
		
		dao = new SayingDAO();
		sayingCnt = dao.SelectSayingNum();
		sayingDatas = new String[sayingCnt];
		sayingDatas = dao.getAdminSayingRegister();
		
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 0));
		panel.setPreferredSize(new Dimension(340, 80 * sayingCnt));
		panel.setBackground(Color.WHITE);

		sayingBtn = new JButton[sayingCnt];
		for (int i = 0; i < sayingCnt; i++) {
			sayingBtn[i] = new JButton("<html>" + sayingDatas[i]+ "</html>");
			sayingBtn[i].setPreferredSize(new Dimension(350, 80));
			btnDesign(sayingBtn[i], panel);
		}

		sayingScrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sayingScrollPane.setPreferredSize(new Dimension(400, 270));
		add(sayingScrollPane);
	}


	private void btnDesign(JButton btn, JPanel panel) {
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


	private void BtnMethod(JButton btn) {
		// TODO Auto-generated method stub

		btn.setPreferredSize(new Dimension(400 / 5, 50));
		btn.setBorderPainted(true);
		LineBorder btnBorder = new LineBorder(Color.BLACK, 1);
		btn.setBorder(btnBorder);

		btn.setOpaque(true);
		btn.setBackground(Color.WHITE);
		btn.setForeground(Color.BLACK);
		btn.setFont(font);
		add(btn);
	}

	private void mainBtnMethod(JButton btn) {
		btn.setPreferredSize(new Dimension(400 / 5, 50));
		btn.setBorderPainted(true);
		LineBorder btnBorder = new LineBorder(Color.BLACK, 1);
		btn.setBorder(btnBorder);
		btn.setOpaque(true);
		btn.setBackground(Color.BLACK);
		btn.setForeground(Color.WHITE);
		btn.setFont(font);
		add(btn);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);

		}

	}

	public void imagePlacePanel(MyPanel panel) {
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel.setPreferredSize(new Dimension(400, 50));

		add(panel);
	}

	public static void main(String[] args) {

	}

//Register Event Listener
	public void addButtonActionListener(ActionListener listener) {
		for(int i = 0; i < userCnt; i++)
			userBtn[i].addActionListener(listener);
		
		for(int i = 0; i < sayingCnt; i++)
			sayingBtn[i].addActionListener(listener);
		
		backBtn.addActionListener(listener);
		createBtn.addActionListener(listener);
		readBtn.addActionListener(listener);
		updateBtn.addActionListener(listener);
		deleteBtn.addActionListener(listener);

	}

}
