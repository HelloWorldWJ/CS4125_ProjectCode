package Vehicle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Map.Lane1;

import SetElement.SetElement;

public class Vehicle {
	
	public enum Brand{
		Benz,Toyota,Nissan,Audi,Ford
	}
	private double vehicleLength;
	private double vehicleWidth;
	private Lane1 track;
	
	private double speed, angle;
	private Point position;
	private int current_location_x;
	private int current_location_y;
	private String imagePath;
	private BufferedImage carImage;
	private double circle_angle;
	private double angular_speed;
	

	public Vehicle(double length, double width, double angular_speed, double angle, Point xy,  Lane1 track, String imagePath) {
//		this.Brand = Brand;
		this.vehicleLength = length;
		this.vehicleWidth = width;
		this.circle_angle = 0;
		this.speed = speed;
		this.angle = angle;
		this.position = xy;

		this.track = track;
		this.angular_speed = angular_speed;
		this.imagePath = imagePath;
		this.carImage = createCarImage();
	}
	
	private void Sum_angle()
	{
		if(this.circle_angle + this.angular_speed > 360)
		{
			this.circle_angle = (this.circle_angle + this.angular_speed) % 360;
		}
		else this.circle_angle = this.circle_angle + this.angular_speed;
	}
	

	private double Get_sum_angle()
	{
		return this.circle_angle;
	}
	
	public Point getPosition(){
		return position;
	}
	
	public double getAngle(){
		return angle;
	}
	


	public Lane1 getLane() {
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
	public void move(int speed)
	{
		this.Sum_angle();
		this.position.x = (int)(Math.sin(Math.PI/180 *this.circle_angle) * 303 + 553 - 12);
		System.out.println(this.circle_angle);
		this.position.y = (int)(328 - Math.cos(Math.PI/180 *this.circle_angle) *  303 - 20);
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
