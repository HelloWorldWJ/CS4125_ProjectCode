package Driver;

import Vehicle.Vehicle;

public class NormalDriver extends Driver{
	
	private double max_limitedSpeed;
	private double min_limitedSpeed;
	private double currentspeed;
	
	private boolean isDecelerate;

	public NormalDriver(String name, Vehicle vehicle) {
		super(name, vehicle);
		this.max_limitedSpeed = 2;
		this.min_limitedSpeed = 1;
		this.Drive();
		
		this.isDecelerate = false;
		// TODO Auto-generated constructor stub
	}
	
	public void Drive() {
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
		System.out.println(vehicle.getCarName() + "--" + vehicle.getSpeed());
	}

}
