package Simulation_Control;

import java.util.ArrayList;
import java.util.Objects;

import Driver.Driver;
import Observer.Observer;
import SetElement.SetElement;
//import Subject.Observer;
import Subject.Subject;
import Vehicle.Vehicle;
import Control_Factor.Warning_Light;

public class SimControl implements Subject, SetElement{
	
	public ArrayList observers;// Observer Pattern
//	public enum ElementsChangedType {
//		VEHICLES,
//		DRIVERS,
//		WLIGHTS
//	}
	
	public ArrayList<Vehicle> vehicles;
	public ArrayList<Driver> drivers;
	public ArrayList<Warning_Light> wlights;
	
	public Vehicle veh;
	public Driver dri;
	public Warning_Light wlight;
	
//	Arraylist<Drivrer> drivers;
//	Arraylist<Vehicle> cars;
//	Arraylist<Weather> weather;
//	Arraylist<Warning_light> warning_light;
//	Arraylist<No_entry> no_entry;
//	String congestion_result;
//	String crash_result;
//	String total_result;
	
	
//=======some original methods========	
//	void Create_environment();
//	void Create_cars();
//	void Set_driver();
//	void Set_Speed_limit();
//	void Start_sim();
//	void Pause_sim();
//	void Stop_sim();
//	void Congestion_report();
//	void Crash_report();
//	String Output_result();
//==========================

	public SimControl() {
		observers = new ArrayList();
	}
	
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (i >= 0) {
		observers.remove(i);
		}

	}
	
	@Override
	public void notifyObservers1(Vehicle veh) {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.updateVeh(veh); 
			}

	}
	
	@Override
	public void notifyObservers2(Driver dri) {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.updateDri(dri); 
			}

	}
	
	@Override
	public void notifyObservers3(Warning_Light wlight) {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.updateWlight(wlight); 
			}

	}
	
//	public void ElementsChanged() {
//		notifyObservers();
//	}
	
	@Override
	public void setElementVeh(Vehicle veh) {
		// TODO Auto-generated method stub
		this.veh = veh;
		notifyObservers1(veh);
	}
	@Override
	public void setElementDri(Driver dri) {
		// TODO Auto-generated method stub
		this.dri = dri;
		notifyObservers2(dri);
	}
	
	@Override
	public void setElementWlight(Warning_Light wlight) {
		// TODO Auto-generated method stub
		this.wlight = wlight;
		notifyObservers3(wlight);
	}
	

}
