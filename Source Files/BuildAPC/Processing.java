/**
 * @author Ciaran Curley
 * 
 */

package BuildAPC;

public class Processing extends State {
	public Processing() {
		System.out.println("Instantiating Processing()");
		state = "processing";
		status = "Order Processing";
		nextState = new PCBuilding();
	}

}
