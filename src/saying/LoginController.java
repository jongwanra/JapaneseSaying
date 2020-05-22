package saying;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginController {
	private LoginView view;
	private SayingModel model;
	private SignUpView signUpView;
	private SignUpController signUpController;
	private AdminCreateView adminView;
	private AdminCreateController adminController;
	private MainController mainController;
	private SayingDAO dao;
	
	private String[] datas;
	
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
				this.adminController = new AdminCreateController(new AdminCreateView(getUserName, getPassword));
				this.adminController.appMain();
						
			} else {
				dao.loginCount(getUserName, getPassword);
				
				datas = new String[50];
				datas = dao.getSayingRegister();
				this.mainController = new MainController(new MainView(getUserName, getPassword, 0, datas)); 
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
