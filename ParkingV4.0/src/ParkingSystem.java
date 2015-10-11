
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sophia
 */
public class ParkingSystem extends JFrame implements ActionListener,WindowListener{
	
	private JFrame f=new JFrame("Welcome to QM Car Park");
	private JPanel west=new JPanel();
	private JPanel east=new JPanel();
	private JPanel table=new JPanel();
	private JButton entraBtn=new JButton("entrance");
	private JButton payBtn = new JButton("payStation");
	private JButton exitBtn = new JButton("exit");
	private JButton adminBtn =new JButton("admin");
	private JLabel notice=new JLabel("NOTICE ");
	private JLabel date=new JLabel("Date:");
	private JLabel datenum=new JLabel();
	private JLabel space=new JLabel("number of space:");
	private JLabel spacenum=new JLabel();
	private JLabel chargetable=new JLabel("Charge Table");
	private JLabel t1=new JLabel("Up to 2 hours:");
	private JLabel c1=new JLabel();
	private JLabel t2=new JLabel("2 to 4 hours:");
	private JLabel c2=new JLabel();
	private JLabel t3=new JLabel("4 to 8 hours:");
	private JLabel c3=new JLabel();
	private JLabel t4=new JLabel("8 to 12 hours:");
	private JLabel c4=new JLabel();
	private JLabel t5=new JLabel("12 to 24 hours:");
	private JLabel c5=new JLabel();

	public ParkingSystem(){
		f.setSize(800,600);
		f.setResizable(true);
		f.addWindowListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		iniComponent();
	}
	
	public void iniComponent(){
		//west.setSize(500,600);
		west.setPreferredSize(new Dimension(200,500));
		west.setLayout(new GridLayout(9,1,0,0));
		west.add(new JLabel(" "));
		west.add(entraBtn);
		entraBtn.addActionListener(this);
		west.add(new JLabel(" "));
		west.add(payBtn);
		payBtn.addActionListener(this);
		west.add(new JLabel(" "));
		west.add(exitBtn);
		exitBtn.addActionListener(this);
		west.add(new JLabel(" "));
		west.add(adminBtn);
		adminBtn.addActionListener(this);
		west.add(new JLabel(" "));
		f.add(west,BorderLayout.WEST);
		
		east. setPreferredSize(new Dimension(500,500));
		notice.setPreferredSize(new Dimension(500,50));
		east.add(notice);
		east.add(table);
		datenum.setText(new Date().toString());
		spacenum.setText(Parking_Control.getParking_num()+"");
		table. setPreferredSize(new Dimension(500,500));
		table.setLayout(new GridLayout(8,2));
		table.add(date);
		table.add(datenum);
		table.add(space);
		table.add(spacenum);
		table.add(chargetable);
		table.add(new JLabel(" "));
		c1.setText("50p");
		c2.setText("pound 1");
		c3.setText("pound 2");
		c4.setText("pound 3");
		c5.setText("pound 5");
		table.add(t1);
		table.add(c1);
		table.add(t2);
		table.add(c2);
		table.add(t3);
		table.add(c3);
		table.add(t4);
		table.add(c4);
		table.add(t5);
		table.add(c5);
		f.add(east,BorderLayout.EAST);	
	}
	
	public void actionPerformed(ActionEvent evt) {
		
        if (evt.getSource() == entraBtn) {
        	if(Parking_Control.getParking_num()<=0){
        		JOptionPane.showMessageDialog(null, "No Enough Place",null, JOptionPane.WARNING_MESSAGE, null); 
        	}
        	else{
        		f.setVisible(false);
        		EntranceGUI entranceGUI=new EntranceGUI();
        		entranceGUI.go();
        		entranceGUI.createEastone();
        	}
        }
        if (evt.getSource() == payBtn) {
            f.setVisible(false);
            PayStationGUI payStationGUI=new PayStationGUI();
            payStationGUI.go();
            payStationGUI.createEastone();
        }
        if (evt.getSource() == exitBtn) {
            f.setVisible(false);
            ExitGUI exit=new ExitGUI();
            exit.go();
            exit.createEastone();
        }
        if (evt.getSource() == adminBtn) {
            f.setVisible(false);
            AdminLoginGUI admin=new AdminLoginGUI();
            admin.create();
        }
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		finish();
		// TODO Auto-generated method stub
		//store information
	}

	private void finish() {
		Parking_Control.writeToFile(Parking_Control.getPaper(), Parking_Control.getPenny_50(), Parking_Control.getPound_1(), Parking_Control.getPound_2(),Ticket.num);
		File file =new File("ParkingSystem.dat");
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);

                objOut.writeObject(Parking_Control.ticketList);
                objOut.writeObject(Admin.staffList);
            objOut.flush();
            objOut.close();
            System.out.println("Saved Successfully...!");
        } catch (IOException e) {
            System.out.println("Saved failed...");
            e.printStackTrace();
        }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
