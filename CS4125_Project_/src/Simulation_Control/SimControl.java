package Simulation_Control;

public class SimControl {
	
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



	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
