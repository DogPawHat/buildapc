package BuildAPCTest;

/**
 * 
 */
import BuildAPC.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ciaran Curley
 *
 */
public class OrderTest {
	private Order testOrder;
	private OrderTracker testOrderTracker;
	private String testOrderStatus[];

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testOrderTracker = new OrderTracker();
		testOrder = testOrderTracker.placeOrder(new PC_Container("blueSky"), "heisenburg", "Walter White", "Los Pollos Hermanos, ABQ");
		testOrderStatus = new String[]{
				"selected",
				"processing",
				"building",
				"built",
				"shipped",
				"canceled"
		};
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		testOrder = null;
	}

	@Test
	public void test() {
		assertTrue(testOrder.getPC().getName() == "blueSky");
		assertTrue(testOrder.getOrderReference() == "heisenburg");
		assertTrue(testOrder.getName() == "Walter White");
		assertTrue(testOrder.getAddress() == "Los Pollos Hermanos, ABQ");
		
		assertTrue(testOrder.getState() == testOrderStatus[0]);
		int i = 1;
		while(testOrder.advanceState() == true){
			assertTrue(testOrder.getState() == testOrderStatus[i]);
			i++;
		}
		
		testOrder.cancelOrder();
		assertTrue(testOrder.getState() == testOrderStatus[i]);
	}

}
