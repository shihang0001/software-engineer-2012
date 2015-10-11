
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class AdminLoginGUI implements GUIConstuctor,ActionListener{
	private JFrame adminLoginFrame;
	private JButton loginButton;
	private JButton backButton;
	private JButton resetButton;
	private JTextField password;
	public void create() {
		// TODO Auto-generated method stub
		adminLoginFrame = new JFrame();
		this.constructContent();
		adminLoginFrame.setSize(800,500);
		adminLoginFrame.show();
		adminLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)adminLoginFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = adminLoginFrame.getContentPane();
		defaultPanel.setLayout(new BorderLayout());
		JPanel subPanel1 = new JPanel();
		JLabel title = new JLabel("Please type in your admin password");		
		subPanel1.add(title);
		defaultPanel.add(subPanel1, BorderLayout.NORTH);
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setBorder(BorderFactory.createEmptyBorder(20,20,50,50));
		subPanel2.setLayout(new GridLayout(1,2,0,0));
		JPanel subPanel2_1 = new JPanel();
		JPanel subPanel2_2 = new JPanel();
		subPanel2_2.setBorder(BorderFactory.createEmptyBorder(20,0,50,50));
		password = new JTextField();
		password.setPreferredSize(new Dimension(100,40));
		JLabel pinNoLabel = new JLabel("Password:");
		subPanel2_2.add(pinNoLabel);
		subPanel2_2.add(password);
		JLabel iconLabel = new JLabel();
		ImageIcon icon = new ImageIcon("download.png");
		iconLabel.setIcon(icon);
		subPanel2_1.add(iconLabel);
		subPanel2.add(subPanel2_1);
		subPanel2.add(subPanel2_2);
		defaultPanel.add(subPanel2, BorderLayout.CENTER);
		
		JPanel subPanel3 = new JPanel();
		loginButton = new JButton("Login");
		resetButton = new JButton("Reset");
		backButton = new JButton("Return");
		loginButton.setPreferredSize(new Dimension(200, 50));
		resetButton.setPreferredSize(new Dimension(200,50));
		backButton.setPreferredSize(new Dimension(200,50));
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		backButton.addActionListener(this);
		subPanel3.add(loginButton);
		subPanel3.add(resetButton);
		subPanel3.add(backButton);
		defaultPanel.add(subPanel3, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==loginButton){
			if(Parking_Control.Adminlogin(password.getText())){
				transitToGUI(0);
			}
			else{
				JOptionPane.showMessageDialog(null, "Wrong PIN",null, JOptionPane.INFORMATION_MESSAGE, null); 
			}
		}
		else if(event.getSource()==resetButton){
			password.setText(null);
		}
		else{
			returnToGUI(adminLoginFrame);
		}
		
	}

	public void transitToGUI(int i) {
		// TODO Auto-generated method stub
		adminLoginFrame.setVisible(false);
		AdminGUI admin = new AdminGUI(new Admin());
		admin.create();
	}

	public void returnToGUI(JFrame frame) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		new ParkingSystem();
		/*
		frame.setVisible(false);
		MainGUI main = new MainGUI();
		main.create();
		*/
	}

}
