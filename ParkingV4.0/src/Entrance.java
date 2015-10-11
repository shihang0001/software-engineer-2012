
import java.util.Date;


public class Entrance extends Parking_Control {

	//boolean isBarUp;//
	

	public static Ticket generateTicketforPublic(String carID){
		Ticket ticket = new Ticket(carID);
		Parking_Control.ticketList.add(ticket);
		Parking_Control.setPaper(Parking_Control.getPaper()-1);
		Parking_Control.setParking_num(Parking_Control.getParking_num()-1);
		Entrance.printTicket(ticket);
		return ticket;
		//writeInFiles(ticket);
	}
	
	
	public static Ticket generateTicketforStaff(String carID, String staffID){
			Ticket ticket = new Ticket(carID, staffID);
			Parking_Control.ticketList.add(ticket);
			Parking_Control.setParking_num(Parking_Control.getParking_num()-1);
			Entrance.printTicket(ticket);
			return ticket;
			//writeInFiles(ticket);
	}
	
	public static void printTicket(Ticket t){
		System.out.println(t);		
	}
	
	public static boolean identify(String carID,String staffID){
		for(Staff s: Admin.staffList){
			if(s.getCarID().equals(carID)&&s.getStaffID().equals(staffID)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean dateIdentify(){
		Date today = new Date();
		String[] info = new String[10];
		info = today.toString().split(" ");
		if(info[0].equals("Wed") || info[0].equals("Sat")){
			return true;
		}
		else
			return false;
	}
}
