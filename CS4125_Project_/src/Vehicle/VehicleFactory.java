package Vehicle;

import java.awt.Point;

import Map.Lane1;


public class VehicleFactory {
	
	public static enum VehicleType
	{
		Fastcar,
		Slowcar,
		Mediumcar
	};
	
	public Vehicle createVehicle(double length, double width, double speed, double angle, Point xy,  Lane1 track, String imagePath,VehicleType type) 
	{
		switch(type)
		{
		case Fastcar:
			return new Fastcar(length,width,speed,angle,xy,track,imagePath);
			
		default:
			return null;
		
		}
	}

}
