package saying;

public class SayingModel {

	//UserInfo
	private int userNum;
	private String userID;
	private String userPwd;
	private String userName;
	private String phoneNum;
	
	//SayingInfo
	private int SayingNum;
	private String Saying;
	private String Korean;
	
	//SayingCnt
	private int SayingCnt;
	
	//UserCnt
	private int UserCnt;
	
	//UserRanking
	private int userRanking;
	
	//SayingRanking
	private int sayingRanking;
	
	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserpwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhonNum(String phoneNum) {
		this.phoneNum = phoneNum; 
	}

	public int getSayingNum() {
		return SayingNum;
	}
	
	public void setSayingNum(int SayingNum) {
		this.SayingNum = SayingNum;
	}
	
	public String getSaying() {
		return Saying;
	}
	
	public void setSaying(String Saying) {
		this.Saying = Saying;
	}

	public String getKorean() {
		return Korean;
	}
	
	public void setKorean(String Korean) {
		this.Korean = Korean;
	}

	public int getSayingCnt() {
		return SayingCnt;
	}
	public void setSayingCnt(int SayingCnt) {
		this.SayingCnt = SayingCnt;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getUserCnt() {
		return UserCnt;
	}

	public void setUserCnt(int userCnt) {
		UserCnt = userCnt;
	}

	public int getUserRanking() {
		return userRanking;
	}

	public void setUserRanking(int userRanking) {
		this.userRanking = userRanking;
	}

	public int getSayingRanking() {
		return sayingRanking;
	}

	public void setSayingRanking(int sayingRanking) {
		this.sayingRanking = sayingRanking;
	}


	
}