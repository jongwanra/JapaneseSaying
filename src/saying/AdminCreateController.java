package saying;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminCreateController {
	private AdminCreateView view;
	private AdminCreateController controller;
	private AdminDeleteController deleteController;
	private SayingModel model;
	private SayingDAO dao;
	private LoginController loginController;

	protected String sayingTxt;
	protected String koreanTxt;
	protected String id;
	protected String pwd;
	protected int flag;

	public AdminCreateController(AdminCreateView view) {
		this.view = view;
	}

	public void appMain() {

		// if press the SayingBtn, add Event
		view.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();

				if (obj == view.backBtn) {
					System.out.println("BackBtn!!");
					back();
				} else if (obj == view.addBtn) {
					System.out.println("addBtn");
					addSaying(view.sayingArea.getText(), view.koreanArea.getText());
				} else if (obj == view.createBtn) {
					System.out.println("createBtn");
					createMethod(view.id, view.pwd);
				} else if (obj == view.readBtn) {
					System.out.println("readBtn");
					readMethod(view.id, view.pwd);
				} else if (obj == view.updateBtn) {
					System.out.println("updateBtn");
					updateMethod(view.id, view.pwd);
				} else if (obj == view.deleteBtn) {
					System.out.println("deleteBtn");
					deleteMethod(view.id, view.pwd);
				}

			}

		});

	}

	protected void createMethod(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;

		view.dispose();
		controller = new AdminCreateController(new AdminCreateView(id, pwd));
		controller.appMain();

	}

	protected void deleteMethod(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		
		view.dispose();
		deleteController = new AdminDeleteController(new AdminDeleteView(id, pwd));
		deleteController.appMain();
	}

	protected void readMethod(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		System.out.println("readMethod!!!");
	}

	protected void updateMethod(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		System.out.println("updateMethod!!!");
		

	}

	protected void addSaying(String sayingTxt, String koreanTxt) {
		System.out.println("addSaying!!!");
		dao = new SayingDAO();
		this.sayingTxt = sayingTxt;
		this.koreanTxt = koreanTxt;

		if (dao.newSaying(sayingTxt, koreanTxt)) {
			System.out.println("addSaying Success!");
			view.sayingArea.setText("");
			view.koreanArea.setText("");

		} else
			System.out.println("addSaying error!");

	}

	protected void back() {
		view.dispose();
		loginController = new LoginController(new LoginView());
		loginController.appMain();
	}
}
