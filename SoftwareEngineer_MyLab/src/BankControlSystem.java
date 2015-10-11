import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class BankControlSystem {

	/*
	Account a = new Account();
	public BankControlSystem(Account a){
		this.a = a;
	}
	*/
	public void register(Account a){
		a.storeAccount(a);
	}
	
	public int customerLoginCheck(String accountNo, String pin){
		try {
			FileReader fr = new FileReader(accountNo+".dat");
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> accountContent = new ArrayList<String>();
			String[] info = new String[6];
			String text = "";
			while((text = br.readLine()) != null){
				info = text.split(" ");

			}
			
			for(int i=0;i<info.length;i++){
				accountContent.add(info[i]);
			}
			
			//System.out.println(accountContent.get(0));
			if(accountContent.get(0).equals(pin)){
				return 0;
			}
			else
				return 1;//not match
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
			System.out.println("No such account");
			return 2;
		} catch (IOException e3) {
			e3.printStackTrace();
			System.out.println("Error 2");
			return 3;
		}

	}
	/*
	public boolean suspendCheck(String accountNo){
		try {
			FileReader fr = new FileReader(accountNo+".dat");
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> accountContent = new ArrayList<String>();
			String[] info = new String[6];
			String text = "";
			while((text = br.readLine()) != null){
				info = text.split(" ");

			}
			
			for(int i=0;i<info.length;i++){
				accountContent.add(info[i]);
			}
			if(accountContent.get(1).equals("false")){
				return true;
			}
			else 
				return false;
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
			System.out.println("No such account");
			return false;
		} catch (IOException e3) {
			e3.printStackTrace();
			System.out.println("Error 2");
			return false;
		}
	}
	*/
	public void deposit(Account a, int i, String depositType){
		if(depositType.equals("cash")){
			a.money+=i;
			a.storeAccount(a);
		}
		else{
			Date today = new Date();
			String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(today);
	        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
	        if (w < 0){
	            w = 0;
	        }
	        if(weekDays[w].equals("Sunday")){
	        	a.money+=i;
	        	a.storeAccount(a);
	        }
	        else{
	        	a.checkmoney+=i;
	        	a.storeAccount(a);
	        	//作为未到账的存款
	        }
		}
	}
	
	public boolean withdraw(Account a, int i){
		System.out.println(a.getClass());
		if(a.getClass().toString().equals("class SavingAccount")||a.getClass().toString().equals("class JuniorClass")){
			System.out.println(a.money-i);
			if((a.money-i)>=0){
				a.money = a.money-i;
				a.storeAccount(a);
				return true;
				//将money写入文件中
			}
			else{
				return false;
				//提示
			}
		}
		else{
			if((a.money-i)>=-2000){
				a.money = a.money-i;
				a.storeAccount(a);
				return true;
				//将money写入文件中
			}
			else
				return false;
		}
	}
	
	public int suspend(String accountNo, String pin){
		try {
			FileReader fr = new FileReader(accountNo+".dat");
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> accountContent = new ArrayList<String>();
			String[] info = new String[6];
			String text = "";
			while((text = br.readLine()) != null){
				info = text.split(" ");
			}
			
			for(int i=0;i<info.length;i++){
				accountContent.add(info[i]);
			}
			System.out.println(accountContent.get(1));
			if(accountContent.get(0).equals(pin)){
				if(accountContent.get(1).equals("false")){
					System.out.println("here");
					accountContent.set(1, "true");
					System.out.println(accountContent);
					writeBack(accountContent,accountNo);
					return 0;//success
				}
				else{			
					System.out.println("This account has already been suspended");
					return 1;
				}
			}
			else
				return 2;
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
			System.out.println("No such account");
			return 3;
		} catch (IOException e3) {
			e3.printStackTrace();
			System.out.println("Error 2");
			return 4;
		}
	}
	
	public boolean loginCheckForAdmin(String userName, String password){
		if(userName.equals("admin") && password.equals("admin")){
			return true;
		}
		else
			return false;
	}
	
	public int desuspend(String accountNo,String pin){
		try {
			FileReader fr = new FileReader(accountNo+".dat");
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> accountContent = new ArrayList<String>();
			String[] info = new String[6];
			String text = "";
			while((text = br.readLine()) != null){
				info = text.split(" ");

			}
			
			for(int i=0;i<info.length;i++){
				accountContent.add(info[i]);
			}
			if(accountContent.get(0).equals(pin)){
					if(accountContent.get(1).equals("true")){
						accountContent.set(1, "false");
						writeBack(accountContent,accountNo);
					return 0;//success
				}
				else{			
					System.out.println("This account has already been suspended");
					return 1;
				}
			}
			else
				return 2;
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
			System.out.println("No such account");
			return 3;
		} catch (IOException e3) {
			e3.printStackTrace();
			System.out.println("Error 2");
			return 4;
		}
	}
	
	public int deleteAccount(String accNo, String pin){
		try {
			FileReader fr = new FileReader(accNo+".dat");
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> accountContent = new ArrayList<String>();
			String[] info = new String[6];
			String text = "";
			while((text = br.readLine()) != null){
				info = text.split(" ");

			}
			
			for(int i=0;i<info.length;i++){
				accountContent.add(info[i]);
			}
			if(accountContent.get(0).equals(pin)){
				if(Integer.parseInt(accountContent.get(5))!=0 || Integer.parseInt(accountContent.get(5))!=0){
					return 1;//not balance
				}
				else{
					File deleteFile = new File(accNo+".dat");
					if(deleteFile.delete()){
						return 0;//success
					}
					else 
						return 5;//failed to delete
				}
			}
			else
				return 2;//not match
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
			System.out.println("No such account");
			return 3;
		} catch (IOException e3) {
			e3.printStackTrace();
			System.out.println("Error 2");
			return 4;
		}
	}
	
	public String readCredit(String name){
		ArrayList<String> creditName = new ArrayList<String>();
		ArrayList<String> creditNumber = new ArrayList<String>();
		//Character readName = new Character();
		//String credit =  new String();
		String text = new String();
		try {
			FileReader fr = new FileReader("credit"+".dat");
			BufferedReader br = new BufferedReader(fr);
			while ((text = br.readLine()) != null) {
				String[] strArray=text.split(" ");
				for(int i=0;i<strArray.length;i++)
				  {
					if(i==0){
						creditName.add(strArray[i]);
					}
					if(i==1){
						creditNumber.add(strArray[i]);
					}
				  }
			}
			for(int j=0;j<creditName.size();j++){
				if(creditName.get(j).equals(name)){
					text = creditNumber.get(j);
					break;
				}
			}
			return text;
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
			return "error";		
		} catch (IOException e3) {
			e3.printStackTrace();
			return "error";		
		}
	}
	
	public Account loadAccountFromFile(String accNo, String pin){
		String text = new String();
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> accountContent = new ArrayList<String>();
		try {
			fr = new FileReader(accNo+".dat");
			br = new BufferedReader(fr);
			String[] info = new String[6];
			while((text = br.readLine()) != null){
				info = text.split(" ");
			}
			
			for(int i=0;i<info.length;i++){
				accountContent.add(info[i]);
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		} 
		System.out.println(accNo.charAt(0));
		if(accNo.charAt(0)=='1'){
			//SavingAccount sa = new SavingAccount(String name, String address, int age, String pin, String accountNo, boolean isSuspend,int money);
			SavingAccount sa = new SavingAccount(accountContent.get(2),accountContent.get(3),Integer.parseInt(accountContent.get(4)),pin,accNo,Boolean.parseBoolean(accountContent.get(1)),Integer.parseInt(accountContent.get(5)),Integer.parseInt(accountContent.get(6)));
			System.out.print("Saving Account");
			return sa;
		}
		else if(accNo.charAt(0)=='2'){
			CurrentAccount ca = new CurrentAccount(accountContent.get(2),accountContent.get(3),Integer.parseInt(accountContent.get(4)),pin,accNo,Boolean.parseBoolean(accountContent.get(1)),Integer.parseInt(accountContent.get(5)),Integer.parseInt(accountContent.get(6)));
			System.out.print("Current Account");
			return ca;
		}
		else{
			System.out.print("Junior Account");
			JuniorAccount ja = new JuniorAccount(accountContent.get(2),accountContent.get(3),Integer.parseInt(accountContent.get(4)),pin,accNo,Boolean.parseBoolean(accountContent.get(1)),Integer.parseInt(accountContent.get(5)),Integer.parseInt(accountContent.get(6)));
			return ja;
		}
	}
	
	public void writeBack(ArrayList<String> value, String fileName){
		File file = new File(fileName+".dat");
		System.out.println(value);
		BufferedWriter buff;
		
		try {
			String content = new String();
			content = value.get(0)+" "+value.get(1)+" "+value.get(2)+" "+value.get(3)+" "+value.get(4)+" "+value.get(5)+" "+value.get(6)+" ";
			buff = new BufferedWriter(new FileWriter(file));
			System.out.println(content);
			buff.write(content, 0, content.length());
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
