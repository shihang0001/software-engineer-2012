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


public class DeleteGUI implements GUIConstructor, ActionListener {
	//GUI Content Declaration
		private JFrame deleteFrame;
		private JButton confirmButton, resetButton, returnButton;
		private JTextField accNo,PIN;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		deleteFrame = new JFrame();
		this.constructContent();
		deleteFrame.setSize(800,500);
		deleteFrame.show();
		deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)deleteFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = deleteFrame.getContentPane();
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
		confirmButton = new JButton("Delete");
		resetButton = new JButton("Reset");
		returnButton = new JButton("Return");
		confirmButton.setPreferredSize(new Dimension(200, 50));
		resetButton.setPreferredSize(new Dimension(200,50));
		returnButton.setPreferredSize(new Dimension(200,50));
		confirmButton.addActionListener(this);
		resetButton.addActionListener(this);
		returnButton.addActionListener(this);
		subPanel3.add(confirmButton);
		subPanel3.add(resetButton);
		subPanel3.add(returnButton);
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
		if(event.getSource()==confirmButton){
			BankControlSystem control = new BankControlSystem();
			if(control.deleteAccount(accNo.getText(), PIN.getText())==0){
				//Success
				JOptionPane.showMessageDialog(null, "Success!",null, JOptionPane.INFORMATION_MESSAGE); 
			}
			else if(control.deleteAccount(accNo.getText(), PIN.getText())==1){
				//Not balance
				JOptionPane.showMessageDialog(null, "This account cannot be deleted!\n"+"Still have money",null, JOptionPane.WARNING_MESSAGE); 
			}
			else if(control.deleteAccount(accNo.getText(), PIN.getText())==2){
				//Not match
				JOptionPane.showMessageDialog(null, "The account number and the PIN doesn't match",null, JOptionPane.WARNING_MESSAGE); 
			}
			else if(control.deleteAccount(accNo.getText(), PIN.getText())==3){
				//No account
				JOptionPane.showMessageDialog(null, "The account doesn't exist",null, JOptionPane.WARNING_MESSAGE); 
			}
			else if(control.deleteAccount(accNo.getText(), PIN.getText())==5){
				//Fail to delete
				JOptionPane.showMessageDialog(null, "Failed to delete!",null, JOptionPane.WARNING_MESSAGE); 
			}
		}
		else if(event.getSource()==resetButton){
			accNo.setText(null);
			PIN.setText(null);
		}
		else{
			returnToGUI(deleteFrame);
		}
	}

}
