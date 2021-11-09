package SetElement;

import Driver.Driver;
import Vehicle.Vehicle;
import Control_Factor.Warning_Light;

public interface SetElement {
	public void setElementVeh(Vehicle veh);//1
	public void setElementDri(Driver dri);//2
	public void setElementWlight(Warning_Light wlight);//3
	
}
