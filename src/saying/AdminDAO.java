package saying;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

	String jdbcDriver = "com.mysql.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://localhost:3306/JapaneseSaying";
	String id = "root";
	String pwd = "dreamele19!";

	SignUpView ui;
	Connection conn;

	PreparedStatement pstmt;
	ResultSet rs;

	String sql;
	String sql2;

	private int userNum;
	private int sayingNum;
	private int sayingCnt;
	private int sayingIndex;
	private int flag;
	private String userID;
	private String userName;
	private String userPwd;
	private String phoneNum;
	private String saying;
	private String korean;

	// DB Connect
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

	public int SelectSayingNum() {
		int result = 0;
		connectDB();

		sql = "select max(sayingNum) from SayingInfo";
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("max(sayingNum)");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public boolean newSaying(String saying, String korean) {

		this.sayingNum = SelectSayingNum() + 1;
		this.saying = saying;
		this.korean = korean;

		connectDB();
		sql = "insert into SayingInfo (sayingNum, saying, korean) values(?,?,?)";
		sql2 = "insert into SayingCnt values(?, ?)";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sayingNum);
			pstmt.setString(2, saying);
			pstmt.setString(3, korean);
			pstmt.executeUpdate(); // SQL문 전송

			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, sayingNum);
			pstmt.setInt(2, 0);
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSaying(int num) {
		connectDB();
		sql = "update ...";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate(); // SQL문 전송
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
