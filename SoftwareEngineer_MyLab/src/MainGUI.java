import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * TIME APR 25TH
 * GUI USED FOR MAIN GUI
 */
public class MainGUI implements ActionListener, GUIConstructor {
	//GUI Content Declaration
	private JFrame mainFrame;
	private JButton customerButton,staffButton,creditButton,exitButton;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		mainFrame = new JFrame();
		this.constructContent();
		mainFrame.setSize(800,500);
		mainFrame.show();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)mainFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = mainFrame.getContentPane();
		defaultPanel.setLayout(new BorderLayout());
		JPanel subPanel1 = new JPanel();
		JLabel title = new JLabel("Welcome to the China Bank");		
		JLabel iconLabel=new JLabel();
		subPanel1.add(title);
		defaultPanel.add(subPanel1, BorderLayout.NORTH);
		JPanel subPanel2 = new JPanel();
		subPanel2.setBorder(BorderFactory.createEmptyBorder(20,50,50,50));
		//add the picture
		ImageIcon icon = new ImageIcon("Icon.jpg");
		iconLabel.setIcon(icon);
		subPanel2.add(iconLabel);
		
		defaultPanel.add(subPanel2, BorderLayout.CENTER);
		JPanel subPanel3 = new JPanel();
		customerButton = new JButton("Customer");
		staffButton = new JButton("Bank Staff");
		creditButton = new JButton("Credit Agency");
		exitButton = new JButton("Exit");
		customerButton.setPreferredSize(new Dimension(150, 50));
		staffButton.setPreferredSize(new Dimension(150,50));
		creditButton.setPreferredSize(new Dimension(150,50));
		exitButton.setPreferredSize(new Dimension(150,50));
		customerButton.addActionListener(this);
		staffButton.addActionListener(this);
		creditButton.addActionListener(this);
		exitButton.addActionListener(this);
		subPanel3.add(customerButton);
		subPanel3.add(staffButton);
		subPanel3.add(creditButton);
		subPanel3.add(exitButton);
		defaultPanel.add(subPanel3, BorderLayout.SOUTH);
	}
	
	@Override
	public void returnToGUI(JFrame parentFrame) {
		// TODO Auto-generated method stub
	}
	
	public void transitToGUI(int i){
		if(i==0){
			mainFrame.setVisible(false);
			CustomerLoginGUI customer = new CustomerLoginGUI();
			customer.create();
		}
		else if(i==1){
			mainFrame.setVisible(false);
			StaffLoginGUI staff = new StaffLoginGUI();
			staff.create();
		}
		else if(i==2){
			mainFrame.setVisible(false);
			CreditAgencyLoginGUI creditAgency = new CreditAgencyLoginGUI();
			creditAgency.create();
		}
		else{
			JOptionPane.showMessageDialog(null, "Do you want to exit this system?",null, JOptionPane.WARNING_MESSAGE,null); 
			mainFrame.setVisible(false);
		}
	}
	
	@Override
	//handle the event
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==customerButton){
			transitToGUI(0);
		}
		else if(event.getSource()==staffButton){
			transitToGUI(1);
		}
		else if(event.getSource()==exitButton){
			transitToGUI(3);
		}
		else{	
			transitToGUI(2);
		}
		// TODO Auto-generated method stub
		
	}
}
