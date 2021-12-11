package Vehicle;

public class V6EngineDecorator extends EngineDecorator{
	
	private double speed;
	private double vehiclelength;
	private double vehiclewidth;
	private String vehiclepath;
	private double acceleration;
	
	public V6EngineDecorator(VehicleType decoratedV) {
		super(decoratedV);
		setAcceleration();
	}

	@Override
	public double getspeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	
	public double getVehicleLength() {
		// TODO Auto-generated method stub
		return vehiclelength;
	}

	
	public double getVehicleWidth() {
		// TODO Auto-generated method stub
		return vehiclewidth;
	}

	
	public String getVehicleImagePath() {
		// TODO Auto-generated method stub
		return vehiclepath;
	}

	public double getacceleration() {
		// TODO Auto-generated method stub
		return this.acceleration;
	}
	
	private void setAcceleration() {
		this.acceleration = 0.01;
	}

}
