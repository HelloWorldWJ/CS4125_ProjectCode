package Vehicle;

import SetElement.SetElement;

public class Vehicle implements SetElement {
	
	Enum Brand;
	double length;
	double width;
	double speed;
	int current_location_x;
	int current_location_y;
	
	void Set_attribute();
	void Update_attribute(v:Vehicle);

}
