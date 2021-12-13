package Vehicle;

public class VehicleTypeFactory {
	public static enum Vehicle_Type
	{
		Ferrari,
		Benz,
		Mazda,
		Santana
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
		
		case Santana:
			return new Santana();
			
		default:
			return null;
		
		}
	}

}
