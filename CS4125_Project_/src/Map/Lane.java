package Map;
import java.awt.*;
import java.util.HashMap;

public class Lane {
	private Point center;
	private int wi;
	private int he;
	private int cell_count;
	private int lane_width;
	private Color lane_Color;
	
	public Lane(int x, int y, int wi, int he, int lane_width, int numCells, Color color)
	{
		this.center = new Point();
		center.x = x;
		center.y = y;
		this.wi = wi;
		this.he = he;
		this.lane_width = lane_width;
		this.cell_count = numCells;
		this.lane_Color = color;

	}
	public int getX() {
		return this.center.x / 2;
	}

	public int getY() {
		return this.center.y / 2;
	}

	public int getWi() {
		return this.wi;
	}

	public int getHe() {
		return this.he;
	}
	public int getline_width()
	{
		return this.lane_width;
	}

	public int getNumCells() {
		return this.cell_count;
	}
	public Color getLaneColor() {
		return lane_Color;
	}

}
