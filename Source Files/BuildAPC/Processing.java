package BuildAPC;


/**
 * @author Ciaran Curley
 * 
 */
public class Processing extends State {
	public Processing() {
		System.out.println("Instantiating Processing()");
		state = "processing";
		status = "Order Processing";
		nextState = new PCBuilding();
	}

}
