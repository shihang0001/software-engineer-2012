

import static org.junit.Assert.*;

import org.junit.Test;

public class EntranceTest {

	@Test
	public void test() {
		Admin a =new Admin();
		a.addStaff("123456", "AB12");
		//assertEquals(true,Entrance.dateIdentify());
		Entrance.generateTicketforPublic("A12");
		Entrance.identify("AB12", "123456");
		assertEquals(true,Entrance.identify("AB12", "123456"));
		//assertEquals(true,Entrance.identify("A12", "123456"));
		Entrance.generateTicketforStaff("AB12", "123456");
		Entrance.generateTicketforPublic("A123");
		assertEquals(3,Parking_Control.ticketList.size());
		
		Ticket t1=Parking_Control.ticketList.get(0);
		assertEquals("Public",t1.getStaffType());
		assertEquals(1,t1.getTicketID());
		
		Ticket t2=Parking_Control.ticketList.get(1);
		assertEquals("Staff",t2.getStaffType());
		assertEquals(2,t2.getTicketID());
		assertEquals(98,Parking_Control.getPaper());
		assertEquals(27,Parking_Control.getParking_num());
		
		
		
	}

}
