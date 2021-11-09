package Analyst;

import Observer.Observer;
import Driver.Driver;
import Vehicle.Vehicle;

public class Report implements Observer{
	
	public Vehicle veh;
	public Driver dri;
	
	
	int index;
	string report;
	int map_index;
	int account_index;

	void set_report();

	@Override
	public void update(Vehicle veh) {
		// TODO Auto-generated method stub
		this.veh = veh;
		output_report();
	}

	@Override
	public void update(Driver dri) {
		// TODO Auto-generated method stub
		this.dri = dri;
		output_report();
	}

	public void output_report() {
		// it should output all elements not single element============
	}

}
