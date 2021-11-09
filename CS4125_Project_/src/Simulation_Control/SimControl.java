package Simulation_Control;

import java.util.ArrayList;

import Driver.Driver;
//import Subject.Observer;
import Subject.Subject;
import Vehicle.Vehicle;

public class SimControl implements Subject{
	
	public ArrayList observers;// Observer Pattern
	
	public Vehicle veh;
	public Driver dri;
	
	Arraylist<Drivrer> drivers;
	Arraylist<Vehicle> cars;
	Arraylist<Weather> weather;
	Arraylist<Warning_light> warning_light;
	Arraylist<No_entry> no_entry;
	String congestion_result;
	String crash_result;
	String total_result;
	
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
		observers = new ArrayList();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
			observer.update(????); // // =====not sure to update what type of element===== maybe it should update all elements
			}

	}
	public void ElementsChanged() {
		notifyObservers();
	}

}
