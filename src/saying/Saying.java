package saying;

public class Saying {

	private int userNum;
	private String userName;
	private String password;
	private String phoneNum;
	private int SayingNum;
	private String Saying;
	private String Korean;
	private int SayingCnt;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	
}