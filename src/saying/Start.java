package saying;

public class Start {
	LoginScreen loginScreen;
	MainUI mainUI;
	public static void main(String[] args) {
		// 메인클래스 실행
		Start main = new Start();  
		main.loginScreen = new LoginScreen();
	}
}
