/**
 * @author Ciaran Curley
 * 
 */

package BuildAPC;

public class PCSelected extends State {
	public PCSelected(){
		System.out.println("Instantiating PCSelected()");
		state = "selected";
		status = "PC Selected";
		nextState = new Processing();
	}
}
