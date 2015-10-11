import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * TIME APR 25TH
 * GUI USED FOR DEPOSIT FUNCTION
 */
public class DepositGUI implements ActionListener,ItemListener,GUIConstructor {
	//GUI Content Declaration
	private JFrame depositFrame;
	private JButton confirmButton;
	private JButton backButton;
	private JTextField depositMoney;
	JCheckBox cashButton;
	JCheckBox checkButton;
	String pinNo, accountNumber = new String();
	boolean isCheck;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		depositFrame = new JFrame();
		this.constructContent();
		depositFrame.setSize(800,500);
		depositFrame.show();
		depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)depositFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = depositFrame.getContentPane();
		defaultPanel.setLayout(new BorderLayout());
		JPanel subPanel1 = new JPanel();
		JLabel depositNum = new JLabel("Number:");
		depositMoney = new JTextField();
		depositMoney.setPreferredSize(new Dimension(250, 30));
		subPanel1.add(depositNum);
		subPanel1.add(depositMoney);
		defaultPanel.add(subPanel1,BorderLayout.NORTH);
		JPanel subPanel2 = new JPanel();
		cashButton = new JCheckBox("Cash");
		checkButton = new JCheckBox("Check");
		cashButton.setPreferredSize(new Dimension(100,40));
		checkButton.setPreferredSize(new Dimension(100,40));
		cashButton.addItemListener(this);
		checkButton.addItemListener(this);
		cashButton.setSelected(true);
		subPanel2.add(cashButton);
		subPanel2.add(checkButton);
		subPanel2.setBorder(BorderFactory.createEmptyBorder(100,150,50,50));
		defaultPanel.add(subPanel2);
		JPanel subPanel3 = new JPanel();
		confirmButton = new JButton("Confirm");
		backButton = new JButton("Back");
		confirmButton.addActionListener(this);
		backButton.addActionListener(this);
		confirmButton.setPreferredSize(new Dimension(200,40));
		backButton.setPreferredSize(new Dimension(200,40));
		subPanel3.add(confirmButton);
		subPanel3.add(backButton);
		defaultPanel.add(subPanel3,BorderLayout.SOUTH);
	}

	@Override
	public void transitToGUI(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void returnToGUI(JFrame frame) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		CustomerGUI customer = new CustomerGUI();
		customer.pinNumber = this.pinNo;
		customer.accountNumber = this.accountNumber;
		customer.create();	

	}

	@Override
	//handle the button event
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==confirmButton){
			if(depositMoney.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "You don't input any number!",null, JOptionPane.WARNING_MESSAGE, null); 
			}
			else{
				BankControlSystem control = new BankControlSystem();
				Account loadAccount = new Account();
				loadAccount = control.loadAccountFromFile(accountNumber,pinNo);
				if(!loadAccount.isSuspend){
					if(isCheck){
						System.out.println("Check");
						control.deposit(loadAccount, Integer.parseInt(depositMoney.getText()), "check");
					}
					else{
						System.out.println("Cash");
						control.deposit(loadAccount, Integer.parseInt(depositMoney.getText()), "cash");
					}
					JOptionPane.showMessageDialog(null, "Successful!",null, JOptionPane.INFORMATION_MESSAGE, null); 
				}
				else
					JOptionPane.showMessageDialog(null, "Your account has been suspended!",null, JOptionPane.WARNING_MESSAGE, null); 
			}
		}
		else {
			returnToGUI(depositFrame);
		}			
	}
	
	//handle the check button event so that 2 buttons cannot be checked at the same time
	public void itemStateChanged(ItemEvent event) {
	       if(event.getSource()==cashButton){
	    	   checkButton.setSelected(false);
	    	   isCheck = false;
	       }
	       else{
	    	   cashButton.setSelected(false);
	       	   isCheck = true;
	       }
	    }

}
