package Observer;
import java.util.ArrayList;
public class Speed_Monitor implements Subject{
	
	private double Monitored_Speed;
	private ArrayList<Observer>observers;
	public Speed_Monitor()
	{
		this.observers = new ArrayList();

	}

	@Override
	public void registerOb(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
		
	}

	@Override
	public void removerOb(Observer o) {
		// TODO Auto-generated method stub
		int index = observers.indexOf(o);
		if(index >= 0)
			observers.remove(index);
	}

	@Override
	public void notifyOb() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.observers.size(); i++)
		{
			Observer o = (Observer)this.observers.get(i);
			o.update(this.Monitored_Speed);
		}
		
	}
	
	public void set_speed(double speed)
	{
		this.Monitored_Speed = speed;
		this.speedChanged();		
	}

	private void speedChanged() {
		notifyOb();
	
	}

}
