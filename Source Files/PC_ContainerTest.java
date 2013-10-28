import org.junit.*;
import static org.junit.Assert.*;
import BuildAPC.*;

public class PC_ContainerTest
{
	private PC_Component test0;
	
	@Before
	public void prepareTest()
	{
		test0=new PC_Container("test0");
	}
	
	@After
	public void wipe()
	{
		test0=null;
	}
	
	@Test
	public void testEmptyContainerCost()
	{
		assertTrue(0.1==test0.getCost());
		assertNull(test0.getChild(0));
	}
	
	@Test
	public void testEmptyContainerNullChild()
	{
		assertNull(test0.getChild(0));
		test0.addComponent(new PC_Container("test1"));
		assertNotNull(test0.getChild(0));
		assertNull(test0.getChild(1));
	}
	
	@Test
	public void testChildrenCost()
	{
		//test0(test1(test2),test3)
		PC_Component test1 = new PC_Container("test1");
		test1.addComponent(new PC_Part("test2"));
		test0.addComponent(test1);
		test0.addComponent(new PC_Part("test3"));
		assertEquals(0.4,test0.getCost(),4);
		//test0(test1,test3,test1) //test1(test2)
		test0.addComponent(test1);
		assertEquals(0.6,test0.getCost(),4);
	}
	
	@Test
	public void testChildren()
	{
		PC_Component test1=new PC_Part("test1");
		test0.addComponent(test1);
		
		assertSame(test0.getChild(0),test1);
	}
	
	@Test
	public void testRemoveChild()
	{
		PC_Component test1=new PC_Part("test1");
		test0.addComponent(test1);
		assertNotNull(test0.getChild(0));
		test0.removeComponent(test1);
		assertNull(test0.getChild(0));
	}
	
	@Test
	public void testToString()
	{
		assertTrue((test0.toString()).equals("test0"+System.getProperty("line.separator")));
		assertTrue((test0.getName()).equals("test0"));
		
		test0.addComponent(new PC_Part("test1"));
		
		
		assertTrue((test0.toString()).equals("test0"+System.getProperty("line.separator")+"test1"+System.getProperty("line.separator")));
	}
}
