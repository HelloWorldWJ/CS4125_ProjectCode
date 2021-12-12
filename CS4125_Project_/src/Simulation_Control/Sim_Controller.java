package Simulation_Control;
import java.awt.*;
import java.util.ArrayList;
import Map.Lane;
import Map.Lane1;
import Map.Lane2;
import Map.Lane3;
import Map.Lane4;
import Driver.Driver;
import Driver.DriverFactory;
import Driver.NormalDriver;
import Driver.IrritableDriver;
import Vehicle.V6EngineDecorator;
import Vehicle.V8EngineDecorator;
import Vehicle.V3EngineDecorator;
import Vehicle.V4EngineDecorator;
import Vehicle.Vehicle;
import Vehicle.VehicleEngineDecorator;
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
	private Point Thirdcar_loc;
	private Point Fourthcar_loc;
	
	public Sim_Controller()
	{
		
		this.drivers = new ArrayList<>();
		System.out.println("[Sim_Control]");
		System.out.println("----------------------------");
		this.map_wi = 1000;
		this.map_he = 606; // need change
		this.init_lanes();
		this.create_Driver();
		this.graphics = new Gra_Controller(this.map_wi, this.map_he, drivers, this.lanes); 
		
	}
	
	public void create_Driver()
	{
		VehicleTypeFactory v_fac = new VehicleTypeFactory();
		VehicleType Ferrari = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Ferrari);	
		VehicleType Benz = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Benz);
		VehicleType Mazda = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Mazda);
		VehicleType Santana = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Santana);
		
		VehicleEngineDecorator v8EngineCar = new V8EngineDecorator(Ferrari);
		VehicleEngineDecorator v6EngineCar = new V6EngineDecorator(Benz);
		VehicleEngineDecorator v4EngineCar = new V4EngineDecorator(Mazda);
		VehicleEngineDecorator v3EngineCar = new V3EngineDecorator(Santana);
		
		
		this.Firstcar_loc = new Point((541), (12));	
		this.Secondcar_loc = new Point((541),(100));
		this.Thirdcar_loc = new Point((541),(188));
		this.Fourthcar_loc = new Point((541),(276));
		
		
		DriverFactory d_fac = new DriverFactory();
		
		int DriverTemperJudge;
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive1 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Firstcar_loc, this.lanes.get(0), v8EngineCar), "J.J");
			this.drivers.add(Drive1);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive1 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Firstcar_loc, this.lanes.get(0), v8EngineCar), "J.J");
			this.drivers.add(Drive1);
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive2 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), v6EngineCar), "Sam");
			this.drivers.add(Drive2);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive2 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), v6EngineCar), "Sam");
			this.drivers.add(Drive2);
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive3 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Thirdcar_loc, this.lanes.get(2), v4EngineCar), "Tom");
			this.drivers.add(Drive3);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive3 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Thirdcar_loc, this.lanes.get(2), v4EngineCar), "Tom");
			this.drivers.add(Drive3);
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive4 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Fourthcar_loc, this.lanes.get(3), v3EngineCar), "Jack");
			this.drivers.add(Drive4);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive4 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Fourthcar_loc, this.lanes.get(3), v3EngineCar), "Jack");
			this.drivers.add(Drive4);
		}
		
//		Driver IrritableDr = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Firstcar_loc, this.lanes.get(0), v8EngineCar), "J.J");
//		Driver NormalDr = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), v6EngineCar), "Sam");
//		Driver NormalDr2 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Thirdcar_loc, this.lanes.get(2), v4EngineCar), "Tom");
		

//		NormalDriver NormalDriver = (NormalDriver)NormalDr;
//		IrritableDriver IrritableDriver = (IrritableDriver)IrritableDr;
		
//		this.drivers.add(IrritableDr);
//		this.drivers.add(NormalDr);
//		this.drivers.add(NormalDr2);
		
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
		Lane4 lane4 = new Lane4();
		this.lanes.add(lane4);
		 
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
