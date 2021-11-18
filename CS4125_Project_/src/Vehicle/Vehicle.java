package Vehicle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
	private BufferedImage carImage;
	
//	private int currentCell, vehicleWidth, vehicleHeight, currentLaneId, vehicleId;
//	private double maxSpeed, currentSpeed, angle;
//	private Lane track;
//	private Road road;
//	private Point position;
//	private Color color;
//	private String imagePath;
//	private I_VehicleState state;
	
	
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
		this.carImage = createCarImage();
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
	public BufferedImage getCarImage() {
		return this.carImage;
	}
	
	public String getVehicleImagePath() {
		return this.imagePath;
	}
	
	public double getVehicleLength() {
		return vehicleLength;
	}
	
	public double getVehicleWidth() {
		return vehicleWidth;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	private BufferedImage createCarImage() {
		try {
            BufferedImage img = ImageIO.read(new File(this.getVehicleImagePath()));
        	BufferedImage resized_car_image = new BufferedImage((int)(this.getVehicleLength()), (int)(this.getVehicleWidth()), BufferedImage.TYPE_INT_ARGB);
	        Graphics2D graphics = resized_car_image.createGraphics();
	        graphics.drawImage(img.getScaledInstance((int)(this.getVehicleLength()), (int)(this.getVehicleWidth()), Image.SCALE_SMOOTH), 0, 0, null);
	        graphics.dispose();
        	return resized_car_image;
		} catch (IOException ex) {
			return null;
		}
	}
	

	
}
