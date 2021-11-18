package Driver;
import Vehicle.Vehicle;

public class Driver {
	
	private String name;
    private  Vehicle vehicle;
	
	

	public Driver(String name, Vehicle vehicle)
	{
		this.name = name;
		this.vehicle = vehicle;
		
	}
	public String getName()
	{
		return this.name;
	}
	public Vehicle getVehilce()
	{
		return this.vehicle;
	}
	
	

}
