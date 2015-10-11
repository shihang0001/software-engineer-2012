
import java.util.Date;


public class PayStation extends Parking_Control{

	public static int identify(int ticketID, String carID){
		for(Ticket t:Parking_Control.ticketList){
			if(t.getTicketID()==ticketID&&t.getCarID().equals(carID)){
				t.setOutTime(new Date());
				t.setFee(PayStation.calculateFee(t.getEnterTime(), t.getOutTime()));
				return Parking_Control.ticketList.indexOf(t);
			}
		}
		return -1;
	}
	
	public static String receiveMoney(int numberof50, int numberof1, int numberof2,int index){
		double fee=Parking_Control.ticketList.get(index).getFee();
		double sum = 0.5*numberof50+numberof1+2*numberof2;
		if(sum >= fee){
			Parking_Control.setPenny_50(Parking_Control.getPenny_50()+numberof50);
			Parking_Control.setPound_1(Parking_Control.getPound_1()+numberof1);
			Parking_Control.setPound_2(Parking_Control.getPound_2()+numberof2);
			Parking_Control.ticketList.get(index).setIsPay(true);
			System.out.println("Success");
			return "Success";
			
		}
		else{
			return "Not enough, you still have to pay "+Double.toString(fee-sum);
		}
	}
	
	public static void charge(){
		
	}
	
}