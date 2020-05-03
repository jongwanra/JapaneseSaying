package saying;

import saying.MainStart;
import saying.LoginScreen;

public class MainStart {
	LoginScreen loginScreen;
	public static void main(String[] args) {
		// 메인클래스 실행
		MainStart main = new MainStart();
		main.loginScreen = new LoginScreen();
	}
}
