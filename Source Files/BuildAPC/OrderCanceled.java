/**
 * @author Ciaran Curley
 * 
 */

package BuildAPC;

public class OrderCanceled extends State {
	public OrderCanceled(){
		System.out.println("Instantiating OrderCanceled()");
		state = "canceled";
		status = "Order Canceled";
	}
}
