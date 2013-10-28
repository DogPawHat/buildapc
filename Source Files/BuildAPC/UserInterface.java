package BuildAPC;

import java.util.Scanner;

public class UserInterface
{
	private static BusinessLogic _logic;
	
	/**
	Presents the prompt to the user to select whether to build a pc or check an order
	@param input The scanner object that has advanced a set number of tokens already
	*/
	public static void main(String[] args)
	{
		_logic=new BusinessLogic();
		Scanner input = new Scanner(System.in);
		boolean running = true;
		
		System.out.println("Hello and welcome to Build A PC!");
		while(running)
		{
			System.out.println("What would you like to do?"+System.getProperty("line.separator")+"B) Build A PC\tC) Check the status of an order\tQ) Quit");
			String line = input.nextLine();
			switch(Character.toUpperCase(line.charAt(0)))
			{
				case 'B':
					//buildPC(input);//dummied out from dummy out of building from components up
					preBuilt(input);
					break;
				case 'C':
					checkOrderStatus(input);
					break;
				case 'Q':
					running = false;
					break;
				default:
					break;
			}
		}
		System.out.println("Goodbye!");
	}
	
	/**
	Never called due to the removal of the functionality of creating a pc from constituent components. Retained for posterity
	@param input The scanner object that has advanced a set number of tokens already
	*/
	private static void buildPC(Scanner input) //never reached due to dummy out of constructing from components
	{
		boolean running = true;
		while(running)
		{
			System.out.println("Would you like to construct a pc from its components or choose a pre-built model?" + System.getProperty("line.separator") + "B) Pre-Built\tC) Construct from Components\tR) Return to Main Menu");
			String line = input.nextLine();
			switch(Character.toUpperCase(line.charAt(0)))
			{
				case 'B':
					preBuilt(input);
					running = false;
					break;
				case 'C':
					listBuild(input);
					running = false;
					break;
				case 'R':
					running = false;
					break;
				default:
					break;
			}
		}
	}
	
	/**
	Presents the prompt to the user to select which type of pre-built pc they would like
	@param input The scanner object that has advanced a set number of tokens already
	*/
	private static void preBuilt(Scanner input)
	{
		PC_Component pc = null;
		boolean running = true;
		prompt:
		while(running)
		{
			System.out.println("We have 3 different pre-built PCs to look at, low-, mid-, and high-range. Which would you like to see?" + System.getProperty("line.separator") + "L) Low-range\tM) Mid-range\tH) High-range\tR) Return to Main Menu");
			
			String line = input.nextLine();
			
			switch(Character.toUpperCase(line.charAt(0)))
			{
				case 'L':
					System.out.println("You have selected Low-Range");
					pc=_logic.getLowRange();
					break;
				case 'M':
					System.out.println("You have selected Mid-Range");
					pc=_logic.getMidRange();
					break;
				case 'H':
					System.out.println("You have selected High-Range");
					pc=_logic.getHighRange();
					break;
				case 'R':
					running = false;
					break prompt;
				default:
					continue prompt;
			}
			
			System.out.println("This PC has a cost of: "+pc.getCost()+System.getProperty("line.separator")+"The components contained within are listed as follows:");
			System.out.println(pc.toString());
			
			if(confirmPreBuiltPrompt(input))
			{
				System.out.println("Thank you for your confirmation!"+System.getProperty("line.separator")+"The order will now be placed");
				placeOrder(pc,input);
				running = false;
			}
		}
	}
	
	/**
	Presents the prompt to the user to confirm the type of pre-built pc they have selected
	@param input The scanner object that has advanced a set number of tokens already
	*/
	private static boolean confirmPreBuiltPrompt(Scanner input)
	{
		boolean running = true, confirm = false;
		prompt:
		while(running)
		{
			System.out.println("Would you like to order this pc?" + System.getProperty("line.separator") + "Y) Yes\tN) No\t");
			
			String line = input.nextLine();
			
			switch(Character.toUpperCase(line.charAt(0)))
			{
				case 'Y':
					confirm=true;
					running=false;
					break;
				case 'N':
					running=false;
					break;
				default:
					continue prompt;
			}
		}
		return confirm;
	}
	
	/**
	Presents the prompt to the user to input their details to place the order
	@param input The scanner object that has advanced a set number of tokens already
	*/
	private static void placeOrder(PC_Component pc, Scanner input)
	{
		String name="", address="";
		boolean running = true;
		prompt:
		while(running)
		{
			System.out.println("Please enter your full name (max. 32 characters):");
			String line = input.nextLine();
			if(line == null) continue prompt;
			if(line.length()==0) continue prompt;
			if(line.length()>32) line = line.substring(0,32);
			name=line;
			
			System.out.println("Please enter the address you would like it to be shipped to (max. 128 characters):");
			line = input.nextLine();
			if(line == null) continue prompt;
			if(line.length()==0) continue prompt;
			if(line.length()>128) line = line.substring(0,128);
			address=line;
			line = _logic.placeOrder(pc, name, address);
			if(line==null)
			{
				System.out.println("Order Placing failed for some reason. R) Return !R) Try Again");
				line=input.nextLine();
				if(line==null) continue prompt;
				if(line.length()==0) continue prompt;
				if(Character.toUpperCase(line.charAt(0))=='R') break prompt;
			}
			
			System.out.println("Order Placed!"+System.getProperty("line.separator")+"Your reference number is: "+line+System.getProperty("line.separator")+"Please record this for further use");
			running = false;
		}
	}
	
	private static void listBuild(Scanner input)
	{
		
	}
	
	/**
	Presents the prompt to the user to input their reference number and shows them the status of the order should the reference be valid
	@param input The scanner object that has advanced a set number of tokens already
	*/
	private static void checkOrderStatus(Scanner input)
	{
		boolean running = true;
		prompt:
		while(running)
		{
			System.out.println("Please enter your reference number (or R to return):");
			String ref = input.nextLine();
			if(Character.toUpperCase(ref.charAt(0))=='R')
			{
				break prompt;
			}
			if(ref.length()>32) ref = ref.substring(0,32);
			String name, address, compList, state;
			double cost;
			name = _logic.getOrderName(ref);
			address = _logic.getOrderAddress(ref);
			compList = _logic.getOrderPCComponentList(ref);
			cost = _logic.getOrderPCCost(ref);
			state = _logic.getOrderStateByReference(ref);
			if(name==null||address==null||compList==null||state==null||cost==0.0)
			{
				System.out.println("There was a problem retrieving your order, please try again");
				continue prompt;
			}
			System.out.println("Order Reference: " + ref + System.getProperty("line.separator") + "Order State: " + state + System.getProperty("line.separator") + "Customer Name: " + name + System.getProperty("line.separator") + "Shipping Address: " + address +System.getProperty("line.separator") + "PC Cost: " + cost + System.getProperty("line.separator") + "Constituent Components:" + System.getProperty("line.separator") + compList);
			boolean penalty = false;
			switch(state)
			{
				case "canceled":
					System.out.println("The order is already cancelled");
				case "shipped":
					System.out.println("The order cannot now be cancelled");
					break prompt;
				case "built": 
					System.out.println("The order can be cancelled at this point at a cost of service of 5");
					penalty = true;
					break;
				default:
					break;
			}
			
			if(cancelOrderPrompt(input))
			{
				if(_logic.cancelOrderByReference(ref))
				{
					System.out.println("Your order has successfully been cancelled");
					if(penalty)
					{
						System.out.println("The penalty of 5 was applied for cancelling after the build of the PC");
					}
					break prompt;
				}
				System.out.println("Your order was not cancelled, please try again");
				continue prompt;
			}
			running = false;
		}
	}
	
	/**
	Presents the prompt to the user to decide whether to cancel the order
	@param input The scanner object that has advanced a set number of tokens already
	*/
	private static boolean cancelOrderPrompt(Scanner input)
	{
		boolean running = true, result = false;
		prompt:
		while(running)
		{
			System.out.println("Would you like to cancel your order?");
			String line = input.nextLine();
			switch(Character.toUpperCase(line.charAt(0)))
			{
				case 'Y':
					running = false;
					result = true;
					break;
				case 'N':
					running = false;
					result = false;
					break;
				default:
					break;
			}
		}
		return result;
	}
}
