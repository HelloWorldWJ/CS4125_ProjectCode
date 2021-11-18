package Vehicle;

import java.awt.Point;

import Map.Lane;
import Map.Road;

public class VehicleFactory {
	
//	public static enum VehicleType
//	{
//		Fastcar,
//		Slowcar,
//		Mediumcar
//	};
	
	public Vehicle createVehicle(double length, double width, double speed, double angle, Point xy, Road road, Lane track, String imagePath) {
		return new Vehicle(length, width, speed, angle, xy, road, track, imagePath);
	}

}
