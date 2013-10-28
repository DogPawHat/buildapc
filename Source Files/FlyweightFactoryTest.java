import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import BuildAPC.*;

/**
 * The test class FlyweightFactoryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FlyweightFactoryTest
{
    private FlyweightFactory test;
    /**
     * Default constructor for test class FlyweightFactoryTest
     */
    public FlyweightFactoryTest()
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
        test = new FlyweightFactory(new ComponentFactory());
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
    public void FlyweightCreationTest()
    {
        assertEquals(test.Component_exists("test"), test.ComponentListSize());//Confirm that it is empty
        assertNotNull(test.getFlyweight("test"));//the ability to return an item from the list implies that the factory creation is working
    }
    
    @Test
    public void FlyweightRetrievalTest()
    {
        int size = test.ComponentListSize();
        test.getFlyweight("test0");
        test.getFlyweight("test1");
        test.getFlyweight("test2");
        test.getFlyweight("test1");
        assertEquals(test.ComponentListSize(), size+3);//A size increase of 3 instead of 4 implies that the FLyweight Factory could retrieve the fourth item without creating a new one
    }
}
