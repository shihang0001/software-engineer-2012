import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CreditAgencyGUI implements GUIConstructor, ActionListener {

	//GUI Content Declaration
		private JFrame creditFrame;
		private JPanel buttonPanel;
		private JButton modifyButton, addButton, returnButton;
		public String pinNumber, accountNumber = new String();

		@Override
		public void create() {
			// TODO Auto-generated method stub
			creditFrame = new JFrame();
			creditFrame.setSize(800,500);
			creditFrame.show();
			this.constructContent();
			creditFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

		@Override
		public void constructContent() {
			// TODO Auto-generated method stub
			((JPanel)creditFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
			Container defaultPanel = creditFrame.getContentPane();
			defaultPanel.setLayout(new GridLayout(1,2,0,0));
			buttonPanel = new JPanel(new GridLayout(3,1,0,50));
			JLabel iconLabel = new JLabel();
			ImageIcon icon = new ImageIcon("credit.png");
			iconLabel.setIcon(icon);
			
			modifyButton = new JButton("Modify");
			modifyButton.addActionListener(this);
			addButton = new JButton("Add new");
			addButton.addActionListener(this);
			returnButton = new JButton("Return");
			returnButton.addActionListener(this);
			modifyButton.setSize(100, 50);
			buttonPanel.add(modifyButton);
			buttonPanel.add(addButton);
			buttonPanel.add(returnButton);
			defaultPanel.add(iconLabel);
			defaultPanel.add(buttonPanel);

		}

		@Override
		public void transitToGUI(int i) {
			// TODO Auto-generated method stub
			if(i==0){
				creditFrame.setVisible(false);
				ModifyGUI modify = new ModifyGUI();
				//modify.pinNo = this.pinNumber;
				//modify.accountNumber = this.accountNumber;
				modify.create();	
			}
			else{
				creditFrame.setVisible(false);
				AddGUI add = new AddGUI();
				//add.accNo = this.accountNumber;
				//add.pinNo = this.pinNumber;
				add.create();	
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
			if(event.getSource()==modifyButton){
				transitToGUI(0);
			}
			else if(event.getSource()==addButton){
				transitToGUI(1);
			}
			else{
				returnToGUI(creditFrame);
			}
		}

}
