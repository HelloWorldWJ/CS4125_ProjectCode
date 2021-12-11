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

import SetElement.SetElement;

public class Vehicle {
	
	public enum Brand{
		Benz,Toyota,Nissan,Audi,Ford
	}

	private Lane track;
	private double  angle;
	private Point position;
	private int current_location_x;
	private int current_location_y;
	private String imagePath;
	private BufferedImage carImage;
	private double circle_angle;
	private double angular_speed;
	private double vehicleLength;
	private double vehicleWidth;
	private VehicleType vt;
	private EngineDecorator v6EngineCar;//---------
	private double acceleration;

	public Vehicle(double angle, Point xy,  Lane track, VehicleType vt) {
//		this.Brand = Brand;
		this.vt = vt;
		this.vehicleLength = vt.getVehicleLength();
		this.vehicleWidth = vt.getVehicleWidth();
		this.angular_speed = vt.getspeed();
		this.imagePath = vt.getVehicleImagePath();
		this.circle_angle = 0;
		this.angle = angle;
		this.position = xy;
		this.track = track;
		this.carImage = createCarImage();
		
		this.v6EngineCar = new V6EngineDecorator(vt);//----------
		
	}
	
	private void speed_increase() {
		this.angular_speed = this.angular_speed + this.acceleration;
	}
	
	private void Sum_angle()
	{
		speed_increase();
		
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

	public Lane getLane() {
		return track;
	}
	
	public BufferedImage getCarImage() {
		return this.carImage;
	}
	
	public String getVehicleImagePath() {
		return this.imagePath;
	}
	
	public double getSpeed() 
	{
		return this.angular_speed;
	}
	
	public void move(int speed)
	{
		this.Sum_angle();
		//System.out.println(this.track.get_Radius());
		this.position.x = (int)(Math.sin(Math.PI/180 *this.circle_angle) * this.track.get_Radius() + 553 - 22);//12
		//System.out.println(this.circle_angle);
		this.position.y = (int)(328 - Math.cos(Math.PI/180 *this.circle_angle) *  this.track.get_Radius() - 30);//20
	}
	
	
	public double getVehicleLength() 
	{
		return this.vehicleLength;
	}
	
	public double getVehicleWidth() 
	{
		return this.vehicleWidth;
	}
	
	public BufferedImage createCarImage() 
	{
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
