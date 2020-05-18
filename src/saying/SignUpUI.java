package saying;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import saying.SignUp;

public class SignUpUI extends JFrame {
	protected SignUp signUp;
	protected JTextField txtUsername;
	protected JPasswordField txtPassword;
	protected JPasswordField txtConfirmPassword;
	protected JTextField txtName;
	protected JTextField txtPhoneNum;
	protected JButton btnSave;
	protected JLabel hRegister;
	protected JLabel hUsername;
	protected JLabel hPassword;
	protected JLabel hConfirmPassword;
	protected JLabel hName;
	protected JLabel hPhoneNum;
	protected int saying_cnt = 50;
	protected int userNum = 0;

	ImageIcon i = new ImageIcon("./src/Image/MainBackground.png");
	Image im = i.getImage();

	public SignUpUI() {
		// setting
		setTitle("SignUp Screen");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setLocation(600, 350);
		setSize(400, 600);

		// panel
		MyPanel panel = new MyPanel();
		placeMainPanel(panel);

		// visible
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);

		}
	}

	public void placeMainPanel(MyPanel panel) {
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 600));
		add(panel);

		// Header Title
		hRegister = new JLabel("Register Data");
		hRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		hRegister.setBounds(121, 11, 132, 20);
		panel.add(hRegister);

		// *** Header ***//
		hUsername = new JLabel("Username :");
		hUsername.setBounds(78, 52, 89, 14);
		panel.add(hUsername);

		hPassword = new JLabel("Password :");
		hPassword.setBounds(78, 84, 89, 14);
		panel.add(hPassword);

		hConfirmPassword = new JLabel("Confirm Password :");
		hConfirmPassword.setBounds(77, 113, 130, 14);
		panel.add(hConfirmPassword);

		hName = new JLabel("Name :");
		hName.setBounds(78, 148, 89, 14);
		panel.add(hName);

		hPhoneNum = new JLabel("Phone_Number :");
		hPhoneNum.setBounds(80, 176, 89, 14);
		panel.add(hPhoneNum);

		// CustomerID
		txtUsername = new JTextField("");
		txtUsername.setBounds(217, 47, 99, 20);
		panel.add(txtUsername);
		// Password
		txtPassword = new JPasswordField();
		txtPassword.setBounds(217, 77, 102, 20);
		panel.add(txtPassword);

		// Confirm Password
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(217, 112, 102, 20);
		panel.add(txtConfirmPassword);

		// Name
		txtName = new JTextField("");
		txtName.setBounds(217, 140, 176, 20);
		panel.add(txtName);

		// Phone Number
		txtPhoneNum = new JTextField("");
		txtPhoneNum.setBounds(217, 172, 176, 20);
		panel.add(txtPhoneNum);

		// Save Button
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Success Data Send");
				if (RegisterData()) {
					JOptionPane.showMessageDialog(null, "Register Data Successfully");

				}

			}
		});
		btnSave.setBounds(161, 227, 89, 23);
		panel.add(btnSave);
	}

	// SignUp Check Function!
	public boolean RegisterData() {
		String userName = txtUsername.getText();
		String password = new String(txtPassword.getPassword());
		String confirmPassword = new String(txtConfirmPassword.getPassword());
		String name = txtName.getText();
		String phoneNum = txtPhoneNum.getText();
		boolean status = false;

		// Username
		if (userName.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Username)");
			txtUsername.requestFocusInWindow();
			return false;
		}
		// Password
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Password)");
			txtPassword.requestFocusInWindow();
			return false;
		}
		// Confirm Password
		if (confirmPassword.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Confirm Password)");
			txtConfirmPassword.requestFocusInWindow();
			return false;
		}
		// Password math
		if (!password.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(null, "Please Input (Password Not Match!)");
			txtPassword.requestFocusInWindow();
			return false;
		}
		// Name
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (Name)");
			txtName.requestFocusInWindow();
			return false;
		}
		// Phone Number
		if (phoneNum.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Input (PhoneNumber)");
			hPhoneNum.requestFocusInWindow();
			return false;
		}

		try {

			signUp = new SignUp();
			if (signUp.newUser(userName, password, phoneNum))
				System.out.println("Register Success");
			else
				System.out.println("Register fail!");
			
			// Reset Text Fields
			txtUsername.setText("");
			txtPassword.setText("");
			txtConfirmPassword.setText("");
			txtName.setText("");
			txtPhoneNum.setText("");

			status = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		return status;

	}
}