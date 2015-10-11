

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketTest {

	@Test
	public void test() {
		Ticket t1=new Ticket("AB12"); //public type
		Ticket t2=new Ticket("AC12","123456"); //staff type
		
		Parking_Control.ticketList.add(t1);
		Parking_Control.ticketList.add(t2);
		assertEquals(2,Parking_Control.ticketList.size());
		assertEquals("Public",t1.getStaffType());
		assertEquals("Staff",t2.getStaffType());
		assertEquals("123456",t2.getStaffID());
		assertEquals(null,t1.getStaffID());
		assertEquals(1,t1.getTicketID());
		assertEquals(2,t2.getTicketID());
		assertEquals(false,t1.getIsPay());
		assertEquals(false,t2.getIsPay());
		
		
	}

}
