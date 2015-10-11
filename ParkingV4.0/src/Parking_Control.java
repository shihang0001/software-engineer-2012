
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Parking_Control implements Serializable{
	private static int paper=100; //
	private static int penny_50=100;
	private static int pound_1=100;
	private static int pound_2=100;
	private static int parking_num=30;
	public static ArrayList<Ticket> ticketList =new ArrayList<Ticket>();
	public static Admin a;
	public Parking_Control(){}
	
	public static boolean Adminlogin(String pin){
		if(pin.equals(Admin.pin)){
			a=new Admin();
			return true;
		}
		else {
			System.out.println("Wrong pin");
			return false;
		}
	}

	public static int getPaper() {
		return paper;
	}

	public static void setPaper(int paper) {
		Parking_Control.paper = paper;
	}

	public static int getPenny_50() {
		return penny_50;
	}

	public static void setPenny_50(int penny_50) {
		Parking_Control.penny_50 = penny_50;
	}

	public static int getPound_1() {
		return pound_1;
	}

	public static void setPound_1(int pound_1) {
		Parking_Control.pound_1 = pound_1;
	}

	public static int getPound_2() {
		return pound_2;
	}

	public static void setPound_2(int pound_2) {
		Parking_Control.pound_2 = pound_2;
	}

	public static int getParking_num() {
		return parking_num;
	}

	public static void setParking_num(int parking_num) {
		Parking_Control.parking_num = parking_num;
	}
	
//	public static void updateParkingState(int i){  //
//		if(i==0){//
//			Parking_Control.setParking_num(Parking_Control.getParking_num()-1);
//		}
//		else//
//			Parking_Control.setParking_num(Parking_Control.getParking_num()+1);
//	}
	
	public static double calculateFee(Date enterTime, Date outTime){
		SimpleDateFormat dfs = new SimpleDateFormat("HH:mm:ss");//
		String[] info1 = new String[10];
		info1 = enterTime.toString().split(" ");
		String[] info2 = new String[10];
		info2 = outTime.toString().split(" ");
		System.out.println(info1[3]);
		System.out.println(info2[3]);
		
		try {
			enterTime = dfs.parse(info1[3]);
			outTime = dfs.parse(info2[3]);
			long l = outTime.getTime() - enterTime.getTime();
			long day=l/(24*60*60*1000);
			long hour=(l/(60*60*1000)-day*24);
			long min=((l/(60*1000))-day*24*60-hour*60);
			long s=(l/1000-day*24*60*60-hour*60*60-min*60);
			System.out.println(""+day+"day"+hour+"hour"+min+"minute"+s+"second");
			if(hour<=2){
				return 0.5;
			}
			else if(hour>2 && hour <=4){
				return 1.0;
			}
			else if(hour>4 && hour <=8){
				return 2.0;
			}
			else if(hour>8 && hour <=12){
				return 3.0;
			}
			else
				return 5.0;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		 //
	}
	public static void writeToFile(int paper, int penny_50, int pound_1, int pound_2,int ticketnumber){
		File file = new File("info.dat");
		BufferedWriter buff;
		String[] sequ = new String[6];
		sequ[0]=paper+"";
		sequ[1]=penny_50+"";
		sequ[2]=pound_1+"";
		sequ[3]=pound_2+"";
        sequ[4]=ticketnumber+"";
        sequ[5]=Parking_Control.getParking_num()+"";
        
		try {
			buff = new BufferedWriter(new FileWriter(file));
			for(int i=0; i<6; i++){
				buff.write(sequ[i]+" ");
				//buff.newLine();
			}
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void readFromFile(){
		String text = new String();
		String[] info = new String[6];
		//ArrayList<String> textFromLine = new ArrayList<String>();
		try {
			FileReader fr = new FileReader("info.dat");
			BufferedReader br = new BufferedReader(fr);
			while ((text = br.readLine()) != null) {
				info = text.split(" ");
			}
			//System.out.println(info);
			Parking_Control.paper=Integer.parseInt(info[0]);
			Parking_Control.penny_50=Integer.parseInt(info[1]);
			Parking_Control.pound_1=Integer.parseInt(info[2]);
			Parking_Control.pound_2=Integer.parseInt(info[3]);
			Ticket.num=Integer.parseInt(info[4]);
			Parking_Control.setParking_num(Integer.parseInt(info[5]));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		} 
	}
	

}
