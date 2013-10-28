package BuildAPC;
import java.util.ArrayList;

public class ComponentFactory implements IFactory
{
    public IProduct createProduct()
    {
		System.out.println("Executing ComponentFactory.createProduct()");
        return createProduct("P_default",0.0);
    }

    public static PC_Component createProduct(String key, double cost)
    {
		System.out.println("Executing ComponentFactory.createProduct(String, double) [static]");
        if(key.substring(0,2).compareToIgnoreCase("C_") == 0)//checks to see if the component should be a leaf or a container
			return new PC_Container(key,cost);
		
		return new PC_Part(key,cost);
    }
	
	public static ArrayList<PC_Component> createChildrenList()
	{
		System.out.println("Executing ComponentFactory.createChildrenList()");
		return new ArrayList<PC_Component>();
	}
}
