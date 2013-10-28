/**
 * @author Ciaran Curley
 * 
 */

package BuildAPC;

public abstract class State {
	
	protected String status;
	protected String state;
	protected State nextState;

	public String getStateStatus() {
		System.out.println("Executing State.getStateStatus()");
		return status;
	}
	
	public static State advanceState(State state){
		System.out.println("Executing [static] State.advanceState(State)");
		return state.advanceState();
	}
	
	public State advanceState(){
		System.out.println("Executing State.advanceState()");
		return nextState;
	}
	
	public String getState(){
		System.out.println("Executing State.getState()");
		return state;
	}
}
