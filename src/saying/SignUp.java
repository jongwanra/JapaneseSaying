package saying;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUp {

	String jdbcDriver = "com.mysql.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://localhost:3306/madang";
	String id = "madang";
	String pwd = "madang";

	SignUpUI ui;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String sql;
	int userNum;
	String userName;
	String password;
	String phoneNum;

	
	public SignUp() {

	}

	// DB connect
	public void connectDB() {
		try {
			Class.forName(jdbcDriver); // JDBC 드라이버 로드
			System.out.println("conn exsit!!");
			conn = DriverManager.getConnection(jdbcUrl, id, pwd); // DB연결

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB close
	public void closeDB() {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// アイディとパースワード確認
	public boolean loginCheck(String userName, String password) {

		this.userName = userName;
		this.password = password;

		connectDB();

		sql = "select UserId, UserName from UserInfo where UserID = ?";
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String idd = rs.getString("UserId");
				String pwdd = rs.getString("UserName");

				if (idd.equals(userName) && pwdd.equals(password)) {
					System.out.println("Success Login");
					closeDB();
					return true;
				} else {
					System.out.println("Failed Login");
					closeDB();
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed Login");
			e.printStackTrace();
			closeDB();
			return false;
		}

		return false;
	}

	// 최근 등록한 UserId의 총 갯수 
	public int SelectUserNum() {
		int result = 0;
		connectDB();

		sql = "select max(UserNum) from UserInfo";
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
    		rs = pstmt.executeQuery();
			if(rs.next()) {
				result =rs.getInt("max(UserNum)");
			}
    		return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

		
	}

	public boolean newUser(String userName, String password, String phoneNum) {

		this.userNum = SelectUserNum() + 1;
		this.userName = userName;
		this.password = password;
		this.phoneNum = phoneNum;

		connectDB();

		sql = "insert into UserInfo (UserNum, UserID, UserName, PhoneNum) values (?, ?, ?, ?)";
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			pstmt.setString(2, userName);
			pstmt.setString(3, password);
			pstmt.setString(4, phoneNum);
			pstmt.executeUpdate(); // SQL문 전송
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) {

	}

}
