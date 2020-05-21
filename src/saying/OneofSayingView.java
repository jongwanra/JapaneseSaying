package saying;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

//login screen
public class OneofSayingView extends JFrame {
	private Font font;
	private MainView mainUI;
	private MainController main;
	private LoginView loginScreen;
	private JButton btnBack, btnAdmin;
	private String id;
	private String pwd;
	JLabel sayingLabel;
	JLabel koreanLabel;
	
	private String[] datas;
	LineBorder btnBorder;
			
	protected JScrollPane scrollPane1;
	protected JScrollPane scrollPane2;


	public OneofSayingView(String id, String pwd, String[] datas) {
		this.id = id;
		this.pwd = pwd;
		this.datas = datas;
		// setting
		setTitle("one of sayingUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setLocation(600, 350);
		
		JPanel panel = new JPanel();
		placeMainPanel(panel);
		
		setSize(400, 600);

		// visible
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawLine(30, 283, 370, 283);
	}

	public void placeMainPanel(JPanel panel) {
		font = new Font("휴먼고딕", Font.PLAIN, 15);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 600));
		panel.setBackground(Color.white);

		JPanel sayingPanel = new JPanel();
		JPanel koreanPanel = new JPanel();
		JPanel btnPanel = new JPanel();

		Color color1 = new Color(119, 135, 194, 80);

		sayingPanel.setBackground(Color.white);
		sayingPanel.setBounds(40, 30, 320, 225);

		koreanPanel.setBackground(Color.white);
		koreanPanel.setBounds(40, 265, 320, 225);
		
		btnPanel.setBackground(Color.white);
		btnPanel.setBounds(35, 490, 330, 60);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("backBtn");
				back(id, pwd);
			}
		});
		btnBack.setPreferredSize(new Dimension(320, 50));
		btnBack.setBorderPainted(true);
		btnBorder = new LineBorder(Color.BLACK,1);
		btnBack.setBorder(btnBorder);


		btnBack.setOpaque(true);
		btnBack.setBackground(Color.WHITE);
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(font);
		btnPanel.add(btnBack);
		
		
		sayingLabel = new JLabel("<html>" + datas[0] + "</html>", SwingConstants.CENTER);
		sayingLabel.setPreferredSize(new Dimension(310, 220));
		sayingLabel.setFont(font);
		sayingLabel.setBackground(Color.YELLOW);
		sayingLabel.setVerticalAlignment(JLabel.CENTER);
		sayingLabel.setHorizontalAlignment(JLabel.LEFT);
		sayingPanel.add(sayingLabel);
		
		koreanLabel = new JLabel("<html>" + datas[1] + "</html>", SwingConstants.CENTER);
		koreanLabel.setPreferredSize(new Dimension(310, 220));
		koreanLabel.setBackground(Color.BLUE);
		koreanLabel.setFont(font);
		koreanLabel.setVerticalAlignment(JLabel.CENTER);
		koreanLabel.setHorizontalAlignment(JLabel.LEFT);
		koreanPanel.add(koreanLabel);
		
		panel.add(sayingPanel);
		panel.add(koreanPanel);
		panel.add(btnPanel);
		
		add(panel);
		
	}


	public void back(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		
		this.dispose(); // 창닫기
		this.main = new MainController(new MainView(id, pwd, 0)); // 프레임 오픈
		main.appMain();

	}

	public static void main(String[] args) {

	}

}
