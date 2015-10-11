import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Character;
import java.util.ArrayList;
public class BankSystem {

	public static void main(String[] args) throws IOException {
		//CreditAgencyControl control = new CreditAgencyControl();
		
		//System.out.println(control.createCredit("Jason", "600"));
		// TODO Auto-generated method stub
		//SavingAccount sa = new SavingAccount("Jerry", "BUPT", 18, "000001", "100001",false, 500);
		//sa.storeAccount(sa);
		/*
		BankControlSystem control = new BankControlSystem();
		Account loadAccount = new Account();
		loadAccount = control.loadAccountFromFile("100001", "000001");
		*/
		//BankControlSystem control = new BankControlSystem();	
		//System.out.println(control.customerLoginCheck("100001", "000001"));
		//System.out.println(control.readCredit("A"));
		//sa.updateAccount(sa);
		/*
		String lastpin = "01010";
		int i = Integer.parseInt(lastpin);
		System.out.println(i+1);
		*/
		bootSystem();
		//BankControlSystem a = new BankControlSystem();
		//a.deposit(sa, 100, "check");
		/*
		try {
			FileReader fr = new FileReader("100001.dat");
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> accountContent = new ArrayList<String>();
			String[] strArray = new String[6];
			String text = "";
			while((text = br.readLine()) != null){
				System.out.println(text);
				strArray=text.split(" ");
				//System.out.println(strArray);
				//accountContent.add(info);
				//accountContent.add(br.readLine());
			}
			
			for(int i=0;i<strArray.length;i++){
				accountContent.add(strArray[i]);
				System.out.println(accountContent.get(i));
			}
			
			//System.out.println(accountContent.get(0));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
			System.out.println("No such account");
		} catch (IOException e3) {
			e3.printStackTrace();
			System.out.println("Error 2");
		}
*/
	}
	
	private static void bootSystem(){
		MainGUI main = new MainGUI();
		main.create();
	}
}
