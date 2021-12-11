package Simulation_Control;
import java.awt.*;
import java.util.ArrayList;
import Map.Lane;
import Map.Lane1;
import Map.Lane2;
import Map.Lane3;

import Driver.Driver;

import Vehicle.Vehicle;
import Vehicle.VehicleType;
import Vehicle.VehicleTypeFactory;

import Simulation_Control.Thread_source;


public class Sim_Controller extends Thread_source{
	private double map_wi, map_he;
	private Thread_source graphics; //the Gra_Controller
	private ArrayList<Lane> lanes;
	private ArrayList<Driver>drivers;
	private Lane1 lane1;
	private Point Firstcar_loc;
	private Point Secondcar_loc;
	
	public Sim_Controller()
	{
		
		this.drivers = new ArrayList<>();
		System.out.println("Sim_Control "+map_wi);
		this.map_wi = 1000;
		this.map_he = 606; // need change
		this.init_lanes();
		this.create_Driver();
		this.graphics = new Gra_Controller(this.map_wi, this.map_he, drivers, this.lanes); // may use the factory method
		
	}
	
	public void create_Driver()
	{
		VehicleTypeFactory v_fac = new VehicleTypeFactory();
		VehicleType fastcar = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Fastcar);	
		VehicleType slowcar = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Slowcar);
		
		
		this.Firstcar_loc = new Point((541), (12));	
		this.Secondcar_loc = new Point((541),(100));		
		Driver d1 = new Driver("Tom", new Vehicle( 3, this.Firstcar_loc, this.lanes.get(0), fastcar));
		this.drivers.add(d1);
		Driver d2 = new Driver("Sam", new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), slowcar));
		this.drivers.add(d2);
		
	}
	
	public void init_lanes()
	{
		
		this.lanes = new ArrayList<>();		
		Lane1 lane1 = new Lane1();//will use the arraylist
		this.lanes.add(lane1);
		Lane2 lane2 = new Lane2();//will use the arraylist  
		this.lanes.add(lane2);
		Lane3 lane3 = new Lane3();
		this.lanes.add(lane3);
		 
	}
	
	public void begin()
	{
		for(Driver d : drivers)
		{
			new Thread(d).start();
		}
		
		
		graphics.run();
		
	}
	
	

}
