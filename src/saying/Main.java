package saying;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class Main implements Runnable {
	private final MainUI mainUI;
	private LoginScreen loginScreen;
	private OneofSayingUI oneofSayingUI;
	private String ip = "127.0.0.1";
	private Socket socket;
	private BufferedReader inMsg = null;
	private PrintWriter outMsg = null;
	private String id;
	private String pwd;

	Logger logger;
	boolean status;
	Thread thread;

	public Main(MainUI mainUI) {
		//logger = Logger.getLogger(this.getClass().getName());
		this.mainUI = mainUI;
	}

	public void refresh() {

	}

	public void appMain() {
//		connectServer();
//		refresh();

		// if press the SayingBtn, add Event
		mainUI.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				for (int i = 0; i < mainUI.saying_cnt; i++) {
					if (obj == mainUI.btn[i]) {
						System.out.println("EnterSaying!!");
						EnterSaying(mainUI.id, mainUI.pwd);
					}
				}
			}

		});
		//refresh();
	}

	public void EnterSaying(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		
		mainUI.dispose(); // close
		this.oneofSayingUI = new OneofSayingUI(id, pwd); // 프레임 오픈
	}

	public void connectServer() {
		try {
			socket = new Socket(ip, 8888);
			// logger.log(INFO, "Client Server Connect Success");

		} catch (Exception e) {
			// logger.log(WARNING, "Main connectServer() Exception Error!");
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

	}

	public static void main(String[] args) {

	}

}
