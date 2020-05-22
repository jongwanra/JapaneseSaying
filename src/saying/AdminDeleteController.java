package saying;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDeleteController {
	private AdminDeleteView view;
	private AdminDeleteController controller;
	private AdminCreateController createController;
	
	private SayingModel model;
	private SayingDAO dao;
	private LoginController loginController;

	protected String sayingTxt;
	protected String koreanTxt;
	protected String id;
	protected String pwd;
	protected int flag;

	public AdminDeleteController(AdminDeleteView view) {
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
		createController = new AdminCreateController(new AdminCreateView(id, pwd));
		createController.appMain();

	}

	protected void deleteMethod(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		
	}

	protected void readMethod(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;

	}

	protected void updateMethod(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;

	}

	protected void back() {
		view.dispose();
		loginController = new LoginController(new LoginView());
		loginController.appMain();
	}
}
