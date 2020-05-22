package saying;

public class Start {
	LoginView loginView;
	LoginController loginController;
	MainView mainUI;
	public static void main(String[] args) {
		// 메인클래스 실행
		Start start = new Start();  
		
		start.loginController = new LoginController(new LoginView()); // 프레임 오픈
		start.loginController.appMain();
	}
}
