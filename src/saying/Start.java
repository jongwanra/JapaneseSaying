package saying;

public class Start {
	LoginView loginScreen;
	MainView mainUI;
	public static void main(String[] args) {
		// 메인클래스 실행
		Start main = new Start();  
		main.loginScreen = new LoginView();
	}
}
