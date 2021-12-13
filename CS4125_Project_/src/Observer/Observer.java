package Observer;

import Driver.Driver;
import Vehicle.Vehicle;

import java.util.ArrayList;

import Control_Factor.Warning_Light;

public interface Observer {

	public void update(ArrayList<Double>speeds, ArrayList<String>drivernames);
}


