package Driver;

import Vehicle.Vehicle;

public class NormalDriver extends Driver{
	
//	private String DriverTemperType;
	
	private double max_limitedSpeed;
	private double min_limitedSpeed;
	private double currentspeed;
	
	private boolean isDecelerate;
	

	public NormalDriver(String name, Vehicle vehicle, String driverTemperType) {
		super(name, vehicle, driverTemperType);
//		this.DriverTemperType = "Normal";
		this.max_limitedSpeed = 2 * 30;// normal driver always has lower minimum speed
		this.min_limitedSpeed = 1 * 30;// normal driver always has higher maximum speed
		//this.Drive();
		
		this.isDecelerate = false;
		// TODO Auto-generated constructor stub
	}
	
//	public String getDriverTemperType() {
//		return this.DriverTemperType;
//	}
	
	public double getMaxLimitedSpeed() { 
		return this.max_limitedSpeed;//return the maximum of the speed of normal driver
	}
	
	public double getMinLimitedSpeed() {
		return this.min_limitedSpeed;//return the minimum of the speed of normal driver
	}
	
	public void Drive() {//
		//System.out.println("B");
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
	
	public void pri() {
		System.out.println(vehicle.getCarName() + "--" + getDriverTemperType() + "--" + vehicle.getSpeed());
	}

}
