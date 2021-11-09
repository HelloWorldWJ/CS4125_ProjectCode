package Control_Factor;

public class Warning_Light {
	
	public int location_x;
	public int location_y;
	public int limit_speed;
	
	public void set_location(int x, int y) {
		this.location_x = x;
		this.location_y = y;
	}
	public void set_limit_speed() {
		this.limit_speed = 60;
	}

}
