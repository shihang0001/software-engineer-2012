
public class JuniorAccount extends Account{
	
	public JuniorAccount(){
		
	}
	public JuniorAccount(String name, String address, int age, String pin, String accountNo, boolean isSuspend,int money){
		this.userName = name;
		this.userAddress = address;
		this.userAge = age;
		this.PIN = pin;
		this.accountNo = accountNo;
		this.isSuspend = isSuspend;
		this.money = money;
	}
	
	public JuniorAccount(String name, String address, int age, String pin, String accountNo, boolean isSuspend,int money, int checkmoney) {
		this.userName = name;
		this.userAddress = address;
		this.userAge = age;
		this.PIN = pin;
		this.accountNo = accountNo;
		this.isSuspend = isSuspend;
		this.money = money;
		this.checkmoney = checkmoney;
		// TODO Auto-generated constructor stub
	}
	
	

}
