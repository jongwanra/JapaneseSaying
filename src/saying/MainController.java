package saying;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import javax.swing.JButton;

public class MainController {
	private final MainView mainUI;
	private MainController main;
	private SayingDAO dao;

	private LoginView loginScreen;
	private OneofSayingView oneofSayingUI;

	private String id;
	private String pwd;
	private int index;
	private String[] datas;
	private int saying_cnt;
	private int flag;

	Logger logger;
	boolean status;
	Thread thread;

	public MainController(MainView mainUI) {
		// logger = Logger.getLogger(this.getClass().getName());
		this.mainUI = mainUI;
	}

	public void refresh() {

	}

	public void appMain() {

		// if press the SayingBtn, add Event
		mainUI.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 0;
				Object obj = e.getSource();
				
				 if (obj == mainUI.registerOrder) {
					System.out.println("registerOrder!!");
					registerOrder(mainUI.id, mainUI.pwd, index);
					flag = 0;
				}else if (obj == mainUI.inquiryOrder) {
					System.out.println("inquiryOrder!!");
					inquiryOrder(mainUI.id, mainUI.pwd);
					flag = 1;
				}else if (obj == mainUI.userRankingOrder) {
					System.out.println("user Ranking Order!!");
					userRankingOrder(mainUI.id, mainUI.pwd);
					flag = 2;
				}
				for (int i = 0; i < mainUI.saying_cnt; i++) {
					if (obj == mainUI.btn[i]) {
						System.out.println("EnterSaying!!");
						EnterSaying(mainUI.id, mainUI.pwd, i, flag);
					}
				}
				
			}

		});

	}

	public void EnterSaying(String id, String pwd, int index, int flag) {

		this.id = id;
		this.pwd = pwd;
		this.index = index;
		this.flag = flag;

		dao = new SayingDAO();
		datas = dao.getOneofSaying(index, flag);

		// close
		mainUI.dispose(); 
		this.oneofSayingUI = new OneofSayingView(id, pwd, datas); // 프레임 오픈

	}

	public void registerOrder(String id, String pwd, int saying_cnt) {
		
		this.id = id;
		this.pwd = pwd;
	
		mainUI.dispose();
		main = new MainController(new MainView(id, pwd, 0)); // 프레임 오픈
		main.appMain();
	}

	public void inquiryOrder(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;

		mainUI.dispose();
		main = new MainController(new MainView(id, pwd, 1));
		main.appMain();
	}

	public void userRankingOrder(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;

		mainUI.dispose();
		main = new MainController(new MainView(id, pwd, 2));
		main.appMain();
	}

	public static void main(String[] args) {

	}

}
