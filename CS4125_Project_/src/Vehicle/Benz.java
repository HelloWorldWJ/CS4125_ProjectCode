package Vehicle;

public class Benz implements VehicleType{

	private double speed;
	private double vehiclelength;
	private double vehiclewidth;
	private String vehiclepath;
	private String CarName;
	
	public Benz()
	{
		this.speed = 0.5;
		this.vehiclelength = 20;
		this.vehiclewidth = 20;
		this.vehiclepath = "slowcar.png";
		this.CarName = "Benz";
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
	@Override
	public String getCarName() {
		// TODO Auto-generated method stub
		return CarName;
	}
	
}