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
	private LoginView loginView;
	
	JButton btnBack;
	String id;
	String pwd;
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
		setLocation(600, 100);
		
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

		sayingPanel.setBackground(Color.white);
		sayingPanel.setBounds(40, 30, 320, 225);

		koreanPanel.setBackground(Color.white);
		koreanPanel.setBounds(40, 265, 320, 225);
		
		btnPanel.setBackground(Color.white);
		btnPanel.setBounds(35, 490, 330, 60);
		
		
		btnBack = new JButton("Back");
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
		koreanLabel = new JLabel("<html>" + datas[1] + "</html>", SwingConstants.CENTER);
		
		labelDesign(sayingLabel, sayingPanel);
		labelDesign(koreanLabel, koreanPanel);
		
		panel.add(sayingPanel);
		panel.add(koreanPanel);
		panel.add(btnPanel);
		
		add(panel);
		
	}


	private void labelDesign(JLabel label, JPanel panel) {
		label.setPreferredSize(new Dimension(310, 220));
		label.setFont(font);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.LEFT);
		panel.add(label);

	}
	
	// Register Event Listener
	public void addButtonActionListener(ActionListener listener) {
        
		btnBack.addActionListener(listener);
    }



	public static void main(String[] args) {

	}

}
