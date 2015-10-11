import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * TIME APR 25TH
 * GUI USED FOR STAFF TO LOGIN
 */
public class StaffLoginGUI implements ActionListener, GUIConstructor {
	//GUI Content Declaration
	private JFrame staffLoginFrame;
	private JButton loginButton;
	private JButton backButton;
	private JButton resetButton;
	private JTextField account;
	private JTextField password;
	

	@Override
	public void create() {
		// TODO Auto-generated method stub
		staffLoginFrame = new JFrame();
		this.constructContent();
		staffLoginFrame.setSize(800,500);
		staffLoginFrame.show();
		staffLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)staffLoginFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = staffLoginFrame.getContentPane();
		defaultPanel.setLayout(new BorderLayout());
		JPanel subPanel1 = new JPanel();
		JLabel title = new JLabel("Please type in your account and password");		
		subPanel1.add(title);
		defaultPanel.add(subPanel1, BorderLayout.NORTH);
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
		subPanel2.setLayout(new GridLayout(2,1,0,0));
		JPanel subPanel2_1 = new JPanel();
		subPanel2_1.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
		JPanel subPanel2_2 = new JPanel();
		subPanel2_2.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
		account = new JTextField();
		account.setPreferredSize(new Dimension(100,40));
		password = new JTextField();
		password.setPreferredSize(new Dimension(100,40));
		JLabel accNoLabel = new JLabel("Account:  ");
		JLabel pinNoLabel = new JLabel("Password:");
		subPanel2_1.add(accNoLabel);
		subPanel2_1.add(account);
		subPanel2_2.add(pinNoLabel);
		subPanel2_2.add(password);
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
			if(account.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Your account cannot be empty",null, JOptionPane.WARNING_MESSAGE); 
			}
			else if(password.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Your password cannot be empty",null, JOptionPane.WARNING_MESSAGE); 	
			}
			else{
				BankControlSystem control = new BankControlSystem();
				if(control.loginCheckForAdmin(account.getText(), password.getText())){
					transitToGUI(0);
				}
				else
					JOptionPane.showMessageDialog(null, "Your account or password is wrong",null, JOptionPane.WARNING_MESSAGE); 
			}
		}
		else if(event.getSource()==resetButton){
			account.setText(null);
			password.setText(null);
		}
		else{
			returnToGUI(staffLoginFrame);
		}
		
	}

	@Override
	public void transitToGUI(int i) {
		// TODO Auto-generated method stub
		staffLoginFrame.setVisible(false);
		StaffGUI staff = new StaffGUI();
		staff.create();
	}

	@Override
	public void returnToGUI(JFrame frame) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		MainGUI main = new MainGUI();
		main.create();
	}

}
