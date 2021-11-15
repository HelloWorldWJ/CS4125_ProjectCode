package Simulation_Control;
import Map.Display;
import Map.Draw_map;
import Map.IDisplay;
import Map.Road;

public class Gra_Controller extends Thread_source{
	private double map_wi, map_he;
	public Draw_map d_w;
	private IDisplay idisplay;
	
	
	public Gra_Controller(double ui_wi,double ui_he,Road road) {
	this.map_he = map_he;
	this.map_wi = map_wi;
	this.initDisplay();
	this.d_w = new Draw_map(this.idisplay, map_wi, map_he, road);
	
	}
	
	@Override
	public void run()//use the run function in Control_thread
	{
		d_w.render();
		
	}
	
	public void initDisplay()
	{
		Display display = new Display(map_he, map_wi);
		display.createDisplay();
		
	}
	

}
