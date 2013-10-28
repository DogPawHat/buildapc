/**
 * @author Ciaran Curley
 * 
 */

package BuildAPC;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class OrderTracker implements IObserver{
	private Vector<Order> trackedOrders;
	private Vector<String> statusChangeUpdate;

	@Override
	public void update(IObservable subject) {
		System.out.println("Executing OrderTracker.update(IObservable)");
		Order order = (Order) subject;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		statusChangeUpdate.add("Order RefenceNo " + order.getOrderReference() + " has changed state to " + order.getState() + " at " + dateFormat.format(date));
	}
	
	public OrderTracker()
	{
		System.out.println("Instantiating OrderTracker()");
		trackedOrders=new Vector<Order>();
		statusChangeUpdate = new Vector<String>();
	}

	public Order placeOrder(PC_Component pc, String reference, String name, String address) {
		System.out.println("Executing OrderTracker.placeOrder(PC_Component, String, String, String)");
		Order order = new Order(pc, reference, name, address);
		order.addObserver(this);
		trackedOrders.add(order);
		return order;
	}
	
	public Order getOrderByReference(String reference){
		System.out.println("Executing OrderTracker.getOrderByReference(String)");
		for(Order o: trackedOrders){
			if(reference.equals(o.getOrderReference())){
				return o;
			}
		}
		return null;
	}
	
	public boolean cancelOrderByReference(String reference){
		System.out.println("Executing OrderTracker.cancelOrderByReference(String)");
		Order order = getOrderByReference(reference);
		if(reference != null){
			order.cancelOrder();
			return true;
		}
		return false;
	}
	
	public PC_Component getPCOrderByReference(String reference){
		System.out.println("Executing OrderTracker.getPCOrderByReference(String)");
		if(reference!=null)
		{	
			Order order = getOrderByReference(reference);
			if(order!=null)
			{
				return order.getPC();
			}
		}
		return null;
	}

	public Vector<String> getStatusChangeUpdate() {
		System.out.println("Executing OrderTracker.getStatusChangeUpdate()");
		return statusChangeUpdate;
	}

	public void setStatusChangeUpdate(Vector<String> statusChangeUpdate) {
		System.out.println("Executing OrderTracker.setStatusChangeUpdate(String)");
		this.statusChangeUpdate = statusChangeUpdate;
	}
}
