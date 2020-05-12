package saying;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

 //login screen
public class OneofSayingUI extends JFrame{
	private MainUI mainUI;
	private Main main;
	private JButton btnLogin, btnAdmin;
	private JButton btnInit;
	
	private JTextField id;
	private JTextField pwd;
	ImageIcon i = new ImageIcon("./src/Image/Background.jpeg");
	Image im = i.getImage();

	public OneofSayingUI() {
		
		//setting
		setTitle("Japanese Saying");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setResizable(false);
		setLocation(600, 350);
		
		
		MyPanel panel = new MyPanel();
		placeMainPanel(panel);
		
		
		setSize(400, 600);
		
		// visible
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0,0, getWidth(),getHeight(),this);
			
		}
		
	}
	
	public void placeMainPanel(MyPanel panel) {
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400,600));
		add(panel);
		
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel("ID : ");
		userLabel.setBounds(80, 50, 100, 125);
		panel.add(userLabel);
		
		JLabel passLabel = new JLabel("PW : ");
		passLabel.setBounds(80, 90, 100, 125);
		panel.add(passLabel);
				
		id = new JTextField("ID를 입력해주세요.",20);
		id.setBounds(120, 100, 200, 25);
		panel.add(id);
		
		pwd = new JTextField("비밀번호를 입력해 주세요.",20);
		pwd.setBounds(120, 140, 200, 25);
		panel.add(pwd);

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
				id.setText("");
				pwd.setText("");
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
