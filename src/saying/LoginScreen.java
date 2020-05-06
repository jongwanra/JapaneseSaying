package saying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//import parking.PAMain;
//import parking.PAMainUI;
//import parking.PMain;
//import parking.PMainUI;
import saying.MainUI;

 //login screen
public class LoginScreen extends JFrame{
	private MainUI mainUI;
	private Main main;
	private JButton btnLogin, btnAdmin;
	private JButton btnInit;
	private JTextField userText;
	private JTextField phoneText;
	private JRadioButton[] rbtn = new JRadioButton[2];
	
	public LoginScreen() {
		
		//setting
		setTitle("Japanese Saying");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 600);
		setResizable(false);
		setLocation(600, 350);
		GridLayout layout = new GridLayout(2, 1);
		setLayout(layout);
		//panel
		Color color1 = new Color(120,255,0);
		Color color2 = new Color(50,20,0);
		JPanel panel1 = new JPanel();
		panel1.setBackground(color1);
		panel1.setPreferredSize(new Dimension(250,350));
		JPanel panel2 = new JPanel();
		panel2.setBackground(color2);
		panel2.setPreferredSize(new Dimension(250,350));
		placeEnterPanel(panel1);
		imagePanel(panel2);
		
		// add
		add(panel2);
		add(panel1);
		
		// visible
		setVisible(true);
	}
	public void imagePanel(JPanel panel){
		
	}
	
	public void placeEnterPanel(JPanel panel){
		panel.setLayout(null);
				
		JLabel userLabel = new JLabel("ID : ");
		userLabel.setBounds(80, 50, 100, 125);
		panel.add(userLabel);
		
		JLabel passLabel = new JLabel("PW : ");
		passLabel.setBounds(80, 90, 100, 125);
		panel.add(passLabel);
				
		userText = new JTextField("ID를 입력해주세요.",20);
		userText.setBounds(120, 100, 200, 25);
		panel.add(userText);
		
		phoneText = new JTextField("비밀번호를 입력해 주세요.",20);
		phoneText.setBounds(120, 140, 200, 25);
		panel.add(phoneText);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(80, 170, 100, 30);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		//reset
		btnInit = new JButton("Reset");
		btnInit.setBounds(180, 170, 100, 30);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				phoneText.setText("");
			}
		});
		btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(200, 200, 80, 20);
		panel.add(btnAdmin);
//		btnAdmin.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				isAdminCheck();
//			}
//		});
	}
	
	public void Login(){
		this.dispose(); // 창닫기
		this.main = new Main(new MainUI(userText.getText(), phoneText.getText())); // 프레임 오픈
		main.appMain();
	}
//	public void isExitCheck(){
//		int result = JOptionPane.showConfirmDialog(null, userText.getText()+" 출차 하시겠습니까?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//		if(result == 0) {
//			this.dispose(); // 창닫기
//			this.pmain = new PMain(new PMainUI(1, userText.getText(), phoneText.getText())); // 프레임 오픈
//			pmain.appMain();
//		}
////	}
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
