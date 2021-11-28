 package Driver;


import Vehicle.Vehicle;

public class DriverFactory 
{
	public enum DriverTemper{
		NORMAL,
		IMPATIENTLY,
		IRRITABLY
	}
	public Driver createDriver(DriverTemper temper, Vehicle vehicle, String name) 
	{
		switch(temper) {
		case NORMAL:{
			return new NormalDriver(name,vehicle);
		}
		case IMPATIENTLY:{
			return new ImpatientlyDriver(name,vehicle);
		}
		case IRRITABLY:{
			return new IrritableDriver(name,vehicle);
		}
		}
		return null;
	}
	                           
}

