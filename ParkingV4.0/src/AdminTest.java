

import static org.junit.Assert.*;
//import Admin;
//import Exit;
//import Parking_Control;

import org.junit.Test;




public class AdminTest {

	@Test
	public void test() {
		Parking_Control.Adminlogin("admin");
		assertEquals("admin" ,Parking_Control.a.getPin());
		assertEquals(30 ,Parking_Control.getParking_num());
		Parking_Control.a.addStaff("123456", "AB12");
		assertEquals(1 ,Admin.staffList.size());
		Parking_Control.a.addPaper(100);
		assertEquals(200 ,Parking_Control.getPaper());
		Parking_Control.a.addPenny_50(100);
		assertEquals(200 ,Parking_Control.getPenny_50());
		Parking_Control.a.addPound_1(100);
		assertEquals(200 ,Parking_Control.getPound_1());
		Parking_Control.a.addPound_2(100);
		assertEquals(200 ,Parking_Control.getPound_2());
	}

}
