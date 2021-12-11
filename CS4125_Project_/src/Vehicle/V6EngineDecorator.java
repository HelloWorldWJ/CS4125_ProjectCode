package Vehicle;

public class V6EngineDecorator extends VehicleEngineDecorator{
	
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
		return super.decoratedVehicleType.getspeed();
	}

	
	public double getVehicleLength() {
		// TODO Auto-generated method stub
		return super.decoratedVehicleType.getVehicleLength();
	}

	
	public double getVehicleWidth() {
		// TODO Auto-generated method stub
		return super.decoratedVehicleType.getVehicleWidth();
	}

	
	public String getVehicleImagePath() {
		// TODO Auto-generated method stub
		return super.decoratedVehicleType.getVehicleImagePath();
	}

	public double getacceleration() {
		// TODO Auto-generated method stub
		return this.acceleration;
	}
	
	private void setAcceleration() {
		this.acceleration = 0.01;
	}

}
