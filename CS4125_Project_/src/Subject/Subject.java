package Subject;

import Control_Factor.Warning_Light;
import Driver.Driver;
import Observer.Observer;
import Vehicle.Vehicle;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers1(Vehicle veh);
	public void notifyObservers2(Driver dri);
	public void notifyObservers3(Warning_Light wlight);

}
