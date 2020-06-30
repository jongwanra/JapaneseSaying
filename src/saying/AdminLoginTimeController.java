package saying;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AdminLoginTimeController {
	private AdminLoginTimeView view;
	private AdminLoginTimeController controller;
	private AdminCreateController createController;
	private AdminDeleteController deleteController;
	
	private SayingModel model;
	private SayingDAO dao;
	private LoginController loginController;

	
	protected String sayingTxt;
	protected String koreanTxt;
	protected String id;
	protected String pwd;
	protected int flag;

	public AdminLoginTimeController(AdminLoginTimeView view) {
		this.view = view;
	}

	public void appMain() {

		// if press the SayingBtn, add Event
		view.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				for(int i = 0; i < view.userCnt; i++) {
					if(obj == view.userBtn[i]) {
						userDelete(i);
					}
				}
				for(int i = 0; i < view.sayingCnt; i++) {
					if(obj == view.sayingBtn[i])
						sayingDelete(i);
				}
				if (obj == view.backBtn) {
					System.out.println("BackBtn!!");
					back();
				} else if (obj == view.createBtn) {
					System.out.println("createBtn");
					createMethod(view.id, view.pwd);
				} else if (obj == view.loginTimeBtn) {
					System.out.println("loginTimeBtn");
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
	
	//delete saying?
	protected void sayingDelete(int index) {
		int result = JOptionPane.showConfirmDialog(null, "<html><p>Are you Sure?</p><p>Delete SayingNum: "
				 + (index + 1) + "?</p></html>" ,"Confirm", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			//Yes
			System.out.println("yes!!");
			dao = new SayingDAO();
			if(dao.deleteSaying(index + 1)) {
				System.out.println("success!!");
				refresh();
			}else {
				System.out.println("fail!!");
			}
		}else {
			//No
			System.out.println("no!!");
		}
		
	}

	private void refresh() {
		view.dispose();
		controller = new AdminLoginTimeController(new AdminLoginTimeView(id, pwd));
		controller.appMain();
	}

	//delete user?
	protected void userDelete(int index) {
		int result = JOptionPane.showConfirmDialog(null, "<html><p>Are you Sure?</p><p>Delete UserNum: "
				 + (index + 1) + "?</p></html>" ,"Confirm", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			//Yes
			System.out.println("yes!!");
			dao = new SayingDAO();
			if(dao.deleteUser(index + 1)) {
				System.out.println("success!!");
				refresh();
			}else {
				System.out.println("fail!!");
			}
		}else {
			//No
			System.out.println("no!!");
		}
		
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
		
		view.dispose();
		deleteController = new AdminDeleteController(new AdminDeleteView(id, pwd));
		deleteController.appMain();
		
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
