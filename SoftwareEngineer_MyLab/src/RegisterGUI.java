import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * TIME APR 25TH
 * GUI USED FOR REGISTER FUNCTION
 */
public class RegisterGUI implements ActionListener, GUIConstructor {
	//GUI Content Declaration
	private JFrame registerFrame;
	private JButton confirmButton, resetButton, backButton;
	private JTextField name, address, age;
	private JComboBox accounttype; 
	//private String pinnumber = new String();//注册时生成新的PIN码
	@Override
	public void create() {
		// TODO Auto-generated method stub
		registerFrame = new JFrame();
		this.constructContent();
		registerFrame.setSize(800,500);
		registerFrame.show();
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)registerFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = registerFrame.getContentPane();
		defaultPanel.setLayout(new BorderLayout());
		JPanel subPanel1 = new JPanel();
		JLabel title = new JLabel("Please type in your personal information listed below");		
		subPanel1.add(title);
		defaultPanel.add(subPanel1, BorderLayout.NORTH);
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
		subPanel2.setLayout(new GridLayout(4,1,0,0));
		JPanel subPanel2_1 = new JPanel();
		//subPanel2_1.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
		JPanel subPanel2_2 = new JPanel();
		//subPanel2_2.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
		JPanel subPanel2_3 = new JPanel();
		//subPanel2_2.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
		JPanel subPanel2_4 = new JPanel();
		//subPanel2_2.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
		name = new JTextField();
		name.setPreferredSize(new Dimension(200,40));
		address = new JTextField();
		address.setPreferredSize(new Dimension(200,40));
		age = new JTextField();
		age.setPreferredSize(new Dimension(200,40));
		accounttype = new JComboBox();
		accounttype.addItem("Saving Account");
		accounttype.addItem("Junior Account");
		accounttype.addItem("Current Account");
		accounttype.setPreferredSize(new Dimension(200,40));
		JLabel nameLabel = new JLabel("Name:  ");
		JLabel addressLabel = new JLabel("Address:");
		JLabel birthdayLabel = new JLabel("Birthday:  ");
		JLabel accounttypeLabel = new JLabel("Account Type:");
		subPanel2_1.add(nameLabel);
		subPanel2_1.add(name);
		subPanel2_2.add(addressLabel);
		subPanel2_2.add(address);
		subPanel2_3.add(birthdayLabel);
		subPanel2_3.add(age);
		subPanel2_4.add(accounttypeLabel);
		subPanel2_4.add(accounttype);
		subPanel2.add(subPanel2_1);
		subPanel2.add(subPanel2_2);
		subPanel2.add(subPanel2_3);
		subPanel2.add(subPanel2_4);
		defaultPanel.add(subPanel2, BorderLayout.CENTER);
		
		JPanel subPanel3 = new JPanel();
		confirmButton = new JButton("Register");
		resetButton = new JButton("Reset");
		backButton = new JButton("Back");
		confirmButton.setPreferredSize(new Dimension(200, 50));
		resetButton.setPreferredSize(new Dimension(200,50));
		backButton.setPreferredSize(new Dimension(200,50));
		confirmButton.addActionListener(this);
		resetButton.addActionListener(this);
		backButton.addActionListener(this);
		subPanel3.add(confirmButton);
		subPanel3.add(resetButton);
		subPanel3.add(backButton);
		defaultPanel.add(subPanel3, BorderLayout.SOUTH);

	}

	@Override
	public void transitToGUI(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnToGUI(JFrame frame) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		StaffGUI staff = new StaffGUI();
		staff.create();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println(accounttype.getSelectedItem().toString());
		BankControlSystem control = new BankControlSystem();
		String generateAcc, generatePIN = new String();
		if(event.getSource()==confirmButton){
			if(name.getText().isEmpty()||address.getText().isEmpty()||age.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "You havn't finish your infomation!",null, JOptionPane.WARNING_MESSAGE); 
			}
			else if(Integer.parseInt(control.readCredit(name.getText()))>=180){
				String type = new String();
				type = accounttype.getSelectedItem().toString();
				generateAcc = generateAccount(type);
				generatePIN = generatePIN();
				if(type.equals("Saving Account")){
					SavingAccount sa = new SavingAccount(name.getText(),address.getText(),Integer.parseInt(age.getText()),generatePIN,generateAcc,false,0);
					sa.storeAccount(sa);
					JOptionPane.showMessageDialog(null, "Successfully Registered!\n"+"Your Account Number is "+generateAccount(type)+"\n"+"Your PIN Number is "+generatePIN(),null, JOptionPane.INFORMATION_MESSAGE, null); 
				}
				else if(type.equals("Current Account")){
					CurrentAccount ca = new CurrentAccount(name.getText(),address.getText(),Integer.parseInt(age.getText()),generatePIN,generateAcc,false,0);
					ca.storeAccount(ca);
					JOptionPane.showMessageDialog(null, "Successfully Registered!\n"+"Your Account Number is "+generateAccount(type)+"\n"+"Your PIN Number is "+generatePIN(),null, JOptionPane.INFORMATION_MESSAGE, null); 
				}
				else if(type.equals("Junior Account")){
					if(Integer.parseInt(age.getText())<=16){
						JuniorAccount ja = new JuniorAccount(name.getText(),address.getText(),Integer.parseInt(age.getText()),generatePIN,generateAcc,false,0);
						ja.storeAccount(ja);
						JOptionPane.showMessageDialog(null, "Successfully Registered!\n"+"Your Account Number is "+generateAcc+"\n"+"Your PIN Number is "+generatePIN,null, JOptionPane.INFORMATION_MESSAGE, null); 
					}
					else{
						JOptionPane.showMessageDialog(null, "Your age is not qualified to open this type of account!",null, JOptionPane.INFORMATION_MESSAGE, null); 
					}
				}
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Your credit is not high enough!",null, JOptionPane.WARNING_MESSAGE); 
			}
				
		}
		else if(event.getSource()==resetButton){
			name.setText(null);
			address.setText(null);
			age.setText(null);
		}
		else{
			returnToGUI(registerFrame);
		}
	}
	
	public String generatePIN(){
		ArrayList<String> pin = new ArrayList<String>();
		pin = readFromLine("pin.dat");
		int newPin = Integer.parseInt(pin.get(0))+1;
		if(newPin<10){
			pin.set(0, "000"+newPin+"");
		}
		else if(newPin<99 && newPin>=10){
			pin.set(0, "00"+newPin+"");
		}
		else if(newPin<999 && newPin>=100){
			pin.set(0, "0"+newPin+"");
		}
		else{
			pin.set(0, newPin+"");
		}
		/*
		else if(newPin<9999 && newPin>=1000){
			pin.set(0, "00"+newPin+"");
		}
		else if(newPin<99999 && newPin>=10000){
			pin.set(0, "0"+newPin+"");
		}
		else{
			pin.set(0, newPin+"");
		}
		*/
		System.out.println(pin);
		writeBack(pin, "pin.dat",1);
		return pin.get(0);
	}
	
	public String generateAccount(String type){
		
		if(type.equals("Saving Account")){
			ArrayList<String> account = new ArrayList<String>();
			account = readFromLine("accountNo.dat");
			int newaccount = Integer.parseInt(account.get(0))+1;
			account.set(0, newaccount+"");
			writeBack(account, "accountNo.dat",3);
			return newaccount+"";
		}
		else if(type.equals("Current Account")){
			ArrayList<String> account = new ArrayList<String>();
			account = readFromLine("accountNo.dat");
			int newaccount = Integer.parseInt(account.get(1))+1;
			account.set(1, newaccount+"");
			writeBack(account, "accountNo.dat",3);
			return newaccount+"";
		}
		else {
			ArrayList<String> account = new ArrayList<String>();
			account = readFromLine("accountNo.dat");
			int newaccount = Integer.parseInt(account.get(2))+1;
			account.set(2, newaccount+"");
			writeBack(account, "accountNo.dat",3);
			return newaccount+"";
		}
		
	}
	
	public ArrayList<String> readFromLine(String fileName){
		String text = new String();
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> textFromLine = new ArrayList<String>();
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			while ((text = br.readLine()) != null) {
				textFromLine.add(text);
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		} 
		return textFromLine;
	}
	
	public void writeBack(ArrayList<String> value, String fileName, int lines){
		File file = new File(fileName);
		BufferedWriter buff;
		try {
			buff = new BufferedWriter(new FileWriter(file));
			for(int i=0; i<lines;i++){
				buff.write(value.get(i), 0, value.get(i).length());
				buff.newLine();
			}
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
