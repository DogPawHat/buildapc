/**
 * @author Ciaran Curley
 * 
 */

package BuildAPC;

public class PCBuilding extends State{
    public PCBuilding(){
		System.out.println("Instantiating PCBuilding()");
    	state = "building";
    	status = "Building PC";
    	nextState = new PCBuilt();
    }
}
