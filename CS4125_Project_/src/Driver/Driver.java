package Driver;
import Thread.Timer;
import Vehicle.Vehicle;

public class Driver implements Runnable{
	
	private String name;
    protected Vehicle vehicle;
    protected String driverTemperType;

	public Driver(String name, Vehicle vehicle, String driverTemperType)
	{
		this.name = name;
		this.vehicle = vehicle;
		this.driverTemperType = driverTemperType;
		
	}
	public String getName()
	{
		return this.name;
	}
	public Vehicle getVehilce()
	{
		return this.vehicle;
	}
	public void drive()
	{
		this.vehicle.move();
	}
	
	@Override
	public void run() {
		Timer t = new Timer(Timer.DEFAULT_FRAMERATE);
		t.setMessage("Driver");
		while(true)
		{
			t.start();
			this.drive();
			t.end();
		}
		
		
	}
	
	public String getDriverTemperType() {
		return this.driverTemperType;
	}
	
	public void pri() {
		
	}
	
	public void Drive() {
		
	}


}
