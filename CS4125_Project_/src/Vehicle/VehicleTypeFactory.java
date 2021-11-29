package Vehicle;

import java.awt.Point;

import Map.Lane1;


public class VehicleTypeFactory {
	public static enum Vehicle_Type
	{
		Fastcar,
		Slowcar,
		Mediumcar
	};

	public VehicleType createVehicle(Vehicle_Type type) 
	{
			
		switch(type)
		{
		case Fastcar:
			return new Fastcar();
			
		case Slowcar:
			return new Slowcar();
			
		default:
			return null;
		
		}
	}

}
