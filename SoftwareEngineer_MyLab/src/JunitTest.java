import static org.junit.Assert.*;

import org.junit.Test;


public class JunitTest {

	@Test
	public void test() {
		SavingAccount sa = new SavingAccount();
		BankControlSystem control = new BankControlSystem();
		control.withdraw(sa,500);
	}

}
