package Observer;

public class Speed_show implements Observer{
	
    private Subject S_monitor;
    private double Show_speed;
	public Speed_show(Subject Speed_monitor)
	{
		this.S_monitor = S_monitor;
		Speed_monitor.registerOb(this);
		
	}
	@Override
	public void update(double speed) {
		this.Show_speed = speed;
	
	}
	public double show_speed()
	{
		return this.Show_speed;
	}

}
