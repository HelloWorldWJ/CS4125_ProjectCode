package Vehicle;

import java.awt.Point;

import Map.Lane1;
import Map.Road;

public class VehicleFactory {
	
	public static enum VehicleType
	{
		Fastcar,
		Slowcar,
		Mediumcar
	};
	
	public Vehicle createVehicle(double length, double width, double speed, double angle, Point xy, Road road, Lane1 track, String imagePath,VehicleType type) 
	{
		switch(type)
		{
		case Fastcar:
			return new Fastcar(length,width,speed,angle,xy,road,track,imagePath);
			
		default:
			return null;
		
		}
	}

}
