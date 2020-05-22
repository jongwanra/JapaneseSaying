package saying;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class SayingDAO {

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
	public boolean loginCheck(String userName, String userPwd) {

		this.userName = userName;
		this.userPwd = userPwd;

		connectDB();

		sql = "select userID, userPwd from UserInfo where userID = ?";
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String idd = rs.getString("userID");
				String pwdd = rs.getString("userPwd");

				if (idd.equals(userName) && pwdd.equals(userPwd)) {
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
	
	//Count the login number
	public void loginCount(String userID, String userPwd) {
		
		this.userID = userID;
		this.userPwd = userPwd;
		int num = 0;
		
		sql = "select userNum from UserInfo where userID = (?) and userPwd = (?)";
		System.out.println(sql);
		connectDB();
		// in UserInfo table, get UserNum;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				num = rs.getInt("userNum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed Login");
			e.printStackTrace();
		}
		
		//and if that is succeed, userCnt += 1; 
		sql = "update UserCnt set userCnt = userCnt + 1 where userNum = (?)";
		System.out.println(sql);
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
    		pstmt.executeUpdate();	// SQL문 전송
    		closeDB();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeDB();
		}
	}
	
	//Count the Saying number
		public void sayingCount(int sayingIndex) {
			
			this.sayingIndex = sayingIndex;
			
			connectDB();
			
			//and if that is succeed, userCnt += 1; 
			sql = "update SayingCnt set sayingCnt = sayingCnt + 1 where sayingNum = (?)";
			System.out.println(sql);
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (sayingIndex + 1));
	    		pstmt.executeUpdate();	// SQL문 전송
	    		closeDB();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				closeDB();
			}
		}

	// new Number
	public int SelectUserNum() {
		int result = 0;
		connectDB();

		sql = "select max(userNum) from UserInfo";
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("max(userNum)");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	
	
	


	public boolean newUser(String userID, String userPwd, String userName, String phoneNum) {

		this.userNum = SelectUserNum() + 1;
		this.userID = userID;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phoneNum = phoneNum;
		

		connectDB();

		sql = "insert into UserInfo (userNum, userID, userPwd, userName, phoneNum) values (?, ?, ?, ?, ?)";
		sql2 = "insert into UserCnt (userNum, userCnt) values (?,?)";
		System.out.println(sql);
		System.out.println(sql2);

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			pstmt.setString(2, userID);
			pstmt.setString(3, userPwd);
			pstmt.setString(4, userName);
			pstmt.setString(5, phoneNum);
			pstmt.executeUpdate(); // SQL문 전송
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, userNum);
			pstmt.setInt(2, 0);
			pstmt.executeUpdate();
			
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
		sql = "select saying from Sayinginfo";
		connectDB();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas[i] = rs.getString("saying");
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
		sql = "select SayingInfo.Saying from SayingInfo"
				+ " left join SayingCnt on SayingInfo.sayingNum = SayingCnt.sayingNum"
				+ " order by SayingCnt.sayingCnt desc"; 
	
		connectDB();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas[i] = rs.getString("saying");
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
		sql = "select UserInfo.userID from UserInfo left join UserCnt on UserInfo.userNum = UserCnt.userNum ORDER BY UserCnt.userCnt DESC";
		System.out.println(sql);
		connectDB();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas[i] = rs.getString("userID");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
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
