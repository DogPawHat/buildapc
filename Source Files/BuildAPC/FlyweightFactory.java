package BuildAPC;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FlyweightFactory
{
   private ArrayList<PC_Component> Existing_components;
   IFactory _factory;
   
   public FlyweightFactory(IFactory factory) 
   {
		System.out.println("Instantiating FlyweightFactory");
		Existing_components = ComponentFactory.createChildrenList();
		_factory = factory;
		readFile();
   }
   
	public PC_Component getFlyweight(String key)
	{
		System.out.println("Executing FlyweightFactory.getFlyweight(String)");
		int FlyweightRequested = Component_exists(key);
		if(FlyweightRequested == Existing_components.size())//if key wasn't found in Component_exists()
		{
			Existing_components.add(ComponentFactory.createProduct(key, 0.0)); //get the factory to create the object and add it to the list
		}
		else if(key.substring(0,2).compareToIgnoreCase("C_") == 0 && FlyweightRequested != Existing_components.size())
		{
			Existing_components.add(ComponentFactory.createProduct(key, (Existing_components.get(FlyweightRequested)).getBaseCost()));
			FlyweightRequested = Existing_components.size()-1;
		}   
		return Existing_components.get(FlyweightRequested);
	}
   
   public int Component_exists(String key)
   {
		System.out.println("Executing FlyweightFactory.Component_exists(String)");
       for(int i=0; i<Existing_components.size(); i++)
       {
           if((Existing_components.get(i)).getName().equals(key))
               return i;
       }
       return Existing_components.size();
   }
   
   public int ComponentListSize()
   {
		System.out.println("Executing FlyweightFactory.ComponentListSize()");
        return Existing_components.size();
   }
   
   private void readFile()
   {
		System.out.println("Executing FlyweightFactory.readFile()");
		try{
			BufferedReader CSVFile = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/ComponentList.csv"));
			
			
			String dataRow = CSVFile.readLine(); // Read first line.
			
			while (dataRow != null)
			{
				String[] dataArray = dataRow.split(",");
				if(Component_exists(dataArray[0]) == ComponentListSize())
					Existing_components.add(ComponentFactory.createProduct(dataArray[0],Double.parseDouble(dataArray[1])));
				dataRow = CSVFile.readLine(); // Read next line of data.
			}
			// Close the file once all data has been read.
			CSVFile.close();
		}
		catch(IOException e)
		{
			System.out.println("Read/Write Error. Exiting...");
			System.exit(0);
		}
}
   
}
