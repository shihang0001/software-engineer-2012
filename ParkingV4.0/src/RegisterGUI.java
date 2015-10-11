
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class RegisterGUI implements GUIConstuctor, ActionListener {
	private JFrame registerFrame;
	private JButton confirmButton, resetButton, backButton;
	private JTextField name, staffID, carID;
	private Admin adm;
	public RegisterGUI(Admin a){
		this.adm = a;
	}
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
		
		JPanel subPanel2 = new JPanel(new GridLayout(1,2,0,0));
		JPanel imagePanel = new JPanel();
		JPanel textFieldPanel = new JPanel();
		subPanel2.setBorder(BorderFactory.createEmptyBorder(70,50,50,50));
		textFieldPanel.setLayout(new GridLayout(4,1,0,0));
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
		staffID = new JTextField();
		staffID.setPreferredSize(new Dimension(200,40));
		carID = new JTextField();
		carID.setPreferredSize(new Dimension(200,40));
		JLabel nameLabel = new JLabel("Name:  ");
		JLabel staffIDLabel = new JLabel("staffID:");
		JLabel birthdayLabel = new JLabel("carID:  ");
		subPanel2_1.add(nameLabel);
		subPanel2_1.add(name);
		subPanel2_2.add(staffIDLabel);
		subPanel2_2.add(staffID);
		subPanel2_3.add(birthdayLabel);
		subPanel2_3.add(carID);
		JLabel iconLabel = new JLabel();
		ImageIcon icon = new ImageIcon("register.png");
		iconLabel.setIcon(icon);
		imagePanel.add(iconLabel);
		textFieldPanel.add(subPanel2_1);
		textFieldPanel.add(subPanel2_2);
		textFieldPanel.add(subPanel2_3);
		textFieldPanel.add(subPanel2_4);
		subPanel2.add(imagePanel);
		subPanel2.add(textFieldPanel);
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
		AdminGUI admin = new AdminGUI(adm);
		admin.create();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==confirmButton){
			if(check(staffID.getText(), carID.getText())){
				adm.addStaff(staffID.getText(), carID.getText());
				JOptionPane.showMessageDialog(null, "Successfully Registered!\n"+"Your staffID is "+staffID.getText()+"\n"+"Your carID is "+carID.getText(),null, JOptionPane.INFORMATION_MESSAGE, null); 
			}
			else{
				JOptionPane.showMessageDialog(null, "Formate is not as required\n"+"Your staffID should have 6 digits\n"+"your carID should like AB12ABC",null, JOptionPane.INFORMATION_MESSAGE, null); 
			}
		}
		else if(event.getSource()==resetButton){
			name.setText(null);
			staffID.setText(null);
			carID.setText(null);
		}
		else{
			returnToGUI(registerFrame);
		}
	}
	
	public boolean check(String staffID, String carID){
		if(staffID.length()==6 && carID.length()==7){
			for(int i=0; i<staffID.length(); i++){
				Character sc = new Character(staffID.charAt(i));
					if(!Character.isDigit(sc)){
					return false;
				}
			}
			for(int i=0;i<carID.length();i++){
				Character cc = new Character(carID.charAt(i));
				if(i<=1){
					if(Character.isLowerCase(cc)||Character.isDigit(cc)){
						return false;
					}
				}
				else if(i>1 && i<=3){
					if(!Character.isDigit(cc)){
						return false;
					}
				}
				else{
					if(Character.isLowerCase(cc)||Character.isDigit(cc)){
						return false;
					}
				}
			}
			return true;
		}
		else{
			return false;
		}
	}


}
