package Map;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Spring;

import Driver.Driver;
import Driver.IrritableDriver;
import Driver.NormalDriver;
import Observer.Speed_Monitor;
import Observer.Speed_show;
import Driver.DriverFactory;
import Vehicle.Ferrari;
import Vehicle.Vehicle;
import Vehicle.VehicleTypeFactory;
import Driver.DriverFactory.DriverTemper;




public class Draw_map implements I_Draw_map{
	private int index;
	private int Map_size_x;
	private int Map_size_y;
	private IDisplay display;
	private Graphics2D graphics;
	private BufferStrategy buffer;
	private BufferedImage background;
	private final String BACKGROUND_PATH;
	private Point center;
	private ArrayList<Driver>drivers;
	private Vehicle vehicle;
	private Lane1 lane1;
	private Lane2 lane2;
	private ArrayList<Lane>lanes;
	private Speed_Monitor m ;
	private Speed_show s1; 
	private Speed_show s2; 
	private Speed_show s3; 
	private Speed_show s4; 
	
	
	
	public Draw_map(IDisplay idis, double map_wi, double map_he, ArrayList<Driver>drivers, ArrayList<Lane> lanes)
	{
		this.Map_size_x = (int)map_wi;
		this.Map_size_y = (int)map_he;   			    
	    this.center = new Point((Map_size_x), (Map_size_y));
		int currentX = (int) center.getX();
        int currentY = (int) center.getY();
		System.out.println("Map size: " + Map_size_x + " " + Map_size_y);
		System.out.println("----------------------------");
		System.out.println("(Vehicle--DriverTemper--Speed)");		
        this.lanes = lanes;   
	    this.drivers = drivers;		    
		this.display = idis;	
		this.BACKGROUND_PATH = "background.png";
		this.background =  create_background();
		this.lane1 = new Lane1();
		this.lane2 = new Lane2();
		this.set_map();
		Observer_init();
	
	}
	private void Observer_init()
	{
		this.m = new Speed_Monitor();
		this.s1 = new Speed_show(m);
		this.s2 = new Speed_show(m);
		this.s3 = new Speed_show(m);
		this.s4 = new Speed_show(m);
		
	}
	
	public void set_map() //create the graphics of map
	{
		
		this.display.getCanvas().createBufferStrategy(1);	
		this.buffer = display.getCanvas().getBufferStrategy();		
        this.graphics = (Graphics2D) buffer.getDrawGraphics();      
        this.graphics.clearRect(0, 0, 700, 700);
    
	}
	

	private void drawVehicle(Vehicle vehicle)
	{
		
		Point pos = vehicle.getPosition();
        Point p2 = new Point((int)(pos.x - (vehicle.getVehicleWidth() / 2)), (int)(pos.y - (vehicle.getVehicleLength() / 2)));

        AffineTransform at = new AffineTransform();
        at.rotate(vehicle.getAngle(), p2.x + (vehicle.getVehicleWidth() / 2), p2.y +( vehicle.getVehicleLength() / 2));
        at.translate(p2.x + (vehicle.getVehicleWidth() / 8), p2.y + (vehicle.getVehicleWidth() / 4));

        this.graphics.drawImage(vehicle.getCarImage(), at, null);
	}
	
	private void drawspeed(double speed)
	{

		String speed_str = "" + speed;
		this.graphics.setColor(Color.RED);
		this.graphics.setFont(new Font("����", Font.BOLD, 20));
		this.graphics.drawString(speed_str, 0, 590);
	
	}
	
	
	private void drawLane(Lane lane)
	{
		this.graphics.setColor(lane.getLaneColor());
		this.graphics.setStroke(new BasicStroke(lane.getline_width()));
		this.graphics.draw(new Ellipse2D.Double(lane.getX(), lane.getY(), lane.getWi(), lane.getHe()));
		
	}
	
	
	
	private void drawbackground() {
		this.graphics.drawImage(this.background, 0,0,null);
	}
	
	
	public void render() 
	{

//		Speed_Monitor m = new Speed_Monitor();
//		Speed_show s1 = new Speed_show(m); 
		this.drawbackground();
		for (Lane l : this.lanes) 
		{
            this.drawLane(l);
        }
		for (Driver driver : this.drivers)
		{
			
			this.drawVehicle(driver.getVehilce());			
			if(driver.getClass().toString().equals("class Driver.NormalDriver")) {
				NormalDriver NormalDriver = (NormalDriver)driver;
				NormalDriver.Drive();
				//NormalDriver.pri();
			}
			else if(driver.getClass().toString().equals("class Driver.IrritableDriver")) {
				IrritableDriver IrritableDriver = (IrritableDriver)driver;
				IrritableDriver.Drive();
				//IrritableDriver.pri();
			}
			if(drivers.indexOf(driver) == 0)
			{
				this.m.set_speed(driver.getVehilce().getSpeed());
			}
		}	
		this.drawspeed(this.s1.show_speed());
		this.buffer.show();
    }

	
	
	
	
	private BufferedImage create_background()
	{
		
		try 
		{
			return ImageIO.read(new File(this.BACKGROUND_PATH));	
			            
		} 
		
		
		catch (Exception e) 
		{	
			System.out.print(e);
            return null;
        }
		
	}
		
	
	

}
