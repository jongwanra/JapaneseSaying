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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import saying.SignUpController;
import saying.LoginView;

public class SignUpView extends JFrame {
	private SayingDAO dao;
	private LoginView loginView;
	private LoginController loginController;
	
	protected JTextField txtUsername;
	protected JPasswordField txtPassword;
	protected JPasswordField txtConfirmPassword;
	protected JTextField txtName;
	protected JTextField txtPhoneNum;
	protected JButton btnSave;
	protected JButton btnBack;
	protected JLabel hRegister;
	protected JLabel hUsername;
	protected JLabel hPassword;
	protected JLabel hConfirmPassword;
	protected JLabel hName;
	protected JLabel hPhoneNum;
	protected int saying_cnt = 50;
	protected int userNum = 0;
	protected Font font;

	ImageIcon i = new ImageIcon("./src/Image/SignUpLogo.png");
	Image im = i.getImage();

	public SignUpView() {
		// setting
		setTitle("SignUp Screen");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setLocation(600, 100);
		setSize(400, 600);

		// panel
		MyPanel panel = new MyPanel();
		placeMainPanel(panel);

		// visible
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);

		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		for (int i = 0; i < 5; i++)
			g.drawLine(40, 242 + (i * 45), 360, 242 + (i * 45));

	}

	public void placeMainPanel(MyPanel panel) {
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 600));

		JPanel textPanel = new JPanel();
		JPanel btnPanel = new JPanel();

		Color bkgColor = new Color(255, 255, 255);
		font = new Font("휴먼고딕", Font.PLAIN, 12);

		textPanel.setBackground(bkgColor);
		textPanel.setBorder(new TitledBorder(new LineBorder(bkgColor, 5, false)));
		textPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));
		textPanel.setBounds(40, 165, 320, 260);

		btnPanel.setBackground(bkgColor);
		btnPanel.setBorder(new TitledBorder(new LineBorder(bkgColor, 5, false)));
		btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));
		btnPanel.setBounds(0, 425, 400, 135);

		panel.add(textPanel);
		panel.add(btnPanel);

		hUsername = new JLabel("Username");
		hUsername.setFont(font);
		textPanel.add(hUsername);

		// CustomerID
		txtUsername = new JTextField("", 18);
		txtUsername.setFont(font);
		txtUsername.setBorder(null);
		textPanel.add(txtUsername);

		hPassword = new JLabel("Password");
		hPassword.setFont(font);
		textPanel.add(hPassword);

		// Password
		txtPassword = new JPasswordField("", 18);
		txtPassword.setFont(font);
		txtPassword.setBorder(null);
		textPanel.add(txtPassword);

		hConfirmPassword = new JLabel("Confirm Password");
		hConfirmPassword.setFont(font);
		textPanel.add(hConfirmPassword);

		// Confirm Password
		txtConfirmPassword = new JPasswordField("", 14);
		txtConfirmPassword.setFont(font);
		txtConfirmPassword.setBorder(null);
		textPanel.add(txtConfirmPassword);

		hName = new JLabel("Name");
		hName.setFont(font);
		textPanel.add(hName);

		// Name
		txtName = new JTextField("", 20);
		txtName.setFont(font);
		txtName.setBorder(null);
		textPanel.add(txtName);

		hPhoneNum = new JLabel("Phone Number");
		hPhoneNum.setFont(font);
		textPanel.add(hPhoneNum);

		// Phone Number
		txtPhoneNum = new JTextField("", 10);
		txtPhoneNum.setFont(font);
		txtPhoneNum.setBorder(null);
		textPanel.add(txtPhoneNum);

		// Save Button
		btnSave = new JButton("Save");
		btnSave.setPreferredSize(new Dimension(320, 50));
		btnSave.setBorderPainted(false);
		btnSave.setOpaque(true);
		btnSave.setBackground(Color.BLACK);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(font);
		

		btnPanel.add(btnSave);

		// Back Button
		btnBack = new JButton("back");
		btnBack.setPreferredSize(new Dimension(320, 50));
		btnBack.setFont(font);
		btnBack.setBorderPainted(false);
		btnPanel.add(btnBack);
		
		add(panel);
	}

	
	
    // Register Event Listener	
	public void addButtonActionListener(ActionListener listener) {
		btnSave.addActionListener(listener);
		btnBack.addActionListener(listener);
    }
}