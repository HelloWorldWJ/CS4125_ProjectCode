package Simulation_Control;
import java.awt.*;
import java.util.ArrayList;
import Map.Lane;
import Map.Lane1;
import Map.Lane2;
import Map.Lane3;
import Driver.Driver;
import Driver.DriverFactory.DriverTemper;
import Vehicle.Vehicle;
import Map.Lane1;
import Simulation_Control.Thread_source;


public class Sim_Controller extends Thread_source{
	private double map_wi, map_he;
	private Thread_source graphics; //the Gra_Controller
	private ArrayList<Lane> lanes;
	Dimension UI_size = Toolkit.getDefaultToolkit().getScreenSize();
	private Driver d;
	private Vehicle v;
	private Lane1 lane1;
	private Point Firstcar_loc;
	
	public Sim_Controller()
	{
		
		System.out.println("Sim_Control "+map_wi);
		this.map_wi = 1000;
		this.map_he = 606; // need change
		this.init_lanes();
		this.create_Driver();
		this.graphics = new Gra_Controller(this.map_wi, this.map_he,d,this.lanes); // may use the factory method
		
	}
	
	public void create_Driver()
	{
		
		this.Firstcar_loc = new Point((541), (12));
		this.lane1 = new Lane1();	
		this.v = new Vehicle(20, 20, 1, 3, this.Firstcar_loc,  lane1, "yellow.jpg");
		this.d = new Driver("Tom",v);
		
	}
	
	public void init_lanes()
	{
		
		this.lanes = new ArrayList<>();		
		Lane1 lane1 = new Lane1();//will use the arraylist
		this.lanes.add(lane1);
		Lane2 lane2 = new Lane2();//will use the arraylist  
		this.lanes.add(lane2);
//		Lane3 lane3 = new Lane3();
//		this.lanes.add(lane3);
		 
	}
	
	public void begin()
	{
		
		new Thread(d).start();
		graphics.run();
		
	}
	
	

}
