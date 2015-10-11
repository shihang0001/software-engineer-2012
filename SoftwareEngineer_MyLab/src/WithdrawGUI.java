import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * TIME APR 25TH
 * GUI USED FOR WITHDRAW FUNCTION
 */
public class WithdrawGUI implements ActionListener,GUIConstructor {
	//GUI Content Declarationþ
	private JFrame withdrawFrame;
	private JButton confirmButton;
	private JButton backButton;
	private JTextField withdrawMoney;
	String accNo, pinNo = new String();
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		withdrawFrame = new JFrame();
		this.constructContent();
		withdrawFrame.setSize(800,500);
		withdrawFrame.show();
		withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)withdrawFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = withdrawFrame.getContentPane();
		defaultPanel.setLayout(new BorderLayout());
		JPanel subPanel1 = new JPanel();
		JLabel money = new JLabel("Number:");
		subPanel1.add(money);
		defaultPanel.add(subPanel1, BorderLayout.NORTH);
		JPanel subPanel2 = new JPanel();
		subPanel2.setBorder(BorderFactory.createEmptyBorder(80,50,50,50));
		withdrawMoney = new JTextField();
		withdrawMoney.setPreferredSize(new Dimension(350, 50));
		subPanel2.add(withdrawMoney);
		defaultPanel.add(subPanel2, BorderLayout.CENTER);
		JPanel subPanel3 = new JPanel();
		confirmButton = new JButton("Confirm");
		backButton = new JButton("Back");
		confirmButton.setPreferredSize(new Dimension(200, 50));
		backButton.setPreferredSize(new Dimension(200,50));
		confirmButton.addActionListener(this);
		backButton.addActionListener(this);
		subPanel3.add(confirmButton);
		subPanel3.add(backButton);
		defaultPanel.add(subPanel3, BorderLayout.SOUTH);
		//moneyNum.
	}

	@Override
	//handle the event
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==confirmButton){
			if(withdrawMoney.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "You don't input any number",null, JOptionPane.WARNING_MESSAGE); 
			}
			else{
				BankControlSystem control = new BankControlSystem();
				Account loadAccount = new Account();
				loadAccount = control.loadAccountFromFile(accNo, pinNo);
				System.out.print(loadAccount.getClass());
				if(!loadAccount.isSuspend){
					if(control.withdraw(loadAccount, Integer.parseInt(withdrawMoney.getText()))){
						JOptionPane.showMessageDialog(null, "Successful",null, JOptionPane.INFORMATION_MESSAGE); 
					}
					else{
						JOptionPane.showMessageDialog(null, "This account is not balance!",null, JOptionPane.WARNING_MESSAGE); 
					}	
				}
				else{
					JOptionPane.showMessageDialog(null, "This account has been suspended!",null, JOptionPane.WARNING_MESSAGE); 
				}
				
				returnToGUI(withdrawFrame);	
			}
		}
		else{
			returnToGUI(withdrawFrame);
		}
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
		customer.accountNumber = this.accNo;
		customer.pinNumber = this.pinNo;
		customer.create();	
	}

}
