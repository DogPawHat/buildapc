package BuildAPC;
import java.util.ArrayList;
public class PC_Container extends PC_Component
{
	protected ArrayList<PC_Component> children;
	
	public PC_Container(String name)
	{
		super(name);
		System.out.println("Instantiating PC_Container(String)");
		children = ComponentFactory.createChildrenList();
	}
	
	public PC_Container(String name, double cost)
	{
		super(name, cost);
		System.out.println("Instantiating PC_Container(String,double)");
		children = ComponentFactory.createChildrenList();
	}
	
	public PC_Component getChild(int i)
	{
		System.out.println("Instantiating PC_Container.getChild(int)");
		if(i<children.size())
		{
			return children.get(i);
		}
		else
		{
			return null;
		}
	}
	
	public double getCost()
	{
		System.out.println("Instantiating PC_Container.getCost()");
		double runningTotalCost = this._cost;
		for(PC_Component p : children)
		{
			runningTotalCost += p.getCost();
		}
		return runningTotalCost;
	}
	
	public void addComponent(PC_Component p)
	{
		System.out.println("Instantiating PC_Container.addComponent(PC_Component)");
		if(p!=this)
		{
			children.add(p);
		}
	}
	
	public void removeComponent(PC_Component p)
	{
		System.out.println("Instantiating PC_Container.removeComponent(PC_Component)");
		children.remove(p);
	}
	
	public String toString()
	{
		System.out.println("Instantiating PC_Container.toString()");
		StringBuilder accumulatedToString = new StringBuilder(super.toString());
		
		for(PC_Component p : children)
		{
			accumulatedToString.append(p.toString());
		}
		
		return accumulatedToString.toString();
	}
	
	public double getBaseCost()
	{
		System.out.println("Instantiating PC_Container.getBaseCost()");
		return super.getCost();
	}
}
