package Simulation_Control;
import java.awt.*;

import Map.Lane1;
import Map.Road;
import Driver.Driver;
import Driver.DriverFactory.DriverTemper;
import Vehicle.Vehicle;
import Map.Lane1;
import Simulation_Control.Thread_source;

public class Sim_Controller extends Thread_source{
	private double map_wi, map_he;
	private Thread_source graphics; //the Gra_Controller
	private Road road;
	Dimension UI_size = Toolkit.getDefaultToolkit().getScreenSize();
	private Driver d;
	private Vehicle v;
	private Lane1 lane1;
	private Point center;
	
	public Sim_Controller()
	{
		System.out.println("Sim_Control "+map_wi);
//		this.map_wi = UI_size.getWidth()/2;
//		this.map_he = UI_size.getHeight()/2;
		this.map_wi = 1000;
		this.map_he = 606; // need change
		
		create_Driver();
		
		
		
		this.graphics = new Gra_Controller(this.map_wi, this.map_he,road,d); // may use the factory method
	}
	
	public void create_Driver()
	{
		this.center = new Point((541), (12));
		this.lane1 = new Lane1();	
		
		this.v = new Vehicle(20, 20, 1, 3, center, road, lane1, "yellow.jpg");
		this.d = new Driver("Tom",v);
		
	}
	
	public void begin()
	{
		new Thread(d).start();
		graphics.run();
	}
	
	

}
