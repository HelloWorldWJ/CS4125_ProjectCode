package Simulation_Control;
import java.awt.*;
import Map.Road;

import Simulation_Control.Thread_source;;

public class Sim_Controller extends Thread_source{
	private double map_wi, map_he;
	private Thread_source graphics; //the Gra_Controller
	private Road road;
	Dimension UI_size = Toolkit.getDefaultToolkit().getScreenSize();
	public Sim_Controller()
	{
		this.map_wi = UI_size.getWidth()/2;
		this.map_he = UI_size.getHeight()/2;
		this.graphics = new Gra_Controller(map_wi, map_he,road); // may use the factory method
	}
	
	

}
