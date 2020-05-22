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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AdminView extends JFrame {
	private SayingDAO dao;
	private LoginView loginScreen;
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
	protected int flag = 0;

	Font font;

	ImageIcon i = new ImageIcon("./src/Image/mainLogo.png");
	Image im = i.getImage();

	public AdminView(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		font = new Font("휴먼고딕", Font.PLAIN, 12);

		setTitle("Japanese Admain View");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(600, 100);

		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		MyPanel imagePanel = new MyPanel();
		JPanel mainPanel = new JPanel();

		imagePlacePanel(imagePanel);

		createBtn = new JButton("Create");
		readBtn = new JButton("Read");
		updateBtn = new JButton("Update");
		deleteBtn = new JButton("Delete");
		backBtn = new JButton("Back");

		if (flag == 0) {
			mainBtnMethod(createBtn);
			BtnMethod(readBtn);
			BtnMethod(updateBtn);
			BtnMethod(deleteBtn);
			BtnMethod(backBtn);
			
			JPanel createPanel = new JPanel();
			createMainPenel(createPanel);
		} else if (flag == 1) {
			BtnMethod(createBtn);
			mainBtnMethod(readBtn);
			BtnMethod(updateBtn);
			BtnMethod(deleteBtn);
			BtnMethod(backBtn);
			
			JPanel readPanel = new JPanel();
			readMainPanel(readPanel);
		} else if (flag == 2) {
			BtnMethod(createBtn);
			BtnMethod(readBtn);
			mainBtnMethod(updateBtn);
			BtnMethod(deleteBtn);
			BtnMethod(backBtn);
			
			JPanel updatePanel = new JPanel();
			updateMainPanel(updatePanel);
		} else if (flag == 3) {
			BtnMethod(createBtn);
			BtnMethod(readBtn);
			BtnMethod(updateBtn);
			mainBtnMethod(deleteBtn);
			BtnMethod(backBtn);
			
			JPanel deletePanel = new JPanel();
			deleteMainPanel(deletePanel);
		}
		
		setSize(400, 600);
		// visible
		setVisible(true);

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

	private void createMainPenel(JPanel panel) {
		// TODO Auto-generated method stub
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel.setPreferredSize(new Dimension(400, 500));
		panel.setBackground(Color.WHITE);

		JPanel sayingPanel = new JPanel();
		JPanel koreanPanel = new JPanel();
		JPanel addPanel = new JPanel();

		sayingPanel.setBackground(Color.WHITE);
		sayingPanel.setPreferredSize(new Dimension(400, 200));
		sayingPanel.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 5, false)));
		sayingPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		koreanPanel.setBackground(Color.WHITE);
		koreanPanel.setPreferredSize(new Dimension(400, 200));
		koreanPanel.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 5, false)));
		koreanPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		addPanel.setBackground(Color.WHITE);
		addPanel.setPreferredSize(new Dimension(400, 100));
		addPanel.setBorder(new TitledBorder(new LineBorder(Color.WHITE, 5, false)));
		addPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 10));

		panel.add(sayingPanel);
		panel.add(koreanPanel);

		sayingArea = new JTextArea(10, 10);
		sayingArea.setText("Please Write Saying");
		sayingScroll = new JScrollPane(sayingArea);
		sayingPanel.add(sayingArea);

		koreanArea = new JTextArea(10, 10);
		koreanArea.setText("Please Write Korean");
		koreanScroll = new JScrollPane(koreanArea);
		koreanPanel.add(koreanArea);

		sayingScroll = new JScrollPane(sayingPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		sayingScroll.setPreferredSize(new Dimension(400, 200));

		koreanScroll = new JScrollPane(koreanPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		koreanScroll.setPreferredSize(new Dimension(400, 200));

		add(sayingScroll);
		add(koreanScroll);
		
		addBtn = new JButton("Save");
		addBtn.setPreferredSize(new Dimension(330, 50));
		addBtn.setBorderPainted(false);
		addBtn.setOpaque(true);
		addBtn.setBackground(Color.BLACK);
		addBtn.setForeground(Color.WHITE);
		addBtn.setFont(font);
		
		addPanel.add(addBtn);
		
		add(addPanel);
		
		
		

//		addBtn = new JButton("add");
//		addBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dao = new SayingDAO();
//
//				String sayingTxt = sayingArea.getText();
//				String koreanTxt = koreanArea.getText();
//
//				if (dao.newSaying(sayingTxt, koreanTxt)) {
//					System.out.println("addSaying Success!");
//					sayingArea.setText("");
//					koreanArea.setText("");
//
//				} else {
//					System.out.println("addSaying error!");
//				}
//			}
//		});
//
//		backBtn = new JButton("back");
//		backBtn.setBounds(120, 500, 50, 50);
//
//		add(backBtn);
//		add(addBtn);
	}

	private void readMainPanel(JPanel panel) {
		// TODO Auto-generated method stub

	}

	private void updateMainPanel(JPanel panel) {
		// TODO Auto-generated method stub

	}

	private void deleteMainPanel(JPanel panel) {
		// TODO Auto-generated method stub

	}

	public void back() {
		this.dispose();
		this.loginScreen = new LoginView();
	}

	public static void main(String[] args) {

	}

//Register Event Listener
	public void addButtonActionListener(ActionListener listener) {

//		addBtn.addActionListener(listener);
//		backBtn.addActionListener(listener);
	}

}
