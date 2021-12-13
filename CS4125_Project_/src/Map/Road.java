package Map;
import java.awt.*;


public class Road {
	
	private int map_wi;
	private int map_he;
	private final Color road_co;
	private Point center;
	
	public Road(Point center, double map_wi, double map_he)
	{
		this.center = center;
		this.map_wi = Get_map_Height(map_wi);
		this.map_he = Get_map_Height(map_he);
		this.road_co = new Color(77,77,77);// will have a change
		
	}
	private int Get_map_Height(double value)
	{
		return (int)value/2;//it will some if statements
	}
	
	private int Get_road_Width()
	{
		return 50;//it will some if statements
		
	}
	

}
