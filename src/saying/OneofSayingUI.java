package saying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import saying.LoginScreen;

//login screen
public class OneofSayingUI extends JFrame {
	private MainUI mainUI;
	private Main main;
	private LoginScreen loginScreen;
	private JButton btnLogin, btnAdmin;
	private JButton btnInit;
	private String id;
	private String pwd;
	private JTextArea SayingArea;
	private JTextArea TransArea;
	private String[] datas;
			
	protected JScrollPane scrollPane1;
	protected JScrollPane scrollPane2;

	protected JToolBar toolBar = new JToolBar();
	protected JButton backBtn = new JButton("Back");

	ImageIcon i = new ImageIcon("./src/Image/Background.jpeg");
	Image im = i.getImage();

	public OneofSayingUI(String id, String pwd, String[] datas) {
		this.id = id;
		this.pwd = pwd;
		this.datas = datas;
		// setting
		setTitle("one of sayingUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setLocation(600, 350);

		backBtn.setBounds(50, 550, 30, 10);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("backBtn");
				back(id, pwd);
			}
		});
		
		MyPanel panel = new MyPanel();
		placeMainPanel(panel);
		

		setSize(400, 600);
		add(backBtn); // back button
		add(panel);

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
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(400, 600));

		JPanel SayingPanel = new JPanel();
		JPanel TransPanel = new JPanel();

		Color color1 = new Color(119, 135, 194, 80);
		Color color2 = new Color(255, 255, 255);

		SayingPanel.setBackground(color2);
		SayingPanel.setBorder(new TitledBorder(new LineBorder(color1, 5, true)));
		SayingPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		TransPanel.setBackground(color2);
		TransPanel.setBorder(new TitledBorder(new LineBorder(color1, 5, true)));
		TransPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		SayingArea = new JTextArea(datas[0]);
		SayingPanel.add(SayingArea);
		
		TransArea = new JTextArea(datas[1]);
		TransPanel.add(TransArea);
		
		
		scrollPane1 = new JScrollPane(SayingPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane1.setPreferredSize(new Dimension(300, 240));
		
		
		scrollPane2 = new JScrollPane(TransPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setPreferredSize(new Dimension(300, 240));
		
		panel.add(scrollPane1);
		panel.add(scrollPane2);

		
	}

	public void back(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		
		this.dispose(); // 창닫기
		this.main = new Main(new MainUI(id, pwd, 0)); // 프레임 오픈
		main.appMain();

	}

	public static void main(String[] args) {

	}

}
