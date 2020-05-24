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

	protected int sayingCnt;

	public LoginController(LoginView view) {
		this.view = view;
	}

	public void appMain() {
		view.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();

				if (obj == view.btnInit)
					init();
				else if (obj == view.btnLogin)
					login();
				else if (obj == view.btnSignUp)
					signUp();
			}

		});
	}

	protected void init() {
		// TODO Auto-generated method stub
		view.userName.setText("");
		view.password.setText("");

	}

	protected void login() {

		String getUserName = view.userName.getText();
		String getPassword = new String(view.password.getText());

		dao = new SayingDAO();
		if (dao.loginCheck(getUserName, getPassword)) {
			view.dispose(); // close view

			// administer
			if (getUserName.equals("admin") && getPassword.equals("admin")) {
				adminController = new AdminCreateController(new AdminCreateView(getUserName, getPassword));
				adminController.appMain();

			}
			// user
			else {
				// user Cnt
				dao.loginCount(getUserName, getPassword);
				mainController = new MainController(new MainView(getUserName, getPassword, 0));
				mainController.appMain();

			}
		} else {
			JOptionPane.showMessageDialog(null, "Faild");
		}

	}

	//Enter SignUp View
	protected void signUp() {
		view.dispose();
		signUpController = new SignUpController(new SignUpView());
		signUpController.appMain();
	}

}
