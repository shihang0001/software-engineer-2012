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

/*
 * TIME APR 25TH
 * GUI USED FOR STAFF OPERATION
 */
public class StaffGUI implements ActionListener, GUIConstructor {
	//GUI Content Declaration
	private JFrame staffFrame;
	private JPanel buttonPanel;
	private JButton registerButton, suspendButton, desuspendButton,deleteButton,returnButton;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		staffFrame = new JFrame();
		this.constructContent();
		staffFrame.setSize(800,500);
		staffFrame.show();
		staffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)staffFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = staffFrame.getContentPane();
		defaultPanel.setLayout(new GridLayout(1,2,0,0));
		buttonPanel = new JPanel(new GridLayout(5,1,0,50));
		//add the picture
		JLabel iconLabel = new JLabel();
		ImageIcon icon = new ImageIcon("staff.jpg");
		iconLabel.setIcon(icon);
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		suspendButton = new JButton("Suspend");
		suspendButton.addActionListener(this);
		desuspendButton = new JButton("De-Suspend");
		desuspendButton.addActionListener(this);
		deleteButton = new JButton("Delete Account");
		deleteButton.addActionListener(this);
		returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		buttonPanel.add(registerButton);
		buttonPanel.add(suspendButton);
		buttonPanel.add(desuspendButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(returnButton);
		defaultPanel.add(iconLabel);
		defaultPanel.add(buttonPanel);

	}

	@Override
	public void transitToGUI(int i) {
		// TODO Auto-generated method stub
		if(i==0){
			staffFrame.setVisible(false);
			RegisterGUI register = new RegisterGUI();
			register.create();
		}
		else if(i==1){
			staffFrame.setVisible(false);
			SuspendGUI suspend = new SuspendGUI();
			suspend.create();
		}
		else if(i==2){
			staffFrame.setVisible(false);
			DesuspendGUI desuspend = new DesuspendGUI();
			desuspend.create();
		}
		else if(i==3){
			staffFrame.setVisible(false);
			DeleteGUI desuspend = new DeleteGUI();
			desuspend.create();
		}
		else{
			returnToGUI(staffFrame);
		}
	}

	@Override
	public void returnToGUI(JFrame frame) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		MainGUI main = new MainGUI();
		main.create();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==registerButton){
			transitToGUI(0);
		}
		else if(event.getSource()==suspendButton){
			transitToGUI(1);
		}
		else if(event.getSource()==desuspendButton){
			transitToGUI(2);
		}
		else if(event.getSource()==deleteButton){
			transitToGUI(3);
		}
		else{
			returnToGUI(staffFrame);
		}
		
		
	}

}
