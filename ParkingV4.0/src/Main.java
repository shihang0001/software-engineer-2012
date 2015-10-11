
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Main implements Serializable{


	public static void main(String args[]){
		new Main().go();
	}
	
	public void go(){
		initial();
		new ParkingSystem();
	}
	
	public void initial(){
		try{
			 ObjectInputStream is = new ObjectInputStream(new FileInputStream("ParkingSystem.dat"));
			 Parking_Control.ticketList=(ArrayList) is.readObject();
			 Admin.staffList=(ArrayList) is.readObject();
			 Parking_Control.readFromFile();
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		
	}
	
	

}
