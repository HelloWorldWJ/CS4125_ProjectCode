package Vehicle;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Road.Lane;


public class Vehicle {
	
//	public enum Brand{
//		Benz,Toyota,Nissan,Audi,Ford,Mazda
//	}

	private Lane track;
	private double angle;
	private Point position;
	private String imagePath;
	private BufferedImage carImage;
	private double circle_angle;
	private double angular_speed;
	private double vehicleLength;
	private double vehicleWidth;
	private VehicleEngineDecorator veEngineDec;
	private double acceleration;

	
	public Vehicle() {
		
	}
	
	public Vehicle(double angular_speed, double circle_angle) {
		this.angular_speed = angular_speed;
		this.circle_angle = circle_angle;
	}


	public Vehicle(double angle, Point xy, Lane track, VehicleEngineDecorator veEngineDec) {

		this.veEngineDec = veEngineDec;
		this.vehicleLength = veEngineDec.getVehicleLength();
		this.vehicleWidth = veEngineDec.getVehicleWidth();
		this.angular_speed = veEngineDec.getspeed();
		this.imagePath = veEngineDec.getVehicleImagePath();
		this.circle_angle = 0;
		this.angle = angle;
		this.position = xy;
		this.track = track;
		this.carImage = createCarImage();
		
		this.acceleration = veEngineDec.getAcceleration();
		
	}

	public void speed_increase() {
		this.angular_speed = this.angular_speed + this.acceleration;
	}
	
	public void speed_decrease() {
		this.angular_speed = this.angular_speed - 0.001;
	}
	
	
	private VehicleEngineDecorator getVehicleEngineDecorator() {
		return this.veEngineDec;
	}
	
	public void Sum_angle()
	{
		//speed_increase();
		
		if(this.circle_angle + this.angular_speed > 360)
		{
			this.circle_angle = (this.circle_angle + this.angular_speed) % 360;
		}
		else this.circle_angle = this.circle_angle + this.angular_speed;
	}
	

	public double Get_sum_angle()
	{
		return this.circle_angle;
	}
	
	public String getCarName() {
		return this.veEngineDec.getCarName();
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
		return this.angular_speed * 30 ;
	}
	
	public void move()
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
