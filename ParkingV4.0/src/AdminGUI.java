
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AdminGUI implements ActionListener ,GUIConstuctor {

	//GUI Content Declaration
		private JFrame adminFrame;
		private JPanel infoPanel,buttonPanel;
		private JButton registerButton, addBlankPaperButton, add50PennyButton, add1PoundButton,add2PoundButton,sendBillButton,returnButton;
		private JLabel blankPaperLabel,Penny_50Label,Pound_1Label,Pound_2Label,ParkingNumberLabel;
		private Admin admin;
		public AdminGUI(Admin a){
			this.admin=a;
		}
		@Override
		public void create() {
			// TODO Auto-generated method stub
			adminFrame = new JFrame();
			this.constructContent();
			adminFrame.setSize(800,500);
			adminFrame.show();
			adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

		@Override
		public void constructContent() {
			// TODO Auto-generated method stub
			((JPanel)adminFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
			Container defaultPanel = adminFrame.getContentPane();
			defaultPanel.setLayout(new GridLayout(1,2,0,0));
			buttonPanel = new JPanel(new GridLayout(7,1,0,50));
			infoPanel = new JPanel(new GridLayout(5,1,50,50));
			infoPanel.setBorder(BorderFactory.createEmptyBorder(0,80,0,0));
			//add the picture
			/*
			JLabel iconLabel = new JLabel();
			ImageIcon icon = new ImageIcon("staff.jpg");
			iconLabel.setIcon(icon);
			*/
			blankPaperLabel = new JLabel();
			Penny_50Label = new JLabel();
			Pound_1Label = new JLabel();
			Pound_2Label = new JLabel();
			ParkingNumberLabel = new JLabel();
			blankPaperLabel.setText("Blank Paper: "+Parking_Control.getPaper());
			Penny_50Label.setText("pound 0.5: "+Parking_Control.getPenny_50());
			Pound_1Label.setText("pound 1: "+Parking_Control.getPound_1());
			Pound_2Label.setText("pound 2: "+Parking_Control.getPound_2());
			ParkingNumberLabel.setText("Empty Parking Number: "+Parking_Control.getParking_num());
			infoPanel.add(blankPaperLabel);
			infoPanel.add(Penny_50Label);
			infoPanel.add(Pound_1Label);
			infoPanel.add(Pound_2Label);
			infoPanel.add(ParkingNumberLabel);
			registerButton = new JButton("Register");
			registerButton.addActionListener(this);
			addBlankPaperButton = new JButton("Add 100 Blank Paper");
			addBlankPaperButton.addActionListener(this);
			add50PennyButton = new JButton("Add 100 pound 0.5 Coin");
			add50PennyButton.addActionListener(this);
			add1PoundButton = new JButton("Add 100 pound 1 Coin");
			add1PoundButton.addActionListener(this);
			add2PoundButton = new JButton("Add 100 pound 2 Coin");
			add2PoundButton.addActionListener(this);
			sendBillButton = new JButton("Send Bill");
			sendBillButton.addActionListener(this);
			returnButton = new JButton("Return");
			returnButton.addActionListener(this);
			buttonPanel.add(registerButton);
			buttonPanel.add(addBlankPaperButton);
			buttonPanel.add(add50PennyButton);
			buttonPanel.add(add1PoundButton);
			buttonPanel.add(add2PoundButton);
			buttonPanel.add(sendBillButton);
			buttonPanel.add(returnButton);
			defaultPanel.add(buttonPanel);
			defaultPanel.add(infoPanel);
			warning();
		}

		@Override
		public void transitToGUI(int i) {
			// TODO Auto-generated method stub
			if(i==0){
				adminFrame.setVisible(false);
				RegisterGUI register = new RegisterGUI(admin);
				register.create();
			}
			else{
				returnToGUI(adminFrame);
			}
		}

		@Override
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

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource()==registerButton){
				transitToGUI(0);
			}
			else if(event.getSource()==add50PennyButton){
				//transitToGUI(1);
				admin.addPenny_50(100);
				JOptionPane.showMessageDialog(null, "Successful!\n"+"Now you have "+Parking_Control.getPenny_50()+"pound 0.5 coins",null, JOptionPane.INFORMATION_MESSAGE, null);
				refresh();
			}
			else if(event.getSource()==add1PoundButton){
				//transitToGUI(2);
				admin.addPound_1(100);
				JOptionPane.showMessageDialog(null, "Successful\n"+"Now you have "+Parking_Control.getPound_1()+"pound 1 coins",null, JOptionPane.INFORMATION_MESSAGE, null); 
				refresh();
			}
			else if(event.getSource()==add2PoundButton){
				//transitToGUI(2);
				admin.addPound_2(100);
				JOptionPane.showMessageDialog(null, "Successful\n"+"Now you have "+Parking_Control.getPound_2()+"pound 2 coins",null, JOptionPane.INFORMATION_MESSAGE, null); 
				refresh();
			}
			else if(event.getSource()==addBlankPaperButton){
				//transitToGUI(3);
				admin.addPaper(100);
				JOptionPane.showMessageDialog(null, "Successful\n"+"Now you have "+Parking_Control.getPaper()+"blank papers",null, JOptionPane.INFORMATION_MESSAGE, null); 
				refresh();
			}
	//		else if(event.getSource()==sendBillButton){
	//			admin.
	//		}
			else{
				admin.storeinfo();
				returnToGUI(adminFrame);
			}
			
			
		}
		
		public void refresh(){
			if(Parking_Control.getPaper()>15){
				//blankPaperLabel.setText("Blank Paper: "+Parking_Control.getPaper());
				Font font=new Font("Monospaced",Font.PLAIN,13);//				blankPaperLabel.setForeground(Color.BLACK);//				blankPaperLabel.setFont(font);
			}
			if(Parking_Control.getPenny_50()>15){
				Font font=new Font("Monospaced",Font.PLAIN,13);//				Penny_50Label.setForeground(Color.BLACK);//				Penny_50Label.setFont(font);
			}
			if(Parking_Control.getPound_1()>15){
				Font font=new Font("Monospaced",Font.PLAIN,13);//				Pound_1Label.setForeground(Color.BLACK);//			Pound_1Label.setFont(font);
			}
			if(Parking_Control.getPound_2()>15){
				Font font=new Font("Monospaced",Font.PLAIN,13);//				Pound_2Label.setForeground(Color.BLACK);//			Pound_2Label.setFont(font);
			}
			blankPaperLabel.setText("Blank Paper: "+Parking_Control.getPaper());
			Penny_50Label.setText("pound 0.5: "+Parking_Control.getPenny_50());
			Pound_1Label.setText("pound 1: "+Parking_Control.getPound_1());
			Pound_2Label.setText("pound 2: "+Parking_Control.getPound_2());
			ParkingNumberLabel.setText("Empty Parking Number: "+Parking_Control.getParking_num());
		}
		
		public void warning(){
			if(Parking_Control.getPaper()<=15){
				//blankPaperLabel.setText("Blank Paper: "+Parking_Control.getPaper());
				Font font=new Font("Monospaced",Font.BOLD,32);//				blankPaperLabel.setForeground(Color.RED);//				blankPaperLabel.setFont(font);
			}
			if(Parking_Control.getPenny_50()<=15){
				Font font=new Font("Monospaced",Font.BOLD,32);//				Penny_50Label.setForeground(Color.RED);//				Penny_50Label.setFont(font);
			}
			if(Parking_Control.getPound_1()<=15){
				Font font=new Font("Monospaced",Font.BOLD,32);//				Pound_1Label.setForeground(Color.RED);//				Pound_1Label.setFont(font);
			}
			if(Parking_Control.getPound_2()<=15){
				Font font=new Font("Monospaced",Font.BOLD,32);//				Pound_2Label.setForeground(Color.RED);//				Pound_2Label.setFont(font);
			}
			refresh();
		}
		


}
