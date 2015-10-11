
import java.io.Serializable;
import java.util.ArrayList;


public class Staff implements Serializable{

	protected String staffID;
	protected String carID;
	protected double totalFee;
	public ArrayList<Ticket> staffticket =new ArrayList<Ticket>();
	public Staff(String staffID,String carID){
		this.staffID=staffID;
		this.carID=carID;
		this.totalFee=0;
	}
	
	public String getStaffID(){
		return staffID;
	}
	
	public String getCarID(){
		return carID;
	}
	
	public double getTotalFee(){
		return totalFee;
	}
	
	public void setTotalFee(double totalFee){
		this.totalFee=totalFee;
	}

}
