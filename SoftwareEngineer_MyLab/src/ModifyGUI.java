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


public class ModifyGUI implements GUIConstructor, ActionListener {

	//GUI Content Declaration
	private JFrame modifyFrame;
	private JButton confirmButton, resetButton, returnButton;
	private JTextField Name,Credit;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		modifyFrame = new JFrame();
		this.constructContent();
		modifyFrame.setSize(800,500);
		modifyFrame.show();
		modifyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void constructContent() {
		// TODO Auto-generated method stub
		((JPanel)modifyFrame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Container defaultPanel = modifyFrame.getContentPane();
		defaultPanel.setLayout(new BorderLayout());
		JPanel subPanel1 = new JPanel();
		JLabel title = new JLabel("Please Input your name and credit");		
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
		Name = new JTextField();
		Name.setPreferredSize(new Dimension(100,40));
		Credit = new JTextField();
		Credit.setPreferredSize(new Dimension(100,40));
		JLabel NameLabel = new JLabel("Name:");
		JLabel CreditNoLabel = new JLabel("Credit:     ");
		subPanel2_1.add(NameLabel);
		subPanel2_1.add(Name);
		subPanel2_2.add(CreditNoLabel);
		subPanel2_2.add(Credit);
		subPanel2.add(subPanel2_1);
		subPanel2.add(subPanel2_2);
		defaultPanel.add(subPanel2, BorderLayout.CENTER);
		
		JPanel subPanel3 = new JPanel();
		confirmButton = new JButton("Modify");
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
		CreditAgencyGUI creditagency = new CreditAgencyGUI();
		creditagency.create();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==resetButton){
			Name.setText(null);
			Credit.setText(null);
		}
		else if(event.getSource()==returnButton){
			returnToGUI(modifyFrame);
		}
		else if(event.getSource()==confirmButton){
			CreditAgencyControl control = new CreditAgencyControl();
			if(control.setCreditForExistCustomer(Name.getText(), Credit.getText())==0){
				JOptionPane.showMessageDialog(null, "Success!",null, JOptionPane.INFORMATION_MESSAGE); 
			}
			else if(control.setCreditForExistCustomer(Name.getText(), Credit.getText())==1){
				JOptionPane.showMessageDialog(null, "This man doesn't exist, modify permission denied!",null, JOptionPane.WARNING_MESSAGE); 
			}
		}
	}

}
