/**
 * @author Ciaran Curley
 * 
 */

package BuildAPC;

import java.util.Vector;

public class Order implements IObservable{
	private String orderReference;
	private PC_Component pc;
	
	private Vector<IObserver> ObserverList;
	private State currentState;
	private String name;
	private String address;
	
	public Order(PC_Component pc, String reference, String name, String address){
		System.out.println("Instantiating Order(PC_Component, String, String, String)");
		ObserverList = new Vector<IObserver>();
		currentState = new PCSelected();
		this.pc = pc;
		orderReference = reference;
		this.setName(name);
		this.setAddress(address);
		//System.out.println("Created order " + orderReference);
	}
	
	public void changeState(State newState){
		System.out.println("Executing Order.changeState(State)");
		currentState = newState;
		notifyObserver();
	}
	
	public double getCost(){
		System.out.println("Executing Order.getCost()");
		return pc.getCost();
	}
	
	public String getStatus(){
		System.out.println("Executing Order.getStatus()");
		return ("Status: " + currentState.getStateStatus());
	}

	@Override
	public void addObserver(IObserver newObserver) {
		System.out.println("Executing Order.addObserver(IObserver)");
		ObserverList.add(newObserver);
	}

	@Override
	public void removeObserver(IObserver oldObserver) {
		System.out.println("Executing Order.removeObserver(IObserver)");
		ObserverList.remove(oldObserver);
		
	}

	@Override
	public void notifyObserver() {
		System.out.println("Executing Order.notifyObserver(IObserver)");
		for(IObserver o: ObserverList){
			o.update(this);
		}
	}
	
	public String getState(){
		System.out.println("Executing Order.getState()");
		return currentState.getState();
	}

	public String getOrderReference() {
		System.out.println("Executing Order.getOrderReference()");
		return orderReference;
	}

	public void setOrderReference(String orderReference) {
		System.out.println("Executing Order.setOrderReference()");
		this.orderReference = orderReference;
	}
	
	public boolean advanceState(){
		System.out.println("Executing Order.advanceState()");
		if(currentState.advanceState() != null){
			changeState(currentState.advanceState());
			return true;
		}
		return false;
	}
	
	public void cancelOrder(){
		System.out.println("Executing Order.cancelOrder()");
		changeState(new OrderCanceled());
	}

	public PC_Component getPC() {
		System.out.println("Executing Order.getPC()");
		return pc;
	}

	public void setPcBuild(PC_Component pcBuild) {
		System.out.println("Executing Order.setPcBuild(PC_Component)");
		this.pc = pcBuild;
		if(currentState.getState() != "selected"){
			changeState(new PCSelected());
		}
	}

	public String getAddress() {
		System.out.println("Executing Order.getAddress()");
		return address;
	}

	public void setAddress(String address) {
		System.out.println("Executing Order.setAddress(String)");
		this.address = address;
	}

	public String getName() {
		System.out.println("Executing Order.getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("Executing Order.setName(String)");
		this.name = name;
	}

}
