package Driver;
import Thread.Threadprocess;
import Vehicle.Vehicle;

public class Driver implements Runnable{
	
	private String name;
    protected Vehicle vehicle;
    protected String driverTemperType;

	public Driver(String name, Vehicle vehicle, String driverTemperType)//the constructor of class driver
	{
		this.name = name;
		this.vehicle = vehicle;
		this.driverTemperType = driverTemperType;
		
	}
	public String getName()// return the name
	{
		return this.name;
	}
	
	public Vehicle getVehilce()// return the object driver
	{
		return this.vehicle;
	}
	
	public void drive()// call the move function in instance vehicle
	{
		//it seems that driver is driving his car
		this.vehicle.move();
	}
	
	@Override
	public void run() {// because it implements the runnable interface so this class should have the function below that is associated with threads
		// every driver is a thread 
		Threadprocess t = new Threadprocess(Threadprocess.DEFAULT_FRAMERATE);
		t.setMessage("Driver");
		while(true)
		{
			t.start();
			this.drive();
			t.end();
		}
		
		
	}
	
	public String getDriverTemperType() {// return the driverTemperTpe
		return this.driverTemperType;
	}
	
	public void pri() {
		
	}
	
	public void Drive() {
		
	}


}
