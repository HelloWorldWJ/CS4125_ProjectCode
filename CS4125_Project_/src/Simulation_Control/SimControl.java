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
	
	public ArrayList<Objects> observers;// Observer Pattern
	
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
	
	void Create_environment();
	void Create_cars();
	void Set_driver();
	void Set_Speed_limit();
	void Start_sim();
	void Pause_sim();
	void Stop_sim();
	void Congestion_report();
	void Crash_report();
	String Output_result();


	public SimControl() {
		observers = new ArrayList<Objects>();
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
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(); // // it should update all elements
			}

	}
	public void ElementsChanged() {
		notifyObservers();
	}
	
	@Override
	public void setElementVeh(Vehicle veh) {
		// TODO Auto-generated method stub
		this.veh = veh;
	}
	@Override
	public void setElementDri(Driver dri) {
		// TODO Auto-generated method stub
		this.dri = dri;
	}
	
	@Override
	public void setElementWlight(Warning_Light wlight) {
		// TODO Auto-generated method stub
		this.wlight = wlight;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
