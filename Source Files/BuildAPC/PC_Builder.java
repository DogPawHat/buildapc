package BuildAPC;
public class PC_Builder extends Builder
{
	public PC_Builder(FlyweightFactory fwFactory)
	{
		super(fwFactory);
		System.out.println("Instantiating PC_builder(FlyweightFactory)");
	}
	
	public PC_Component buildHighRangePC()
	{
		System.out.println("Executing PC_builder.buildHighRangePC()");
		PC_Component pc = _fwFactory.getFlyweight("C_case01large");
		
		PC_Component child = _fwFactory.getFlyweight("C_bayDrive05");
		
		child.addComponent(_fwFactory.getFlyweight("P_driveOptical01bd"));
		child.addComponent(_fwFactory.getFlyweight("P_driveStorage01hdd1024"));
		child.addComponent(_fwFactory.getFlyweight("P_driveStorage04ssd256"));
		
		pc.addComponent(child);
		
		child = _fwFactory.getFlyweight("C_mobo01PCIE2");
		
		child.addComponent(_fwFactory.getFlyweight("P_cpu01quad3.5"));
		child.addComponent(_fwFactory.getFlyweight("P_gpu01gtx690"));
		child.addComponent(_fwFactory.getFlyweight("P_gpu01gtx690"));
		child.addComponent(_fwFactory.getFlyweight("P_ram01mb8192"));
		child.addComponent(_fwFactory.getFlyweight("P_ram01mb8192"));
		child.addComponent(_fwFactory.getFlyweight("P_fanCpu02"));
		
		pc.addComponent(child);
		
		pc.addComponent(_fwFactory.getFlyweight("P_fanCase01"));
		pc.addComponent(_fwFactory.getFlyweight("P_fanCase02"));
		pc.addComponent(_fwFactory.getFlyweight("P_fanCase02"));
		pc.addComponent(_fwFactory.getFlyweight("P_psu01w600"));
		
		return pc;
	}
	
	public PC_Component buildMidRangePC()
	{
		System.out.println("Executing PC_builder.buildMidRangePC()");
		PC_Component pc = _fwFactory.getFlyweight("C_case01large");
		
		PC_Component child = _fwFactory.getFlyweight("C_bayDrive03");
		
		child.addComponent(_fwFactory.getFlyweight("P_driveOptical02dvdrw"));
		child.addComponent(_fwFactory.getFlyweight("P_driveStorage01hdd1024"));
		
		pc.addComponent(child);
		
		child = _fwFactory.getFlyweight("C_mobo02PCIE1");
		
		child.addComponent(_fwFactory.getFlyweight("P_cpu02quad2.8"));
		child.addComponent(_fwFactory.getFlyweight("P_gpu02gtx560Ti"));
		child.addComponent(_fwFactory.getFlyweight("P_ram02mb4096"));
		child.addComponent(_fwFactory.getFlyweight("P_ram02mb4096"));
		child.addComponent(_fwFactory.getFlyweight("P_fanCpu01"));
		
		pc.addComponent(child);
		
		pc.addComponent(_fwFactory.getFlyweight("P_fanCase01"));
		pc.addComponent(_fwFactory.getFlyweight("P_fanCase02"));
		pc.addComponent(_fwFactory.getFlyweight("P_psu02w400"));
		
		return pc;
	}
	
	public PC_Component buildLowRangePC()
	{
		System.out.println("Executing PC_builder.buildLowRangePC()");
		PC_Component pc = _fwFactory.getFlyweight("C_case02mid");
		
		PC_Component child = _fwFactory.getFlyweight("C_bayDrive03");
		
		child.addComponent(_fwFactory.getFlyweight("P_driveOptical03dvd"));
		child.addComponent(_fwFactory.getFlyweight("P_driveStorage02hdd320"));
		
		pc.addComponent(child);
		
		child = _fwFactory.getFlyweight("C_mobo02PCIE1");
		
		child.addComponent(_fwFactory.getFlyweight("P_cpu03duo3.0"));
		child.addComponent(_fwFactory.getFlyweight("P_gpu03gt540"));
		child.addComponent(_fwFactory.getFlyweight("P_ram03mb2048"));
		child.addComponent(_fwFactory.getFlyweight("P_ram03mb2048"));
		child.addComponent(_fwFactory.getFlyweight("P_fanCpu01"));
		
		pc.addComponent(child);
		
		pc.addComponent(_fwFactory.getFlyweight("P_fanCase01"));
		pc.addComponent(_fwFactory.getFlyweight("P_fanCase02"));
		pc.addComponent(_fwFactory.getFlyweight("P_psu03w350"));
		
		return pc;
	}
}
