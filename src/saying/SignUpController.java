package saying;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SignUpController {
	private SignUpView view;
	private LoginController loginController;
	private SayingModel model;
	private SayingDAO dao;
	
	public SignUpController(SignUpView view) {
		this.view = view;
	}
	
	public void appMain() {
		view.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				 if (obj == view.btnSave) {
					System.out.println("btnSave!!");
					if (RegisterData())
						JOptionPane.showMessageDialog(null, "Register Data Successfully");
					else 
						System.out.println("Register Data fail");
				}else if (obj == view.btnBack) {
					System.out.println("btnBack!!");
					back();
				}
			}
		});
	}

	protected void back() {
		// TODO Auto-generated method stub
		view.dispose(); // 창닫기
		this.loginController = new LoginController(new LoginView());
		this.loginController.appMain();
	}

	// SignUp Check Function!
		protected boolean RegisterData() {
			String userName = view.txtUsername.getText();
			String password = new String(view.txtPassword.getPassword());
			String confirmPassword = new String(view.txtConfirmPassword.getPassword());
			String name = view.txtName.getText();
			String phoneNum = view.txtPhoneNum.getText();
			boolean status = false;

			// Username
			if (userName.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Input (Username)");
				view.txtUsername.requestFocusInWindow();
				return false;
			}
			// Password
			if (password.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Input (Password)");
				view.txtPassword.requestFocusInWindow();
				return false;
			}
			// Confirm Password
			if (confirmPassword.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Input (Confirm Password)");
				view.txtConfirmPassword.requestFocusInWindow();
				return false;
			}
			// Password math
			if (!password.equals(confirmPassword)) {
				JOptionPane.showMessageDialog(null, "Please Input (Password Not Match!)");
				view.txtPassword.requestFocusInWindow();
				return false;
			}
			// Name
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Input (Name)");
				view.txtName.requestFocusInWindow();
				return false;
			}
			// Phone Number
			if (phoneNum.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Input (PhoneNumber)");
				view.hPhoneNum.requestFocusInWindow();
				return false;
			}

			try {

				dao = new SayingDAO();
				if (dao.newUser(userName, password, name, phoneNum))
					System.out.println("Register Success");
				else
					System.out.println("Register fail!");

				// Reset Text Fields
				view.txtUsername.setText("");
				view.txtPassword.setText("");
				view.txtConfirmPassword.setText("");
				view.txtName.setText("");
				view.txtPhoneNum.setText("");

				status = true;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				e.printStackTrace();
			}
			return status;

		}

	public static void main(String[] args) {
		
	}

}
