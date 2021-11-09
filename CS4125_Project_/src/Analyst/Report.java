package Analyst;

import Observer.Observer;
import Control_Factor.Warning_Light;
import Driver.Driver;
import Vehicle.Vehicle;
import Control_Factor.Warning_Light;

public class Report implements Observer{
	
	public Vehicle veh;
	public Driver dri;
	public Warning_Light wlight;
	
	
	int index;
	string report;
	int map_index;
	int account_index;

	void set_report();

	@Override
	public void updateVeh(Vehicle veh) {
		// TODO Auto-generated method stub
		this.veh = veh;
		output_report();
	}

	@Override
	public void updateDri(Driver dri) {
		// TODO Auto-generated method stub
		this.dri = dri;
		output_report();
	}
	@Override
	public void updateWlight(Warning_Light wlight) {
		this.wlight = wlight;
		output_report();
	}
	@Override
	public void updata(Vehicle veh, Driver dri, Warning_Light wlight) {
		this.veh = veh;
		this.dri = dri;
		this.wlight = wlight;
		output_report();
	}

	public void output_report() {
		// it should output all elements not single element============
	}

}
