import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Account {
	protected String userName = new String();
	protected String userAddress = new String();
	protected int userAge;
	protected String PIN = new String();
	protected String accountNo = new String();
	protected int money;
	protected int checkmoney;
	protected boolean isSuspend;
	
	public void storeAccount(Account a){
	  /*
	  ArrayList<String> content = new ArrayList<String>();
	  content.add(a.PIN);
	  content.add(a.isSuspend+"");
	  content.add(a.userName);
	  content.add(a.userAddress);
	  content.add(a.userAge+"");
	  content.add(a.money+"");
	  content.add(a.checkmoney+"");
	  */
	  String newLine = a.PIN + " " +a.isSuspend+" "+a.userName + " " + a.userAddress + " " + a.userAge+" "+a.money+""+" "+a.checkmoney+"";
	  String fileName = new String();
	  fileName =  a.accountNo+".dat";
	  File file = new File(fileName);
	  BufferedWriter buff;
	  try {
			buff = new BufferedWriter(new FileWriter(file));
			buff.append(newLine);
			buff.flush();
			/*
			for(int i=0;i<content.size();i++){
				buff.write(content.get(i), 0, content.get(i).length());
			}
			*/
			buff.close();
	  } catch (IOException e) {
			// TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	  /*
	  fileName =  a.PIN+".dat";
	  int money = a.money;
	  file = new File(fileName);
	  try {
			buff = new BufferedWriter(new FileWriter(file));
			buff.write(""+money);
			buff.close();
	  } catch (IOException e) {
			// TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	  */
	  /*
	  FileWriter fw = null;
	  BufferedWriter bw = null;
	  try {
		  String fileName = new String();
		  fileName =  a.accountNo+".dat";
		  fw = new FileWriter(fileName,true);
		  bw = new BufferedWriter(fw);
		  bw.append(newLine);
		  bw.flush();
		  bw.newLine();
		  System.out.println("Success!");
	  } catch (IOException e2) {
		  e2.printStackTrace();
	  } finally{
		  try {
			bw.close();
		  } catch (IOException e3) {
			e3.printStackTrace();
		  }
	  }
	  */
	}
	/*
	public void updateAccount(Account a){
		String newLine = a.PIN + " " +a.userName + " " + a.userAddress + " " + a.userAge+" "+a.isSuspend;
		  String fileName = new String();
		  fileName =  a.accountNo+".dat";
		  File file = new File(fileName);
		  BufferedWriter buff;
		  try {
				buff = new BufferedWriter(new FileWriter(file));
				buff.write(newLine, 0, newLine.length());
				buff.close();
		  } catch (IOException e) {
				// TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		  fileName =  a.PIN+".dat";
		  int money = a.money;
		  file = new File(fileName);
		  try {
				buff = new BufferedWriter(new FileWriter(file));
				buff.write(""+money);
				buff.close();
		  } catch (IOException e) {
				// TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		
	}
	 */
}
