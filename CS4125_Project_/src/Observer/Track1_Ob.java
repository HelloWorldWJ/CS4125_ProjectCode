package Observer;

public class Track1_Ob implements Observer{
	
    private Subject S_monitor;
    private double Show_speed1;
    private double Show_speed2;
    private double Show_speed3;
    private double Show_speed4;
	public Track1_Ob(Subject Speed_monitor)
	{
		this.S_monitor = S_monitor;
		Speed_monitor.registerOb(this);
		
	}
	@Override
	public void update(double speed1, double speed2, double speed3, double speed4) {
		this.Show_speed1 = speed1;
		this.Show_speed2 = speed2;
		this.Show_speed3 = speed3;
		this.Show_speed4 = speed4;
	
	}
	public double Track1_speed()
	{
		return this.Show_speed1;
	}

}
