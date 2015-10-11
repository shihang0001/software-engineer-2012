import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * TIME APR 25TH
 * GUI USED FOR Customer when logining in
 */
public class CustomerGUI implements ActionListener, GUIConstructor {
	//GUI Content Declaration
	private JFrame customerFrame;
	private JPanel buttonPanel;
	private JButton depositButton, withdrawButton, returnButton;
	public String pinNumber, accountNumber = new String();

	@Override
	public void create() {
		// TODO Auto-generated method stub
		customerFrame = new JFrame();
		customerFrame.setSize(800,500);
		customerFrame.show();
		this.constructContent();
		customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)customerFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = customerFrame.getContentPane();
		defaultPanel.setLayout(new GridLayout(1,2,0,0));
		buttonPanel = new JPanel(new GridLayout(3,1,0,50));
		JLabel infoLabel = new JLabel();
		infoLabel.setLocation(100, 100);
		setRemainMoneyLabel(accountNumber, infoLabel);
		//infoLable.setText("You have "+" " +" in this account");
		depositButton = new JButton("Deposit");
		depositButton.addActionListener(this);
		withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(this);
		returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		depositButton.setSize(100, 50);
		buttonPanel.add(depositButton);
		buttonPanel.add(withdrawButton);
		buttonPanel.add(returnButton);
		defaultPanel.add(infoLabel);
		defaultPanel.add(buttonPanel);

	}

	@Override
	public void transitToGUI(int i) {
		// TODO Auto-generated method stub
		if(i==0){
			customerFrame.setVisible(false);
			DepositGUI deposit = new DepositGUI();
			deposit.pinNo = this.pinNumber;
			deposit.accountNumber = this.accountNumber;
			deposit.create();	
		}
		else{
			customerFrame.setVisible(false);
			WithdrawGUI withdraw = new WithdrawGUI();
			withdraw.accNo = this.accountNumber;
			withdraw.pinNo = this.pinNumber;
			withdraw.create();	
		}
		

	}

	@Override
	public void returnToGUI(JFrame frame) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		MainGUI customer = new MainGUI();
		customer.create();		

	}
	
	@Override
	//handle the event
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==depositButton){
			transitToGUI(0);
		}
		else if(event.getSource()==withdrawButton){
			transitToGUI(1);
		}
		else{
			returnToGUI(customerFrame);
		}
	}
	
	public void setRemainMoneyLabel(String accNo, JLabel label){
		ArrayList<String> accountcontent = new ArrayList<String>();
		//ArrayList<String> remain = new ArrayList<String>();
		String text = new String();
		try {
			FileReader fr = new FileReader(accNo+".dat");
			BufferedReader br = new BufferedReader(fr);
			String[] info = new String[6];
			while((text = br.readLine()) != null){
				info = text.split(" ");

			}
			
			for(int i=0;i<info.length;i++){
				accountcontent.add(info[i]);
			}
			label.setText("You have "+accountcontent.get(5) +" cash and "+accountcontent.get(6)+" check in this account");
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		} 
	}

}
