package saying;

import saying.Start;
import saying.LoginScreen;
import saying.MainUI;

public class Start {
	LoginScreen loginScreen;
	MainUI mainUI;
	public static void main(String[] args) {
		// 메인클래스 실행
		Start main = new Start();
		main.mainUI = new MainUI();
	}
}