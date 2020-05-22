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
	private final MainView view;
	private MainController main;
	private SayingDAO dao;

	private LoginController loginController;
	private OneofSayingController oneofSayingController;

	private String id;
	private String pwd;
	private int index;
	private String[] datas;
	private int saying_cnt;
	private int flag = 0;

	boolean status;

	public MainController(MainView view) {
		this.view = view;
	}

	public void appMain() {

		// if press the SayingBtn, add Event
		view.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();

				if (obj == view.registerOrder) {
					System.out.println("registerOrder!!");
					registerOrder(view.id, view.pwd, index);
					flag = 0;
				} else if (obj == view.inquiryOrder) {
					System.out.println("inquiryOrder!!");
					inquiryOrder(view.id, view.pwd);
					flag = 1;
				} else if (obj == view.userRankingOrder) {
					System.out.println("user Ranking Order!!");
					userRankingOrder(view.id, view.pwd);
					flag = 2;
				} else if (obj == view.backBtn) {
					System.out.println("BackBtn!!");
					back();
				}
				for (int i = 0; i < view.saying_cnt; i++) {
					if (obj == view.btn[i]) {
						System.out.println("EnterSaying!!");
						EnterSaying(view.id, view.pwd, i, flag);
					}
				}

			}

		});

	}

	protected void back() {
		// TODO Auto-generated method stub
		view.dispose(); // 창닫기
		this.loginController = new LoginController(new LoginView());
		this.loginController.appMain();
	}

	public void EnterSaying(String id, String pwd, int index, int flag) {

		this.id = id;
		this.pwd = pwd;
		this.index = index;
		this.flag = flag;

		dao = new SayingDAO();
		datas = dao.getOneofSaying(index, flag);
		dao.sayingCount(index); //접속하면, 해당 sayingCnt가 1추가 
		
		// close
		view.dispose();
		this.oneofSayingController = new OneofSayingController(new OneofSayingView(id, pwd, datas)); // 프레임 오픈
		this.oneofSayingController.appMain();
	}
	
	public void registerOrder(String id, String pwd, int saying_cnt) {

		dao = new SayingDAO();
		datas = new String[50];
		
		datas = dao.getSayingRegister();
		
		this.id = id;
		this.pwd = pwd;

		view.dispose();
		main = new MainController(new MainView(id, pwd, 0, datas)); // 프레임 오픈
		main.appMain();
	}

	public void inquiryOrder(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		
		dao = new SayingDAO();
		datas = new String[50];
		datas = dao.getSayingInquiry();
		view.dispose();
		main = new MainController(new MainView(id, pwd, 1, datas));
		main.appMain();
	}

	public void userRankingOrder(String id, String pwd) {
		
		dao = new SayingDAO();
		datas = new String[50];
		datas = dao.getUserRanking();
		
		this.id = id;
		this.pwd = pwd;
		
		view.dispose();
		main = new MainController(new MainView(id, pwd, 2, datas));
		main.appMain();
	}

	public static void main(String[] args) {

	}

}
