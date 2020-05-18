package saying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

//login screen
public class LoginScreen extends JFrame {
	MainUI mainUI;
	Main main;
	SignUpUI signUpScreen;
	JButton btnLogin, btnSingUp;
	JButton btnInit;

	JTextField userName;
	JTextField password;
	ImageIcon i = new ImageIcon("./src/Image/Background.jpeg");
	Image im = i.getImage();
	SignUp signUp;

	public LoginScreen() {

		// setting
		setTitle("Japanese Saying");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setLocation(600, 350);

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

	public void placeMainPanel(MyPanel panel) {
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 600));

		JPanel input = new JPanel();
		Color color1 = new Color(119, 135, 194, 80);
		Color color2 = new Color(255, 255, 255);

		input.setBackground(color2);
		input.setBorder(new TitledBorder(new LineBorder(color1, 5, true)));
		input.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		input.setBounds(50, 180, 300, 240);

		panel.add(input);

		JLabel userLabel = new JLabel("ID :");
		input.add(userLabel);

		userName = new JTextField("ID를 입력해주세요.", 20);
		input.add(userName);

		JLabel passLabel = new JLabel("PW:");
		input.add(passLabel);

		password = new JPasswordField("비밀번호를 입력해 주세요.", 20);
		input.add(password);

		btnLogin = new JButton("Login");
		input.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		// reset
		btnInit = new JButton("Reset");
//		btnInit.setBounds(180, 170, 100, 30);
		input.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userName.setText("");
				password.setText("");
			}
		});
		btnSingUp = new JButton("등록");
//		btnSingUp.setBounds(200, 200, 80, 20);
		input.add(btnSingUp);
		btnSingUp.addActionListener(new ActionListener() {
			@Override
			// into SignUpScreen
			public void actionPerformed(ActionEvent e) {
				SignUp();
			}
		});

		add(panel);

	}

	public void Login() {
		signUp = new SignUp();
		String getUserName = userName.getText();
		String getPassword = new String(password.getText());
		
		if (signUp.loginCheck(getUserName, getPassword)) {
			this.dispose(); // 창닫기
			this.main = new Main(new MainUI(userName.getText(), password.getText())); // 프레임 오픈
			main.appMain();
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
		}

	}

	public void SignUp() {
		this.dispose();
		this.signUpScreen = new SignUpUI();
	}

//	public void isAdminCheck(){
//		String name = JOptionPane.showInputDialog("Admin Password");
//		if(name != null) {
//      		if(name.equals("admin")) {
//      			JOptionPane.showMessageDialog(null, "Success");
//      			this.dispose(); // 창닫기
//      			this.pamain = new PAMain(new PAMainUI());
//      			pamain.appMain();
//      		}
//      		else {
//      			JOptionPane.showMessageDialog(null, "Faild");
//      		}
//		}
//	}
	public static void main(String[] args) {

	}

}
