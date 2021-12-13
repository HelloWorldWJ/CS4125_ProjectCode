package Observer;

public class Speed_show implements Observer{
	
    private Subject S_monitor;
	public Speed_show(Subject Speed_monitor)
	{
		this.S_monitor = S_monitor;
		Speed_monitor.registerOb(this);
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
	}

}
