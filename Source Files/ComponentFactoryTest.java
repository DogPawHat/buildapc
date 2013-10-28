import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import BuildAPC.*;

/**
 * The test class FactoryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ComponentFactoryTest
{
    /**
     * Default constructor for test class FactoryTest
     */
    private IFactory test;
    public ComponentFactoryTest()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        test = new ComponentFactory();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        test = null;
    }
    
    @Test
    public void testManufactureDefault()
    {
        assertNotNull(test.createProduct());
    }
    
    @Test
    public void testManufacturePart()
    {
        PC_Component t1 = ComponentFactory.createProduct("P_test",0.0);
        assertTrue(t1 instanceof PC_Part);
    }
    
    @Test
    public void testManufactureContainer()
    {
        PC_Component t2 = ComponentFactory.createProduct("C_test",0.0);
        assertTrue(t2 instanceof PC_Container);
    }
    
    @Test
    public void testChildrenList()
    {
        assertNotNull(ComponentFactory.createChildrenList());
    }
}
