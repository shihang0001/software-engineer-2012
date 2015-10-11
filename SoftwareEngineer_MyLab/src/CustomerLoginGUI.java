import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/*
 * TIME APR 25TH
 * GUI USED FOR Customer to input their account number and pin
 */
public class CustomerLoginGUI implements ActionListener,GUIConstructor {
	//GUI Content Declaration
	private JFrame customerLoginFrame;
	private JButton loginButton, backButton,resetButton;
	JTextField accNo,PIN;
	boolean isCheck;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		customerLoginFrame = new JFrame();
		this.constructContent();
		customerLoginFrame.setSize(800,500);
		customerLoginFrame.show();
		customerLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
				((JPanel)customerLoginFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
				Container defaultPanel = customerLoginFrame.getContentPane();
				defaultPanel.setLayout(new BorderLayout());
				JPanel subPanel1 = new JPanel();
				JLabel title = new JLabel("Please Input your account number and its corresponding PIN");		
				JLabel iconLabel=new JLabel();
				subPanel1.add(title);
				defaultPanel.add(subPanel1, BorderLayout.NORTH);
				
				JPanel subPanel2 = new JPanel();
				subPanel2.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
				subPanel2.setLayout(new GridLayout(2,1,0,0));
				JPanel subPanel2_1 = new JPanel();
				subPanel2_1.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
				JPanel subPanel2_2 = new JPanel();
				subPanel2_2.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
				accNo = new JTextField();
				accNo.setPreferredSize(new Dimension(100,40));
				PIN = new JTextField();
				PIN.setPreferredSize(new Dimension(100,40));
				JLabel accNoLabel = new JLabel("Account Number:");
				JLabel pinNoLabel = new JLabel("PIN Number:     ");
				subPanel2_1.add(accNoLabel);
				subPanel2_1.add(accNo);
				subPanel2_2.add(pinNoLabel);
				subPanel2_2.add(PIN);
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
	public void transitToGUI(int i) {
		// TODO Auto-generated method stub
		customerLoginFrame.setVisible(false);
		CustomerGUI customer = new CustomerGUI();
		customer.pinNumber = this.PIN.getText();
		customer.accountNumber = this.accNo.getText();
		customer.create();
	}

	@Override
	public void returnToGUI(JFrame frame) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		MainGUI main = new MainGUI();
		main.create();
	}

	@Override
	//handle the event
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(event.getSource()==loginButton){
			BankControlSystem control = new BankControlSystem();
			if(control.customerLoginCheck(accNo.getText(), PIN.getText())==0){
				transitToGUI(0);
			}
			else if(control.customerLoginCheck(accNo.getText(), PIN.getText())==1){
				System.out.println("Not Match!");
			}
			else if(control.customerLoginCheck(accNo.getText(), PIN.getText())==2){
				System.out.println("The account does not exist");
			}
		}
		else if(event.getSource()==resetButton){
			accNo.setText(null);
			PIN.setText(null);
		}
		else{
			returnToGUI(customerLoginFrame);
		}
	}
}
