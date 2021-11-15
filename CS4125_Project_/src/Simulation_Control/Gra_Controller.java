package Simulation_Control;
import Map.Display;
import Map.Draw_map;
import Map.IDisplay;
import Map.Road;

public class Gra_Controller extends Thread_source{
	private double map_wi, map_he;
	public Draw_map d_map;
	private IDisplay idisplay;
	
	
	public Gra_Controller(double ui_wi,double ui_he,Road road) {
	this.map_he = ui_he;
	this.map_wi = ui_wi;
	this.initDisplay();
	this.d_map = new Draw_map(this.idisplay, map_wi, map_he, road);
	System.out.println("Gra_Control "+map_wi+" "+map_he);
	
	}
	
	@Override
	public void run()//use the run function in Control_thread
	{
		d_map.render();
		
	}
	
	public void initDisplay()
	{
		
		idisplay = new Display(map_he, map_wi);
		idisplay.createDisplay();
		
	}
	

}
