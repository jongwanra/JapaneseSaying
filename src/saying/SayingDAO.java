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
	String userName;
	String password;
	String phoneNum;

	
	
	 public void connectDB() {
    	try {
    		Class.forName(jdbcDriver); // JDBC 드라이버 로드
    		
    		conn = DriverManager.getConnection(jdbcUrl, id, pwd); // DB연결
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    
    public boolean newSaying(Saying saying) {
		connectDB();
		sql = "insert into SayingInfo (SayingNum, Saying, Korean, SayingCnt) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, saying.getSayingNum());
			pstmt.setString(2, saying.getSaying());
			pstmt.setString(3, saying.getKorean());
			pstmt.setInt(4, saying.getSayingCnt());
    		pstmt.executeUpdate();	// SQL문 전송
    		
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
    		pstmt.executeUpdate();	// SQL문 전송
    		return true;
    	} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public int[] refreshSaying() {
    	int[] stat = new int[50];
    	int i=0;
    	
    	connectDB();
		sql = "select * from Sayinginfo";
		try {
			pstmt = conn.prepareStatement(sql);
    		rs = pstmt.executeQuery();
			while(rs.next()) {
				stat[i++]=rs.getInt("status");
			}
    		return stat;
    	} catch (Exception e) {
			e.printStackTrace();
			return stat;
		}
    }
   
}
