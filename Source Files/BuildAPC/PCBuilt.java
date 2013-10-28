/**
 * @author Ciaran Curley
 * 
 */

package BuildAPC;

public class PCBuilt extends State {
	
	public PCBuilt() {
		System.out.println("Instantiating PCBuilt()");
		state = "built";
		status = "PC Built";
		nextState = new OrderShipped();
	}
}
