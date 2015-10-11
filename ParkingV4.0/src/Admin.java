
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Admin {
	public static ArrayList<Staff> staffList =new ArrayList<Staff>();
	public static String pin="admin";
	
	public String getPin(){
		return pin;
	}
		
	public void addPaper(int num){
		Parking_Control.setPaper(Parking_Control.getPaper()+num);
	}
	
	public void addPenny_50(int num){
		Parking_Control.setPenny_50(Parking_Control.getPenny_50()+num);
	}
	
	public void addPound_1(int num){
		Parking_Control.setPound_1(Parking_Control.getPound_1()+num);
	}
	
	public void addPound_2(int num){
		Parking_Control.setPound_2(Parking_Control.getPound_2()+num);
	}
	
	public void addStaff(String staffID,String carID){  
		Admin.staffList.add(new Staff(staffID,carID));
	}
	
	public void clearMoney(){
		
		double money;
		money=Parking_Control.getPenny_50()*0.5+Parking_Control.getPound_1()+Parking_Control.getPound_2()*2;
		Parking_Control.setPenny_50(0);
		Parking_Control.setPound_1(0);
		Parking_Control.setPound_2(0);
		System.out.println("Total money :"+ money);
	}
	
	public void storeinfo(){
		System.out.println("Successfully stored");
		Parking_Control.writeToFile(Parking_Control.getPaper(), Parking_Control.getPenny_50(), Parking_Control.getPound_1(), Parking_Control.getPound_2(),Ticket.num);
	}
	
	public void sendBill(String staffID){
		for(Staff s:Admin.staffList){
			if(staffID.equals(s.getStaffID())){
				try{
					FileWriter writer= new FileWriter(staffID+".txt");
	//				writer.write("11");
					writer.write("Total fee  "+s.getTotalFee());
					writer.write("\r\n");
					for(Ticket t:s.staffticket){
						writer.write(t.getCarID()+" "+t.getEnterTime()+" "+t.getOutTime()+" "+t.getFee()
								);
						writer.write("\r\n");	
					}
					writer.flush();
					writer.close();
					
					
					
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void printReport(){
		try{
			FileWriter writer= new FileWriter("Report.txt");
//				writer.write("11");
			
			//writer.write("\r\n");
			for(Ticket t:Parking_Control.ticketList){
				writer.write(t.getTicketID()+" "+t.getStaffType()+" "+t.getCarID()+" "+t.getEnterTime()+" "+t.getOutTime()+" "+t.getFee()
						);
				writer.write("\r\n");	
			}
			writer.flush();
			writer.close();
			
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
