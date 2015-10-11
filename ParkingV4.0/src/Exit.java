
import java.util.Date;


public class Exit extends Parking_Control{
	
	public static int check(int ticketID,String carID){
		for(Ticket t:Parking_Control.ticketList){
			if(t.getTicketID()==ticketID&&t.getCarID().equals(carID)){
				if(t.getStaffType().equals("Public")){
					if(t.getIsPay()){
						System.out.println("Successful Bye");
						
						return 0;
					}
					else {
						System.out.println("No payment ");
						return 1;
					}
				}
				else {
					for(Staff s: Admin.staffList){
						if(s.getStaffID().equals(t.getStaffID())){
							if(t.getIsPay()){
								return 3;
							}
							else{
							t.setIsPay(true);
							t.setOutTime(new Date());
							t.setFee(1);  
							s.staffticket.add(t);
							s.setTotalFee(s.getTotalFee()+t.getFee());
							System.out.println("Successful Bye !");
							Parking_Control.setParking_num(Parking_Control.getParking_num()+1);
							return 0;
							}
						}
					}
					
				}
			}
			
		}
	//	System.out.println("can't find ID");
		return 2;
	}
	
	
	
	
	

}
