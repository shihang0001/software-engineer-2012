
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class EntranceGUI extends JFrame implements MouseListener {
	JFrame mainFrame = new JFrame("Enrance");
	JPanel east =new JPanel();
	JPanel west =new JPanel();
	String[] function ={"Staff","Public","Back"};
	JButton jb[]=new JButton[function.length];
	JTextField sIDnum = new JTextField();
	JTextField scIDnum = new JTextField();
	JTextField pcIDnum = new JTextField();
	JButton ok1 = new JButton("OK");
	JButton ok2 = new JButton("OK");
	JLabel hint=new JLabel();

	public void go(){
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 500);
		mainFrame.setLayout(new BorderLayout());
        mainFrame.add(BorderLayout.WEST,west);
		west.setLayout(new GridLayout(6,1,10,30));
		west.setPreferredSize(new Dimension(200,500));
		ok1.addMouseListener(this);
		ok2.addMouseListener(this);
		for(int i=0;i<function.length;i++){
			
			jb[i] = new JButton();
			jb[i].setText(function[i]); 
			jb[i].addMouseListener(this);
			west.add(jb[i]);
			}
	}
	public void createEastone(){
		east.removeAll();
		JPanel Row1=new JPanel();
		JPanel Row2=new JPanel();
		JPanel Row3=new JPanel();
		String[] Att = {"     staffID:","    carID:"};
		east.setLayout(new GridLayout(3,1));
		east.setPreferredSize(new Dimension(500,500));
		mainFrame.add(BorderLayout.EAST,east);

		Row1.setLayout(new GridLayout(2,2));
		Row1.setPreferredSize(new Dimension(500,50));
		Row1.add(new JLabel(Att[0]));
		Row1.add(sIDnum);	
		Row1.add(new JLabel(Att[1]));
		Row1.add(scIDnum);
		east.add(Row1);
		
		Row2.setPreferredSize(new Dimension(500,30));
		Row2.setLayout(new GridLayout(2,3));
		for(int i=0;i<4;i++){
		Row2.add(new JLabel(""));
		}

		Row2.add(ok1);
		Row2.add(new JLabel(""));
		east.add(Row2);
		
		Row3.add(hint);
		east.add(Row3);
		mainFrame.setVisible(true);
		 
	}
	
	public void createEasttwo(){
		east.removeAll();
		JPanel Row1=new JPanel();
		JPanel Row2=new JPanel();
		JPanel Row3=new JPanel();
		String[] Att = {"   carID:"};
		east.setLayout(new GridLayout(3,1));
		east.setPreferredSize(new Dimension(500,500));
		mainFrame.add(BorderLayout.EAST,east);
		
		Row1.setLayout(new GridLayout(2,2));
		Row1.setPreferredSize(new Dimension(500,30));
		Row1.add(new JLabel(""));
		Row1.add(new JLabel(""));	
		Row1.add(new JLabel(Att[0]));
		Row1.add(pcIDnum);
		east.add(Row1);
		
		Row2.setPreferredSize(new Dimension(500,30));
		Row2.setLayout(new GridLayout(2,3));
		for(int i=0;i<4;i++){
		Row2.add(new JLabel(""));
		}

		Row2.add(ok2);
		Row2.add(new JLabel(""));
		east.add(Row2);
		
		Row3.add(hint);
		east.add(Row3);
		mainFrame.setVisible(true);
		 
	}
	
	
	
	
/*	private JFrame f1=new JFrame("Entrance");
	private JPanel west=new JPanel();
	JPanel east=new JPanel();
	JPanel east1=new JPanel();
	JPanel east2=new JPanel();
	JLabel staffID=new JLabel("Staff ID:");
	JTextField sIDnum=new JTextField();
	JLabel carID=new JLabel("Car ID:");
	JTextField cIDnum=new JTextField();
	Button ok1=new Button("OK");
	private JButton staffBtn=new JButton("Staff");
  	private JButton publicBtn=new JButton("Public");

	Button ok2=new Button("OK");
	
	public EntranceGUI(){
		f1.setSize(1000,600);
		f1.setResizable(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setLayout(new BorderLayout());
		f1.setVisible(true);
		iniComponent();
	}
	
	private void iniComponent() {
		west.setPreferredSize(new Dimension(400,600));
		west.setLayout(new GridLayout(5,3));
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		west.add(staffBtn);
		staffBtn.addMouseListener(this);
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		west.add(publicBtn);
		publicBtn.addMouseListener(this);
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		west.add(new JLabel(" "));
		f1.add(west,BorderLayout.WEST);
		ok2.addMouseListener(this);
		f1.add(east,BorderLayout.EAST);

	}

	public void staff(){
		f1.getContentPane().removeAll();
	//	east.repaint();
		east.setPreferredSize(new Dimension(500,600));
		east.setLayout(new BorderLayout());
		f1.add(east,BorderLayout.EAST);
		east1.setLayout(new GridLayout(3,2));
		east1.add(staffID);
		east1.add(sIDnum);
		east1.add(new Label(" "));
		east1.add(new Label(" "));
		east1.add(carID);
		east1.add(cIDnum);
		east1.add(new Label(" "));
		east1.add(new Label(" "));
		east1.add(new Label(" "));
		east1.add(ok1);
		ok1.addMouseListener(this);
		east.add(east1,BorderLayout.NORTH);
		east.add(east2,BorderLayout.SOUTH);
		f1.setVisible(true);
	}
	
	public void publi(){
		f1.getContentPane().removeAll();
	//	east.removeAll();
	//	east.repaint();
		east1.setLayout(new GridLayout(2,2));

		east1.add(new Label(" "));
		east1.add(new Label(" "));
		east1.add(carID);
		east1.add(cIDnum);
		east1.add(new Label(" "));
		east1.add(new Label(" "));
		east1.add(new Label(" "));
		east1.add(ok2);
	
//		ok2.setPreferredSize(new Dimension(30,10));
		east.setPreferredSize(new Dimension(600,600));
		east.setLayout(new BorderLayout());
	
		east.add(east1,BorderLayout.NORTH);
		east.add(east2,BorderLayout.SOUTH);
		f1.add(east,BorderLayout.EAST);
		f1.setVisible(true);
	}*/
	
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb[0]) { 
			 createEastone();
		}else if(e.getSource()==jb[1]){
			 createEasttwo();
		}else if(e.getSource()==jb[2]){
			mainFrame.setVisible(false);
			new ParkingSystem();
		}else if (e.getSource() == ok1) {
			 if(Entrance.identify(scIDnum.getText(), sIDnum.getText())){ //carID, staffID
				Ticket t=Entrance.generateTicketforStaff(scIDnum.getText(), sIDnum.getText());//carID, staffID
				//hint.setText("Ticket ID : "+t.getTicketID()+"\n"+"Staff Type: "+t.getStaffType()+"\n"+"Staff ID: "+t.getStaffID()+"\n"+"Car ID: "+t.getCarID()+"\n"+"Enter Time: "+t.getEnterTime());
				JOptionPane.showMessageDialog(null, "Ticket ID : "+t.getTicketID()+"\n"+"Staff Type: "+t.getStaffType()+"\n"+"Staff ID: "+t.getStaffID()+"\n"+"Car ID: "+t.getCarID()+"\n"+"Enter Time: "+t.getEnterTime(),null, JOptionPane.INFORMATION_MESSAGE, null); 
			 }
			 else{
				hint.setText("Staff is not exist!");
			 }
		 }else if(e.getSource() == ok2 ){
	//		 System.out.println("352");
			if(Entrance.dateIdentify()){
				Ticket t=Entrance.generateTicketforPublic(pcIDnum.getText());
				//hint.setText("Ticket ID : "+t.getTicketID()+"\n"+"Staff Type: "+t.getStaffType()+"\n"+"Car ID: "+t.getCarID()+"\n"+"Enter Time: "+t.getEnterTime());
				JOptionPane.showMessageDialog(null, "Ticket ID : "+t.getTicketID()+"\n"+"Staff Type: "+t.getStaffType()+"\n"+"Car ID: "+t.getCarID()+"\n"+"Enter Time: "+t.getEnterTime(),null, JOptionPane.INFORMATION_MESSAGE, null); 
			}else{
	//			 System.out.println("332");
				hint.setText("Today is not weekend, access denied!");
			}
	        }
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
