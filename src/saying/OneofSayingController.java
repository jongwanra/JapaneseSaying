package saying;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import saying.OneofSayingView;
import saying.MainView;

public class OneofSayingController {
	private SayingDAO dao;
	
	private OneofSayingView view;
	private MainController mainController;
	protected String id;
	protected String pwd;
	protected String[] datas;
	
	public OneofSayingController(OneofSayingView view) {	
		this.view = view;
	}
	
	public void appMain() {
		view.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				if (obj == view.btnBack) {
					System.out.println("btnBack!!");
					back(view.id, view.pwd);
				}
			}
		});
		
	}
	

	protected void back(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		dao = new SayingDAO();
		datas = new String[50];
		datas = dao.getSayingRegister();
		
		
		view.dispose(); // 창닫기
		this.mainController = new MainController(new MainView(id, pwd, 0, datas)); // 프레임 오픈
		this.mainController.appMain();

	}

	public static void main(String[] args) {

	}
}
