package BuildAPC;
public abstract class Builder
{
	protected FlyweightFactory _fwFactory;
	public Builder(FlyweightFactory fwFactory)
	{
		System.out.println("Instantiating Builder(FlyweightFactory)");
		_fwFactory = fwFactory;
	}
	
	public abstract PC_Component buildHighRangePC();
	public abstract PC_Component buildMidRangePC();
	public abstract PC_Component buildLowRangePC();
}
