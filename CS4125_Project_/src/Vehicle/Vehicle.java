package Vehicle;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Map.Lane;
import Map.Road;
import SetElement.SetElement;

public class Vehicle {
	
	public enum Brand{
		Benz,Toyota,Nissan,Audi,Ford
	}
	private double vehicleLength;
	private double vehicleWidth;
	private Lane track;
	private Road road;
	private double speed, angle;
//	private double maxSpeed, currentSpeed, angle;
	private Point position;
	private int current_location_x;
	private int current_location_y;
	private String imagePath;
	
//	private int currentCell, vehicleWidth, vehicleHeight, currentLaneId, vehicleId;
//	private double maxSpeed, currentSpeed, angle;
//	private Lane track;
//	private Road road;
//	private Point position;
//	private Color color;
//	private String imagePath;
//	private I_VehicleState state;
	private BufferedImage carImage;
	
	
	public Vehicle() {
		
	}
	
	
//	void Set_attribute();
//	void Update_attribute(v:Vehicle);
	public Vehicle(double length, double width, double speed, double angle, Point xy, Road road, Lane track, String imagePath) {
//		this.Brand = Brand;
		this.vehicleLength = length;
		this.vehicleWidth = width;
//		this.vehicleWidth = getVehicleWidthRelevantToLaneNum(numLanes);
//		this.vehicleHeight = getVehicleHeightRelevantToLaneNum(numLanes);
		this.speed = speed;
		this.angle = angle;
		this.position = xy;
		this.road = road;
		this.track = track;
//		this.track = road.getLane(currentLaneId);
		this.imagePath = imagePath;
//		this.current_location_x = current_location_x;
//		this.current_location_y = current_location_y;
	}
	
	public Point getPosition(){
		return position;
	}
	
	public double getAngle(){
		return angle;
	}
	
	public Road getRoad(){
		return road;
	}

	public Lane getLane() {
		return track;
	}
	
	public String getVehicleImagePath() {
		return this.imagePath;
	}
	
	public double getVehicleHeight() {
		return vehicleLength;
	}
	
	public double getVehicleWidth() {
		return vehicleWidth;
	}
	
	public double getSpeed() {
		return speed;
	}
	

	
}
