package Vehicle;

public class Ferrari implements VehicleType{


	private double speed;
	private double vehiclelength;
	private double vehiclewidth;
	private String vehiclepath;
	private String CarName;
	
	public Ferrari()
	{
		this.speed = 1;
		this.vehiclelength = 20;
		this.vehiclewidth = 20;
		this.vehiclepath = "fastcar.png";//
		this.CarName = "Ferrari";
		
	}

	
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


	@Override
	public String getCarName() {
		// TODO Auto-generated method stub
		return CarName;
	}

	


	
}
