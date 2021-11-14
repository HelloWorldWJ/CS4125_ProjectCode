package Driver;

import Driver.Driver.DriverTemper;

public class Driver {
	
	public String name;
	public int age;
	
//	Enum sex;
	
//	void Set_attribute();
//	void Update_attribute(d:Driver);
	
	public enum DriverTemper{
		NORMAL,
		IMPATIENTLY,
		IRRITABLY
	}
	
	public void createDriver(DriverTemper temper, String name, int age) {
		switch(temper) {
		case NORMAL:{
			this.name = name;
			this.age = age;
		}
		case IMPATIENTLY:{
			this.name = name;
			this.age = age;
		}
		case IRRITABLY:{
			this.name = name;
			this.age = age;
		}
		}
	}
	

}
