package Observer;
import java.util.ArrayList;
public class Speed_Monitor implements Subject{
	
	ArrayList<Double>speeds_in_all_tracks;
	ArrayList<String>drivernames_in_all_tracks;

	
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
			o.update(this.speeds_in_all_tracks, this.drivernames_in_all_tracks);
		}
		
	}
	

	public void set_info(ArrayList<String>drivernames, ArrayList<Double>speeds)
	{
		this.speeds_in_all_tracks = speeds;
		this.drivernames_in_all_tracks  = drivernames;
		this.infoChanged();		
	}

	private void infoChanged() 
	{
		notifyOb();
	
	}

}
