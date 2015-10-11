

import static org.junit.Assert.*;

import org.junit.Test;


public class PayStationTest {

	@Test
	public void test() {
		new EntranceTest().test();
		assertEquals(3,Parking_Control.ticketList.size());
		assertEquals(-1,PayStation.identify(2, "A12"));
		int a =PayStation.identify(1, "A12");
		assertEquals(0,a);
		int b =PayStation.identify(2, "AB12");
		assertEquals(1,b);
		
		Ticket t1=Parking_Control.ticketList.get(0);
		
		double fee=PayStation.calculateFee(t1.getEnterTime(), t1.getOutTime());
		assertEquals(0.5,fee,0.1);		
		//assertEquals("Success",PayStation.receiveMoney(0, 0, 0, a));
		assertEquals(false,Parking_Control.ticketList.get(0).getIsPay());
		assertEquals("Success",PayStation.receiveMoney(1, 0, 0, a));
		assertEquals(true,Parking_Control.ticketList.get(0).getIsPay());
		assertEquals(101,Parking_Control.getPenny_50());
		
		
		
		
		
		
	}

}
