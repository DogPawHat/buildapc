import org.junit.*;
import static org.junit.Assert.*;
import BuildAPC.*;

public class PC_BuilderTest
{
	IFactory factory;
	FlyweightFactory fwFactory;
	Builder builder;
	PC_Component pc;
	
	@Before
	public void instantiate()
	{
		factory = new ComponentFactory();
		fwFactory = new FlyweightFactory(factory);
		builder = new PC_Builder(fwFactory);
		pc = null;
	}
	
	@Test
	public void testHighRange()
	{
		pc = builder.buildHighRangePC();
		assertTrue((pc.toString()).equals("C_case01large"+System.getProperty("line.separator")+"C_bayDrive05"+System.getProperty("line.separator")+"P_driveOptical01bd"+System.getProperty("line.separator")+"P_driveStorage01hdd1024"+System.getProperty("line.separator")+"P_driveStorage04ssd256"+System.getProperty("line.separator")+"C_mobo01PCIE2"+System.getProperty("line.separator")+"P_cpu01quad3.5"+System.getProperty("line.separator")+"P_gpu01gtx690"+System.getProperty("line.separator")+"P_gpu01gtx690"+System.getProperty("line.separator")+"P_ram01mb8192"+System.getProperty("line.separator")+"P_ram01mb8192"+System.getProperty("line.separator")+"P_fanCpu02"+System.getProperty("line.separator")+"P_fanCase01"+System.getProperty("line.separator")+"P_fanCase02"+System.getProperty("line.separator")+"P_fanCase02"+System.getProperty("line.separator")+"P_psu01w600"+System.getProperty("line.separator")+""));
	}
	
	@Test
	public void testMidRange()
	{
		pc = builder.buildMidRangePC();
		assertTrue((pc.toString()).equals("C_case01large"+System.getProperty("line.separator")+"C_bayDrive03"+System.getProperty("line.separator")+"P_driveOptical02dvdrw"+System.getProperty("line.separator")+"P_driveStorage01hdd1024"+System.getProperty("line.separator")+"C_mobo02PCIE1"+System.getProperty("line.separator")+"P_cpu02quad2.8"+System.getProperty("line.separator")+"P_gpu02gtx560Ti"+System.getProperty("line.separator")+"P_ram02mb4096"+System.getProperty("line.separator")+"P_ram02mb4096"+System.getProperty("line.separator")+"P_fanCpu01"+System.getProperty("line.separator")+"P_fanCase01"+System.getProperty("line.separator")+"P_fanCase02"+System.getProperty("line.separator")+"P_psu02w400"+System.getProperty("line.separator")+""));
	}
	
	@Test
	public void testLowRange()
	{
		pc = builder.buildLowRangePC();
		assertTrue((pc.toString()).equals("C_case02mid"+System.getProperty("line.separator")+"C_bayDrive03"+System.getProperty("line.separator")+"P_driveOptical03dvd"+System.getProperty("line.separator")+"P_driveStorage02hdd320"+System.getProperty("line.separator")+"C_mobo02PCIE1"+System.getProperty("line.separator")+"P_cpu03duo3.0"+System.getProperty("line.separator")+"P_gpu03gt540"+System.getProperty("line.separator")+"P_ram03mb2048"+System.getProperty("line.separator")+"P_ram03mb2048"+System.getProperty("line.separator")+"P_fanCpu01"+System.getProperty("line.separator")+"P_fanCase01"+System.getProperty("line.separator")+"P_fanCase02"+System.getProperty("line.separator")+"P_psu03w350"+System.getProperty("line.separator")+""));
	}
}
