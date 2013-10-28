package BuildAPC;
public class PC_Part extends PC_Component
{
	public PC_Part(String name)
	{
		super(name);
		System.out.println("Instantiating PC_Part(String)");
	}
	
	public PC_Part(String name, double cost)
	{
		super(name, cost);		
		System.out.println("Instantiating PC_Part(String,double)");
	}
}
