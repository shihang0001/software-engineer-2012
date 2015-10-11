
import java.io.Serializable;
import java.util.Date;


public class Ticket implements Serializable{
	public static int num=0;
	protected int ticketID;
	protected String staffType;
	protected String staffID;
	protected String carID;
	protected Date enterTime;
	protected Date outTime;
	protected boolean isPay;
	protected double fee;
	
	public Ticket(String carID){  //
//		if(Parking_Control.ticketList.size()==0){
//			this.ticketID=1;
//		}
//		else{
//		for(int i=0;i<=Parking_Control.ticketList.size();i++){
//			num++;
//		}
		num++;
		this.ticketID=num;
		//this.ticketID=
//		}
		this.staffType="Public";
		this.staffID=null;
		this.carID=carID;
		this.enterTime=new Date();
		this.outTime=null;
		this.isPay=false;
		this.fee=0;
	}
	
	public Ticket(String carID , String staffID){  //
		/*
//		if(Parking_Control.ticketList.size()==0){
//			this.ticketID=1;
	}
		else{
		for(int i=0;i<=Parking_Control.ticketList.size();i++){
			num++;
		}
		this.ticketID=num;
		//this.ticketID=
		}
		*/
		num++;
		this.ticketID=num;
		this.staffType="Staff";
		this.staffID=staffID;
		this.carID=carID;
		this.enterTime=new Date();
		this.outTime=null;
		this.isPay=false;
		this.fee=0;
	}
	
	public int getTicketID(){
		return ticketID;
	}
	
	public String getStaffType(){
		return staffType;
	}
	
	public String getStaffID(){
		return staffID;
	}
	
	public String getCarID(){
		return carID;
	}
	
	public Date getEnterTime(){
		return enterTime;
	}
	
	public Date getOutTime(){
		return outTime;
	}
	
	public boolean getIsPay(){
		return isPay;
	}
	
	public double getFee(){
		return fee;
	}
	
	public void setOutTime(Date outTime){
		this.outTime=outTime;
	}
	
	public void setIsPay(boolean isPay){
		this.isPay=isPay;
	}
	
	public void setFee(double fee){
		this.fee=fee;
	}
	
	public String toString(){
		return "";  //
	}

}
