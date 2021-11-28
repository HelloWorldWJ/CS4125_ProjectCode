package Driver;
import Thread.Timer;
import Vehicle.Vehicle;

public class Driver implements Runnable{
	
	private String name;
    private  Vehicle vehicle;
    private int speed =1   ;
	
	

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
	public void drive()
	{
		this.vehicle.move(speed);
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
	
	

}
