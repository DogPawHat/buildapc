package BuildAPC;
public abstract class PC_Component implements IProduct
{
	protected double _cost;
	protected String _name;
	
	public double getCost() {return _cost;}
	public PC_Component getChild(int i) {return null;}
	public void addComponent(PC_Component p) { }
	public void removeComponent(PC_Component p) { }
	
	public PC_Component(String name)
	{
		System.out.println("Instantiating PC_Component(String)");
		_name = name;
		_cost = 0.1;
	}
	
	public PC_Component(String name, double cost)
	{
		System.out.println("Instantiating PC_Component(String,double)");
		_name = name;
		_cost = cost;
	}
	
	public String toString()
	{
		System.out.println("Executing PC_Component.toString()");
		return getName()+System.getProperty("line.separator");
	}
	
	public String getName()
	{
		System.out.println("Executing PC_Component.getName()");
		return _name;
	}
	
	public double getBaseCost()
	{
		System.out.println("Executing PC_Component.getBaseCost()");
		return getCost();
	}
}
