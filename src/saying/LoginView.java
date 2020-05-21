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
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//login screen
public class LoginView extends JFrame {
	private Font font;
	private SayingDAO dao;
	MainView mainUI;
	AdminView adminUI;
	MainController main;
	SignUpView signUpScreen;
	JButton btnLogin, btnSignUp;
	JButton btnInit;
	JLabel imgBox;

	JTextField userName;
	JTextField password;
	ImageIcon i = new ImageIcon("./src/Image/LoginScreenLogo.png");
	Image im = i.getImage();

	// Changing Icon Size
//	ImageIcon idIcon = new ImageIcon("./src/Image/LoginID.png");
//	Image idImg = idIcon.getImage();
//	Image changedIdImg = idImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//	ImageIcon newIdIcon = new ImageIcon(changedIdImg);
//	
//	ImageIcon pwdIcon = new ImageIcon("./src/Image/LoginPWD.png");
//	Image pwdImg = pwdIcon.getImage();
//	Image changedPwdImg = pwdImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//	ImageIcon newPwdIcon = new ImageIcon(changedPwdImg);

	public LoginView() {
		// setting
		setTitle("Japanese Saying");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setLocation(600, 350);

		// MyPanel panel = new MyPanel();
		MyPanel panel = new MyPanel();
		placeMainPanel(panel);

		// add(panel);
		setSize(400, 600);

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

		g.drawLine(58, 345, 340, 345);
		g.drawLine(58, 383, 340, 383);

	}

	public void placeMainPanel(JPanel panel) {

		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 600));

		JPanel input = new JPanel();
		JPanel input2 = new JPanel();

		Color color1 = new Color(119, 135, 194, 80);
		Color color2 = new Color(250, 250, 249);

		// panel.setBackground(color2);

		input.setBackground(color2);
		input.setBorder(new TitledBorder(new LineBorder(color2, 5, false)));
		input.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		input.setBounds(45, 280, 310, 100);

		input2.setBackground(color2);
		input2.setBorder(new TitledBorder(new LineBorder(color2, 5, false)));
		input2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		input2.setBounds(40, 370, 320, 150);

		panel.add(input2);
		panel.add(input);

		font = new Font("휴먼고딕", Font.PLAIN, 12);

		// JLabel userLabel = new JLabel(newIdIcon);
		JLabel userLabel = new JLabel("ID :");
		userLabel.setFont(font);
		input.add(userLabel);

		userName = new JTextField("", 23);
		userName.setFont(font);
		userName.setBorder(null);
		input.add(userName);

		// JLabel passLabel = new JLabel(newPwdIcon);
		JLabel passLabel = new JLabel("PW :");
		passLabel.setFont(font);
		input.add(passLabel);

		password = new JPasswordField("", 13);
		password.setBorder(null);
		input.add(password);

		// reset
		btnInit = new JButton("Reset");
		btnInit.setPreferredSize(new Dimension(80, 25));
		btnInit.setBackground(Color.black);
		btnInit.setBorderPainted(false);
		btnInit.setContentAreaFilled(false);

		input.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userName.setText("");
				password.setText("");
			}
		});

		btnLogin = new JButton("Login");
		btnLogin.setPreferredSize(new Dimension(310, 50));
		btnLogin.setBorderPainted(false);
//		btnLogin.setContentAreaFilled(false);
		btnLogin.setOpaque(true);
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(font);
		input2.add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});

		btnSignUp = new JButton("Create Account");
		btnSignUp.setPreferredSize(new Dimension(310, 50));
		btnSignUp.setFont(font);
		// btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setBorderPainted(false);
		// btnSignUp.setContentAreaFilled(false);
		input2.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			// into SignUpScreen
			public void actionPerformed(ActionEvent e) {
				SignUp();
			}
		});

		add(panel);

	}

	public void Login() {
		dao = new SayingDAO();
		String getUserName = userName.getText();
		String getPassword = new String(password.getText());

		if (dao.loginCheck(getUserName, getPassword)) {
			this.dispose(); // 창닫기

			// administer
			if (getUserName.equals("admin") && getPassword.equals("admin")) {
				System.out.println("admin Page!");
				this.adminUI = new AdminView(getUserName, getPassword);
			} else {
				this.main = new MainController(new MainView(userName.getText(), password.getText(), 0)); // 프레임 오픈
				main.appMain();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Faild");
		}

	}

	public void SignUp() {
		this.dispose();
		this.signUpScreen = new SignUpView();
	}

	public static void main(String[] args) {

	}

}
