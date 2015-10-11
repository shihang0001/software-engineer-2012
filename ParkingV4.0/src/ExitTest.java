

import static org.junit.Assert.*;

import org.junit.Test;

public class ExitTest {

	@Test
	public void test() {
		new PayStationTest().test();
		assertEquals(3,Parking_Control.ticketList.size());
		
		Exit.check(1, "A12");
		assertEquals(0,Exit.check(1, "A12"));
		Parking_Control.setParking_num(Parking_Control.getParking_num()+1);
		assertEquals(0,Exit.check(2, "AB12"));
		
		assertEquals(3,Exit.check(2, "AB12"));
		
		assertEquals(2,Exit.check(4, "AB12"));
		
		assertEquals(1,Exit.check(3, "A123"));
		
		assertEquals(29,Exit.getParking_num());
		
		new Admin().printReport();
	}

}
