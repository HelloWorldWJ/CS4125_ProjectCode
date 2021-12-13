package Observer;

import java.util.ArrayList;

public class Track2_Ob implements Observer{
	
    private Subject S_monitor;
    ArrayList<Double>speeds;
	public Track2_Ob(Subject Speed_monitor)
	{
		this.S_monitor = S_monitor;
		Speed_monitor.registerOb(this);
		
	}
	@Override
	public void update(ArrayList<Double>speeds) {
		this.speeds = speeds;
	
	}
	public double Track2_speed()
	{
		return this.speeds.get(1);
	}

}
