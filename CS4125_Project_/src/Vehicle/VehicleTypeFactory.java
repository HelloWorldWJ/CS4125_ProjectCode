package Vehicle;

import java.awt.Point;

import Map.Lane1;


public class VehicleTypeFactory {
	public static enum Vehicle_Type
	{
		Ferrari,
		Benz,
		Mediumcar
	};

	public VehicleType createVehicle(Vehicle_Type type) 
	{
			
		switch(type)
		{
		case Ferrari:
			return new Ferrari();
			
		case Benz:
			return new Benz();
			
		default:
			return null;
		
		}
	}

}
