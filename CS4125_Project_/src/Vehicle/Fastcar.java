package Vehicle;

public class Fastcar implements VehicleType{


	private double speed;
	private double vehiclelength;
	private double vehiclewidth;
	private String vehiclepath;
	
	public Fastcar()
	{
		this.speed = 1;
		this.vehiclelength = 20;
		this.vehiclewidth = 20;
		this.vehiclepath = "fastcar.png";
		
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

	


	
}
