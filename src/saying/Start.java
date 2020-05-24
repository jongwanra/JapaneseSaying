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
