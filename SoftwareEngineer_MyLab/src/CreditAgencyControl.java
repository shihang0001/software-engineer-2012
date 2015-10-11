import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CreditAgencyControl {
	public boolean loginCheckForCreditAgency(String userName, String password){
		if(userName.equals("credit") && password.equals("credit")){
			return true;
		}
		else
			return false;
	}
	
	public int createCredit(String name, String credit){
		ArrayList<String> creditName = new ArrayList<String>();
		ArrayList<String> creditNumber = new ArrayList<String>();
		int check = 0;
		String text = new String();
		try {
			FileReader fr = new FileReader("credit.dat");
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
					check =1;
					break;
				}
			}
			if(check==1){
				return 1;
			}
			else{
				creditName.add(name);
				creditNumber.add(credit);
				writeBack(composition(creditName, creditNumber));
				return 0;
			}
			/*
			for(int j=0;j<creditName.size();j++){
				//credit[j] = creditName.get(j)+" "+creditNumber.get(j);
				content.set(j, creditName.get(j)+" "+creditNumber.get(j));
			}
			*/
			//composition(creditName, creditNumber);			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 3;
		}
	}
	
	public String readCredit(String name){
		ArrayList<String> creditName = new ArrayList<String>();
		ArrayList<String> creditNumber = new ArrayList<String>();
		int check = 0;
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
					check = 1;
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
	
	public int setCreditForExistCustomer(String name, String newcredit){
		ArrayList<String> creditName = new ArrayList<String>();
		ArrayList<String> creditNumber = new ArrayList<String>();
		int check = 1;
		//ArrayList<String> creditNew = new ArrayList<String>();
		//Character readName = new Character();
		//String []credit =  new String[100000000];
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
					check = 0;
					creditNumber.set(j, newcredit);
					break;
				}
			}
			if(check == 1){
				return 1;
			}
			else{
				writeBack(composition(creditName, creditNumber));
				return 0;
			}	
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
			return 2;
		} catch (IOException e3) {
			e3.printStackTrace();
			return 3;
		}
	}
	
	public void writeBack(ArrayList<String> value){
		File file = new File("credit.dat");
		System.out.println(value);
		BufferedWriter buff;
		
		try {
			//String content = new String();
			buff = new BufferedWriter(new FileWriter(file));
			//System.out.println(content);
			for(String newLine : value){
				buff.append(newLine);
				buff.flush();
				buff.newLine();
			}	
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<String> composition(ArrayList<String> al1,ArrayList<String> al2){
		ArrayList<String> newal = new ArrayList<String>();
		for(int j=0;j<al1.size();j++){
			System.out.println(al1.get(j));
			System.out.println(al2.get(j));
			//credit[j] = creditName.get(j)+" "+creditNumber.get(j);
			newal.add(al1.get(j)+" "+al2.get(j));
			System.out.println(newal.get(j));
		}
		return newal;
	}
}
