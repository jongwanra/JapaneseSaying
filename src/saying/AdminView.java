package saying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AdminView extends JFrame {
	SayingDAO dao;
	LoginView loginScreen;
	String id;
	String pwd;
	JScrollPane sayingScroll;
	JScrollPane koreanScroll;
	
	JTextArea sayingArea;
	JTextArea koreanArea;
	

	JButton addBtn;
	JButton backBtn;

	ImageIcon i = new ImageIcon("./src/Image/Background.jpeg");
	Image im = i.getImage();

	public AdminView(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;

		System.out.println(id + "!!!!");
		System.out.println(pwd + "!!!!");

		setTitle("Japanese Saying");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(null);

		setResizable(false);
		setLocation(600, 350);

		// MyPanel panel = new MyPanel();
		MyPanel panel = new MyPanel();
		placeMainPanel(panel);
		
		
		addBtn = new JButton("add");
		addBtn.setBounds(50, 500, 50, 50);
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dao = new SayingDAO();
				
				String sayingTxt = sayingArea.getText();
				String koreanTxt = koreanArea.getText();
				
				
				if(dao.newSaying(sayingTxt, koreanTxt)) {
					System.out.println("addSaying Success!");
					sayingArea.setText("");
					koreanArea.setText("");
					
				}else {
					System.out.println("addSaying error!");
				}
			}
		});
		
		backBtn = new JButton("back");
		backBtn.setBounds(120, 500, 50, 50);
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		
		add(backBtn);
		add(addBtn);
		add(panel);

		// add(panel);
		setSize(400, 600);

		// visible
		setVisible(true);

	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);

		}

	}

	public void placeMainPanel(JPanel panel) {
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(400, 600));

		JPanel sayingPanel = new JPanel();
		JPanel koreanPanel = new JPanel();
		Color color2 = new Color(255, 255, 255);

		sayingPanel.setBackground(color2);
		sayingPanel.setBorder(new TitledBorder(new LineBorder(color2, 5, false)));
		sayingPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		koreanPanel.setBackground(color2);
		koreanPanel.setBorder(new TitledBorder(new LineBorder(color2, 5, false)));
		koreanPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		panel.add(sayingPanel);
		panel.add(koreanPanel);

		
		sayingArea = new JTextArea(10, 10);
		sayingArea.setText("Please Write Saying");
		sayingScroll = new JScrollPane(sayingArea);
		sayingPanel.add(sayingArea);
		

		koreanArea = new JTextArea(10, 10);
		koreanArea.setText("Please Write Korean");
		koreanScroll = new JScrollPane(koreanArea);
		koreanPanel.add(koreanArea);
		
		sayingScroll = new JScrollPane(sayingPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		sayingScroll.setPreferredSize(new Dimension(300, 240));
		
		
		koreanScroll = new JScrollPane(koreanPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		koreanScroll.setPreferredSize(new Dimension(300, 240));
		
		panel.add(sayingScroll);
		panel.add(koreanScroll);

	}
	
	public void back() {
		this.dispose();
		this.loginScreen = new LoginView();
	}

	public static void main(String[] args) {

	}

}
