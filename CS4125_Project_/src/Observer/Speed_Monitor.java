package Observer;
import java.util.ArrayList;
public class Speed_Monitor implements Subject{
	
	ArrayList<Double>speeds_in_all_tracks;
	private double Monitored_Speed_in_track_1;
	private double Monitored_Speed_in_track_2;
	private double Monitored_Speed_in_track_3;
	private double Monitored_Speed_in_track_4;

	
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
			o.update(this.speeds_in_all_tracks);
		}
		
	}
	

	public void set_speed(ArrayList<Double>speeds)
	{
		this.speeds_in_all_tracks = speeds;
		this.speedChanged();		
	}

	private void speedChanged() 
	{
		notifyOb();
	
	}

}
