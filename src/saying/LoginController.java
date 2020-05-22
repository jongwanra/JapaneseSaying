package saying;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginController {
	private LoginView view;
	private SayingModel model;
	private SignUpView signUpView;
	private SignUpController signUpController;
	private AdminView adminView;
	private MainController mainController;
	
	private SayingDAO dao;
	
	public LoginController(LoginView view) {
		this.view = view;
	}
	
	public void appMain() {
		view.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				 if (obj == view.btnInit) {
					System.out.println("btnInit!!");
					init();
				}else if (obj == view.btnLogin) {
					System.out.println("btnLogin!!");
					login();
					
				}else if (obj == view.btnSignUp) {
					System.out.println("btnSignUp!!");
					signUp();
				}
				 
				
			}

		});
	}
	
	protected void init() {
		// TODO Auto-generated method stub
		view.userName.setText("");
		view.password.setText("");
		
	}
	
	protected void login() {
		
		dao = new SayingDAO();
		String getUserName = view.userName.getText();
		String getPassword = new String(view.password.getText());

		if (dao.loginCheck(getUserName, getPassword)) {
			 view.dispose(); // 창닫기

			// administer
			if (getUserName.equals("admin") && getPassword.equals("admin")) {
				System.out.println("admin Page!");
				this.adminView = new AdminView(getUserName, getPassword);
			} else {
				this.mainController = new MainController(new MainView(view.userName.getText(), view.password.getText(), 0)); // 프레임 오픈
				mainController.appMain();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
		}

	}

	protected void signUp() {
		System.out.println("signUp!!!");
		view.dispose();
		this.signUpController = new SignUpController(new SignUpView());
		this.signUpController.appMain();
	}
	

	
	
}
