package Simulation_Control;
import java.awt.*;

import Map.Lane;
import Map.Road;
import Driver.Driver;
import Driver.DriverFactory.DriverTemper;
import Vehicle.Vehicle;
import Map.Lane;
import Simulation_Control.Thread_source;

public class Sim_Controller extends Thread_source{
	private double map_wi, map_he;
	private Thread_source graphics; //the Gra_Controller
	private Road road;
	Dimension UI_size = Toolkit.getDefaultToolkit().getScreenSize();
	private Driver d;
	private Vehicle v;
	private Lane lane;
	private Point center;
	
	public Sim_Controller()
	{
		System.out.println("Sim_Control "+map_wi);
//		this.map_wi = UI_size.getWidth()/2;
//		this.map_he = UI_size.getHeight()/2;
		this.map_wi = 1000;
		this.map_he = 606; // need change
		
		
		this.center = new Point((1000), (606));
		this.lane = new Lane(500, 0,606/*radius*/,606, 25/*the width of lane*/, 1000, new Color(71, 73, 76));	
		this.v = new Vehicle(25, 25, 10, 3, center, road, lane, "yellow.jpg");
		this.d = new Driver("Tom",v);
		
		
		this.graphics = new Gra_Controller(this.map_wi, this.map_he,road,d); // may use the factory method
	}
	
	
	public void begin()
	{
		new Thread(d).start();
		graphics.run();
	}
	
	

}
