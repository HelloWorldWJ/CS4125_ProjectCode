package Observer;

import Driver.Driver;
import Vehicle.Vehicle;
import Control_Factor.Warning_Light;

public interface Observer {
	public void updateVeh(Vehicle veh);//1
	public void updateDri(Driver dri);//2
	public void updateWlight(Warning_Light wlight);//3
	public void updata(Vehicle veh, Driver dri, Warning_Light wlight);//4
}
