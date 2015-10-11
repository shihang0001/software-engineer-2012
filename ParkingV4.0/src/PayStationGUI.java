
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class PayStationGUI extends JFrame implements MouseListener {
	JFrame mainFrame = new JFrame("PayStation");
	JPanel east =new JPanel();
	JPanel west =new JPanel();
//	String[] function ={"Total fare:","Choose your coins:"};
//	JButton jb[]=new JButton[function.length];
	JLabel ticketID=new JLabel("    ticketID:");
	JTextField ticketnum=new JTextField();
	JLabel carID=new JLabel("    carID:");
	JTextField carnum=new JTextField();
	JButton confirm=new JButton("confirm");
	JButton back=new JButton("Back");
	JLabel total=new JLabel();
	JSpinner p50=new JSpinner();
	JSpinner e1=new JSpinner();
	JSpinner e2=new JSpinner();
	JButton ok = new JButton("OK");
	JLabel hint=new JLabel("");
	
	public void go(){
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 500);
		mainFrame.setLayout(new BorderLayout());
        mainFrame.add(BorderLayout.WEST,west);
		west.setLayout(new GridLayout(8,1,10,20));
		west.setPreferredSize(new Dimension(200,500));
		west.add(ticketID);
		west.add(ticketnum);
		west.add(carID);
		west.add(carnum);
		west.add(confirm);
		west.add(back);
		back.addMouseListener(this);
		confirm.addMouseListener(this);
		ok.addMouseListener(this);

	}
	public void createEastone(){
		east.removeAll();
		JPanel Row1=new JPanel();
		JPanel Row2=new JPanel();
		JPanel Row3=new JPanel();
		String[] Att = {"Total fare:","Choose your coins:","¡ê0.5","¡ê1","¡ê2"};
		east.setLayout(new GridLayout(3,1));
		east.setPreferredSize(new Dimension(500,500));
		mainFrame.add(BorderLayout.EAST,east);

		Row1.setLayout(new GridLayout(5,2));
		Row1.setPreferredSize(new Dimension(500,300));
		Row1.add(new JLabel(Att[0]));
		Row1.add(total);	
		Row1.add(new JLabel(Att[1]));
		Row1.add(new JLabel(" "));
		Row1.add(new JLabel(Att[2]));
		Row1.add(p50);
		Row1.add(new JLabel(Att[3]));
		Row1.add(e1);
		Row1.add(new JLabel(Att[4]));
		Row1.add(e2);
		east.add(Row1);
		
		Row2.setPreferredSize(new Dimension(500,30));
		Row2.setLayout(new GridLayout(2,3));
		for(int i=0;i<4;i++){
		Row2.add(new JLabel(""));
		}

		Row2.add(ok);
		Row2.add(new JLabel(""));
		east.add(Row2);
		
		Row3.add(hint);
		east.add(Row3);
		mainFrame.setVisible(true);
		 
	}

	public void mouseClicked(MouseEvent e) {
		int i=0;
		// TODO Auto-generated method stub
		if (e.getSource() == back) { 
			mainFrame.setVisible(false);
			new ParkingSystem();
		}else if(e.getSource()==confirm){
		    i=PayStation.identify(Integer.parseInt(ticketnum.getText()), carnum.getText());
			if(i>=0){
				Ticket t=Parking_Control.ticketList.get(i);
				total.setText(t.getFee()+"");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "No such ticket!",null,JOptionPane.WARNING_MESSAGE,null);
			}
		}else if (e.getSource() == ok) {
			String messege = PayStation.receiveMoney((int)p50.getValue(), (int)e1.getValue(),(int)e2.getValue(),i);
			hint.setText(messege);
	           //jLabel10.setText()
/*			 if(Entrance.identify(cIDnum.getText(), sIDnum.getText())){ //carID, staffID
				Entrance.generateTicketforStaff(cIDnum.getText(), sIDnum.getText());//carID, staffID
			 }
			 else{
				//error
			 }*/
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
