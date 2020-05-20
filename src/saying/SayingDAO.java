package saying;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class SayingDAO {

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
	int sayingNum;
	int sayingCnt;
	int sayingIndex;
	int flag;
	String userName;
	String password;
	String phoneNum;
	String saying;
	String korean;

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
	
	public String[] getOneofSaying(int sayingIndex, int flag) {
		
		String[] datas = new String[2];
		this.sayingIndex = sayingIndex;
		this.flag = flag;
		connectDB();

		if(flag == 0) {
			System.out.println("register Order get OneofSaying");
			sql = "select Saying, Korean from SayingInfo where SayingNum = ?";
		}
			
		else if(flag == 1) {
			System.out.println("inquiry Order get OneofSaying");
			sql = "select Saying, Korean from SayingInfo order by SayingNum desc";
		}
			
		else if(flag == 2){
			System.out.println("userRanking Order get OneofSaying");
			sql = "";
		}
			
		
		System.out.println(sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (sayingIndex + 1));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				datas[0] = rs.getString("Saying");
				datas[1] = rs.getString("Korean");
				
				System.out.println(datas[0] + "/" + datas[1]);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed getInformation");
			e.printStackTrace();
			closeDB();
			
		}
		
		return datas;

	}

	// Check ID && PWD
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

	// new Number
	public int SelectUserNum() {
		int result = 0;
		connectDB();

		sql = "select max(UserNum) from UserInfo";
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("max(UserNum)");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public int SelectSayingNum() {
		int result = 0;
		connectDB();

		sql = "select max(SayingNum) from sayingInfo";
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
	//register Order
	public String[] getSayingRegister() {
		int i = 0;
		String[] datas = new String[50];
		sql = "select Saying from Sayinginfo";
		connectDB();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas[i] = rs.getString("Saying");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datas;
	}
	
	public String[] getSayingInquiry() {
		int i = 0;
		String[] datas = new String[50];
		sql = "select Saying from Sayinginfo";
		connectDB();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas[i] = rs.getString("Saying");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	
	public String[] getUserRanking() {
		int i = 0;
		String[] datas = new String[50];
		//내림차순
		sql = "select UserName from UserInfo ORDER BY UserNum DESC";
		System.out.println(sql);
		connectDB();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas[i] = rs.getString("UserName");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	
	public boolean newSaying(String saying, String korean) {
		
		this.sayingNum = SelectSayingNum() + 1;
		this.saying = saying;
		this.korean = korean;
		this.sayingCnt = sayingNum;
		//this.sayingNum = SelectUserNum() + 1;
		//this.sayingCnt = SelectUserNum() + 1;

		connectDB();
		sql = "insert into SayingInfo (SayingNum, Saying, Korean, SayingCnt) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sayingNum);
			pstmt.setString(2, saying);
			pstmt.setString(3, korean);
			pstmt.setInt(4, sayingCnt);
			pstmt.executeUpdate(); // SQL문 전송

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

	public int[] refreshSaying() {
		int[] stat = new int[50];
		int i = 0;

		connectDB();
		sql = "select * from Sayinginfo";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stat[i++] = rs.getInt("status");
			}
			return stat;
		} catch (Exception e) {
			e.printStackTrace();
			return stat;
		}
	}

}
