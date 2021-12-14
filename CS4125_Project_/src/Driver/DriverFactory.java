package Driver;


import Vehicle.Vehicle;

public class DriverFactory  {
	public enum DriverTemper{
		NORMAL,
		IRRITABLE
	}
	
	public Driver createDriver(DriverTemper temper, Vehicle vehicle, String name, String driverTemperType) {
		switch(temper) {
			case NORMAL:{
				return new NormalDriver(name,vehicle, driverTemperType);
			}
			case IRRITABLE:{
				return new IrritableDriver(name,vehicle, driverTemperType);
			}
		}
		return null;                      
	}
}