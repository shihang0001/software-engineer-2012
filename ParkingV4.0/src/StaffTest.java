
import static org.junit.Assert.*;

import org.junit.Test;




public class StaffTest {

	@Test
	public void test() {
		Admin a =new Admin();
		a.addStaff("123456", "AB12"); //123456ÊÇstaffID AB12ÊÇcarID
		assertEquals(1,Admin.staffList.size());
		Staff b= Admin.staffList.get(0);
		assertEquals("123456",b.getStaffID());
		assertEquals("AB12",b.getCarID());
		a.addStaff("123", "AC12");
		Staff c= Admin.staffList.get(1);
		assertEquals("123",c.getStaffID());
		assertEquals("AC12",c.getCarID());
		Admin.staffList.get(0).staffticket.add(new Ticket("AB12"));
		a.sendBill("123456");
	
	}

}
