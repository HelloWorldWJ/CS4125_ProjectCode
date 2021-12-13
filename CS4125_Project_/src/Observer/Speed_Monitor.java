package Observer;
import java.util.ArrayList;
public class Speed_Monitor implements Subject{
	
	private double Monitored_Speed;
	private ArrayList<Observer>observers;
	public Speed_Monitor(double speed)
	{
		this.observers = new ArrayList();
		this.Monitored_Speed = speed;
		
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
			//this.observers.indexOf(i).update();
		}
		
	}

}
