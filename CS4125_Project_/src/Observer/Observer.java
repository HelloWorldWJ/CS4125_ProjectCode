package Observer;

import Driver.Driver;
import Vehicle.Vehicle;
import Control_Factor.Warning_Light;

public interface Observer {

	public void update(double speed1, double speed2, double speed3, double speed4);
}


