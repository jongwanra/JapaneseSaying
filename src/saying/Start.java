package saying;

public class Start {
	LoginController loginController;
	
	public static void main(String[] args) {
		//LoginView execute
		Start start = new Start();  
		start.loginController = new LoginController(new LoginView()); // Open Frame
		start.loginController.appMain();
		
	}
}

//ぐうぜんじゃない うんめいのなかで きみのきせきをしんじてる 
// 우연이 아닌 운명 속에서 당신의 기적을 믿고 있어