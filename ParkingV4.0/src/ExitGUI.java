
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ExitGUI extends JFrame implements MouseListener {
	JFrame mainFrame = new JFrame("Exit");
	JPanel east =new JPanel();
	JPanel west =new JPanel();
	String[] function ={"Staff","Public","Back"};
	JButton jb[]=new JButton[function.length];
	JTextField sticketnum = new JTextField();
	JTextField scIDnum = new JTextField();
	JTextField ticketnum = new JTextField();
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
		String[] Att = {"   staff ticket ID:","   carID:"};
		east.setLayout(new GridLayout(3,1));
		east.setPreferredSize(new Dimension(500,500));
		mainFrame.add(BorderLayout.EAST,east);

		Row1.setLayout(new GridLayout(2,2));
		Row1.setPreferredSize(new Dimension(500,30));
		Row1.add(new JLabel(Att[0]));
		Row1.add(sticketnum);	
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
		String[] Att = {"   ticketID:","   carID:"};
		east.setLayout(new GridLayout(3,1));
		east.setPreferredSize(new Dimension(500,500));
		mainFrame.add(BorderLayout.EAST,east);

		Row1.setLayout(new GridLayout(2,2));
		Row1.setPreferredSize(new Dimension(500,30));
		Row1.add(new JLabel(Att[0]));
		Row1.add(ticketnum);	
		Row1.add(new JLabel(Att[1]));
		Row1.add(pcIDnum);
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
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb[0]) { 
			 createEastone();
		}else if(e.getSource()==jb[1]){
			 createEasttwo();
		}else if(e.getSource()==jb[2]){
			mainFrame.setVisible(false);
			new ParkingSystem();
		}
		else if (e.getSource() == ok1) {
			int a =Exit.check(Integer.parseInt(sticketnum.getText()), scIDnum.getText());
			 System.out.println(a);
	        if(a==0){
	         hint.setText("Success!");
	         
	        }
	        if(a==1){
	        	hint.setText("Not Pay");
	        }
	        if(a==2){
	        	hint.setText("Wrong Ticket ID");
	        }
	        if(a==3){
	        	hint.setText("repeat scan");
	        }
	 }else if(e.getSource() == ok2 ){
		   int a =Exit.check(Integer.parseInt(ticketnum.getText()), pcIDnum.getText());
		   System.out.println(a);
	            if(a==0){
		         hint.setText("Success!");
		         Parking_Control.setParking_num(Parking_Control.getParking_num()+1);
		        }
		        if(a==1){
		        	hint.setText("Not Pay");
		        }
		        if(a==2){
		        	hint.setText("Wrong Ticket ID");
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
