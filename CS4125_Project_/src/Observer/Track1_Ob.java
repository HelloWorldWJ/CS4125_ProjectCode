package Observer;

import java.util.ArrayList;

public class Track1_Ob implements Observer{
	
    private Subject S_monitor;
    ArrayList<Double>speeds;
    ArrayList<String>drivernames;
    ArrayList<String>carNames;
	public Track1_Ob(Subject Speed_monitor)
	{
		this.S_monitor = S_monitor;
		Speed_monitor.registerOb(this);
		
	}
	@Override
	public void update(ArrayList<Double>speeds, ArrayList<String>drivernames, ArrayList<String>carNames) {
		this.speeds = speeds;
		this.drivernames = drivernames;
		this.carNames = carNames;

	
	}
	public double Track1_speed()
	{
		return this.speeds.get(0);
	}
	
	public String Track1_drivernames()
	{
		return this.drivernames.get(0);
	}
	public String Track1_carnames()
	{
		return this.carNames.get(0);
	}

}
