package Vehicle;

import java.awt.Point;

import Map.Lane1;


public class VehicleTypeFactory {
	public static enum Vehicle_Type
	{
		Ferrari,
		Benz,
		Mazda
	};

	public VehicleType createVehicle(Vehicle_Type type) 
	{
			
		switch(type)
		{
		case Ferrari:
			return new Ferrari();
			
		case Benz:
			return new Benz();
		
		case Mazda:
			return new Mazda();
			
		default:
			return null;
		
		}
	}

}
