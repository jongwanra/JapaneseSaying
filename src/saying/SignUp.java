package saying;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import saying.SignUpUI;

public class SignUp {

	String jdbcDriver = "com.mysql.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://localhost:3306/madang";
	String id = "madang";
	String pwd = "madang";

	SignUpUI ui;
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	String sql;
	
	public SignUp() {
		
	}
	
	//DB connect
	public void connectDB() {
		try {
			Class.forName(jdbcDriver); // JDBC 드라이버 로드
			System.out.println("conn exsit!!");
			conn = DriverManager.getConnection(jdbcUrl, id, pwd); // DB연결
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//DB close
	public void closeDB() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean newUser(String UserName, String Password, String PhoneNum) {
		connectDB();
		
		sql = "INSERT INTO UserInfo " + "(UserID, UserName, PhoneNum) " + "VALUES ('" + UserName + "','" + Password
				+ "','" + PhoneNum + "'" + ");";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UserName);
			pstmt.setString(2, Password);
			pstmt.setString(3, PhoneNum);
    		pstmt.executeUpdate();	// SQL문 전송
    		return true;
    		
    	} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// SignUp Check Function!
	public boolean RegisterData(SignUpUI ui) {
		ui = new SignUpUI();
		this.ui = ui;
		System.out.println("Success Data Send2");
		
		String UserName = ui.txtUsername.getText();
		String Password = new String(ui.txtPassword.getPassword());
		String ConfirmPassword = new String(ui.txtConfirmPassword.getPassword());
		String Name = ui.txtName.getText();
		String PhoneNum = ui.txtPhoneNum.getText();
		boolean status = false;
		
		
		System.out.println("!!!!!" + UserName);
		System.out.println("!!!!!" + Password);
		System.out.println("!!!!!" + Name);

		// Username
		if (UserName.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Username)");
			ui.txtUsername.requestFocusInWindow();
			return false;
		}
		// Password
		if (Password.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Password)");
			ui.txtPassword.requestFocusInWindow();
			return false;
		}
		// Confirm Password
		if (ConfirmPassword.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Confirm Password)");
			ui.txtConfirmPassword.requestFocusInWindow();
			return false;
		}
		// Password math
		if (!Password.equals(ConfirmPassword)) {
			JOptionPane.showMessageDialog(null, "Please Input (Password Not Match!)");
			ui.txtPassword.requestFocusInWindow();
			return false;
		}
		// Name
		if (Name.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Name)");
			ui.txtName.requestFocusInWindow();
			return false;
		}
		// Phone Number
		if (PhoneNum.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (PhoneNumber)");
			ui.hPhoneNum.requestFocusInWindow();
			return false;
		}

		try {
			
		
		//Register User
		
		status = newUser( UserName, Password, PhoneNum);		
		stmt.execute(sql);

			// Reset Text Fields
			ui.txtUsername.setText("");
			ui.txtPassword.setText("");
			ui.txtConfirmPassword.setText("");
			ui.txtName.setText("");
			ui.txtPhoneNum.setText("");

			status = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		closeDB();
		return status;
		
	}
	
	public static void main(String[] args) {

	}

}
