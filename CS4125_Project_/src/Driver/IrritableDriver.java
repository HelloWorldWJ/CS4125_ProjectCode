/**
 * 
 */
package Driver;

import Vehicle.Vehicle;


public class IrritableDriver extends Driver {
	
	private String DriverTemperType;
	
	private double max_limitedSpeed;
	private double min_limitedSpeed;
	private double currentspeed;
	
	private boolean isDecelerate;
		

	public IrritableDriver(String name, Vehicle vehicle) {
		super(name, vehicle);
		this.DriverTemperType = "Irritable";
		this.max_limitedSpeed = 4 * 30;
		this.min_limitedSpeed = 2 * 30;
		//this.Drive();
		
		this.isDecelerate = false;
		// TODO Auto-generated constructor stub
	}
	
	public String getDriverTemperType() {
		return this.DriverTemperType;
	}
	
	public double getMaxLimitedSpeed() {
		return this.max_limitedSpeed;
	}
	
	public double getMinLimitedSpeed() {
		return this.min_limitedSpeed;
	}
	
	public void Drive() {		
		currentspeed = vehicle.getSpeed();
		if(!isDecelerate) {
			super.vehicle.speed_increase();
			if(currentspeed >= max_limitedSpeed)
				isDecelerate = true;
		}
		else if(isDecelerate) {
			super.vehicle.speed_decrease();
			if(currentspeed <= min_limitedSpeed)
				isDecelerate = false;
		}
	}
	
	public void pri() 
	{
		System.out.println(vehicle.getCarName() + "--" + getDriverTemperType() + "--" + vehicle.getSpeed());
	}

}
