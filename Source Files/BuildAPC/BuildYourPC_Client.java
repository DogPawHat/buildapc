package BuildAPC;

public class BuildYourPC_Client
{
	IFactory _factory;
	FlyweightFactory _fwFactory;
	Builder _assembler;
	
	/**
	Instantiates the factories and builder
	*/
	public BuildYourPC_Client()
	{
		System.out.println("instantiating BuildYourPC_Client()");
		_factory = new ComponentFactory();
		_fwFactory = new FlyweightFactory(_factory);
		_assembler = new PC_Builder(_fwFactory);
	}
    
    /**
	Gets the builder to build a high range pc
	*/
    public PC_Component getHighRange()
    {
		System.out.println("Executing BuildYourPC_Client.getHighRange()");
    	return _assembler.buildHighRangePC();
    }
    
    /**
	Gets the builder to build a mid range pc
	*/
    public PC_Component getMidRange()
    {
		System.out.println("Executing BuildYourPC_Client.getMidRange()");
    	return _assembler.buildMidRangePC();
    }
    
    /**
	Gets the builder to build a low range pc
	*/
    public PC_Component getLowRange()
    {
		System.out.println("Executing BuildYourPC_Client.getLowRange()");
    	return _assembler.buildLowRangePC();
    }
}
