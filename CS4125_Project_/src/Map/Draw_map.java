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
import Driver.Driver;
import Driver.IrritableDriver;
import Driver.NormalDriver;
import Observer.Speed_Monitor;
import Observer.Track1_Ob;
import Observer.Track2_Ob;
import Observer.Track3_Ob;
import Observer.Track4_Ob;
import Vehicle.Vehicle;





public class Draw_map implements I_Draw_map{
	private int Map_size_x;
	private int Map_size_y;
	private IDisplay display;
	private Graphics2D graphics;
	private BufferStrategy buffer;
	private BufferedImage background;
	private final String BACKGROUND_PATH;
	private Point center;
	private ArrayList<Driver>drivers;

	private ArrayList<Lane>lanes;
	private Speed_Monitor m ;
	private Track1_Ob t1; 
	private Track2_Ob t2; 
	private Track3_Ob t3; 
	private Track4_Ob t4; 
	
	
	
	public Draw_map(IDisplay idis, double map_wi, double map_he, ArrayList<Driver>drivers, ArrayList<Lane> lanes)
	{
		this.Map_size_x = (int)map_wi;
		this.Map_size_y = (int)map_he;   			    
	    this.center = new Point((Map_size_x), (Map_size_y));
        this.lanes = lanes;   
	    this.drivers = drivers;		    
		this.display = idis;	
		this.BACKGROUND_PATH = "background.png";
		this.background =  create_background();
		this.set_map();
		print_important_info();
		Observer_init();
	
	}
	
	private void print_important_info()
	{
		System.out.println("Map size: " + Map_size_x + " " + Map_size_y);
		System.out.println("----------------------------");
		System.out.println("(Vehicle--DriverTemper--Speed)");	
	}
	
	private void Observer_init()
	{
		this.m = new Speed_Monitor();
		this.t1 = new Track1_Ob(m);
		this.t2 = new Track2_Ob(m);
		this.t3 = new Track3_Ob(m);
		this.t4 = new Track4_Ob(m);
		
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
	
	private void draw_updateinfo_in_all_tracks(double speed, String drivername, int height)
	{

		String speed_str = "" + speed;
		//System.out.println(speed_str);
		this.graphics.setColor(Color.RED);
		this.graphics.setFont(new Font("¿¬Ìå", Font.BOLD, 20));
		this.graphics.drawString(drivername + "  " + speed_str +" km/h", 0, height);
	
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
			else if(driver.getClass().toString().equals("class Driver.IrritableDriver")) 
			{
				IrritableDriver IrritableDriver = (IrritableDriver)driver;
				IrritableDriver.Drive();
			}

		}	
		
		Observe_Distribute(drivers);
		this.buffer.show();
    }
	
	private void Observe_Distribute(ArrayList<Driver>ds)
	{
		ArrayList<Double>speeds = new ArrayList<>();
		speeds.add(ds.get(0).getVehilce().getSpeed());
		speeds.add(ds.get(1).getVehilce().getSpeed());
		speeds.add(ds.get(2).getVehilce().getSpeed());
		speeds.add(ds.get(3).getVehilce().getSpeed());
		
		ArrayList<String>driverNames = new ArrayList<>();
		driverNames.add(ds.get(0).getName());
		driverNames.add(ds.get(1).getName());
		driverNames.add(ds.get(2).getName());
		driverNames.add(ds.get(3).getName());
		
		
		this.m.set_info(driverNames,speeds);	
        this.draw_updateinfo_in_all_tracks(this.t1.Track1_speed(), this.t1.Track1_drivernames(), 570);
        this.draw_updateinfo_in_all_tracks(this.t2.Track2_speed(), this.t2.Track2_drivernames(), 550);
        this.draw_updateinfo_in_all_tracks(this.t3.Track3_speed(), this.t3.Track3_drivernames(), 530);
        this.draw_updateinfo_in_all_tracks(this.t4.Track4_speed(), this.t4.Track4_drivernames(), 510);
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
