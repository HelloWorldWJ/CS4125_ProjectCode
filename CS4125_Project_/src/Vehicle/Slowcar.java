package Vehicle;

public class Slowcar implements VehicleType{

	private double speed;
	private double vehiclelength;
	private double vehiclewidth;
	private String vehiclepath;
	
	public Slowcar()
	{
		this.speed = 0.1;
		this.vehiclelength = 20;
		this.vehiclewidth = 20;
		this.vehiclepath = "slowcar.png";
	}
	@Override
	public double getspeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public double getVehicleLength() {
		// TODO Auto-generated method stub
		return vehiclelength;
	}

	@Override
	public double getVehicleWidth() {
		// TODO Auto-generated method stub
		return vehiclewidth;
	}

	@Override
	public String getVehicleImagePath() {
		// TODO Auto-generated method stub
		return vehiclepath;
	}

}
