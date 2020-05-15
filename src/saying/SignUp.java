package saying;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import saying.SignUpUI;
public class SignUp implements Runnable {

	// connect socket
	private String ip = "127.0.0.1";
	private Socket socket;
	private BufferedReader inMsg = null;
	private PrintWriter outMsg = null;

	// massage parsing
	Gson gson = new Gson();

	// Message m;

	public SignUp() {
	 logger = Logger.getLogger(this.getClass().getName();
 }

	public static void main(String[] args) {

	}

	// SignUp Check Function!
	public boolean RegisterData(SignUpUI ui) {

		String strUsername = ui.txtUsername.getText();
		String strPassword = new String(ui.txtPassword.getPassword());
		String strConfirmPassword = new String(ui.txtConfirmPassword.getPassword());
		String strName = ui.txtName.getText();
		String strEmail = ui.txtEmail.getText();

		// Username
		if (strUsername.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Username)");
			ui.txtUsername.requestFocusInWindow();
			return false;
		}
		// Password
		if (strPassword.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Password)");
			ui.txtPassword.requestFocusInWindow();
			return false;
		}
		// Confirm Password
		if (strConfirmPassword.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Confirm Password)");
			ui.txtConfirmPassword.requestFocusInWindow();
			return false;
		}
		// Password math
		if (!strPassword.equals(strConfirmPassword)) {
			JOptionPane.showMessageDialog(null, "Please Input (Password Not Match!)");
			ui.txtPassword.requestFocusInWindow();
			return false;
		}
		// Name
		if (strName.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Name)");
			ui.txtName.requestFocusInWindow();
			return false;
		}
		// Email
		if (strEmail.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Email)");
			ui.txtEmail.requestFocusInWindow();
			return false;
		}
		Connection connect = null;
		Statement s = null;
		Boolean status = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("" + "jdbc:mysql://localhost/mydatabase" + "?user=root&password=root");

			s = connect.createStatement();

			// SQL Insert
			String sql = "INSERT INTO member " + "(Username,Password,Email,Name) " + "VALUES ('" + strUsername + "','"
					+ strPassword + "','" + strEmail + "'" + ",'" + strName + "') ";
			s.execute(sql);

			// Reset Text Fields
			ui.txtUsername.setText("");
			ui.txtPassword.setText("");
			ui.txtConfirmPassword.setText("");
			ui.txtName.setText("");
			ui.txtEmail.setText("");

			status = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		try {
			if (s != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return status;
	}

	public void run() {

	}

}
