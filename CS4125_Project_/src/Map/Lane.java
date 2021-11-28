package Map;

import java.awt.Color;
import java.awt.Point;

public abstract class Lane {
	
	public abstract int getX();

	public abstract int getY();

	public abstract int getWi();

	public abstract int getHe();
	
	public abstract int getline_width();

	public abstract int getNumCells();
	
	public abstract Color getLaneColor();
	
	public abstract Point get_Position(int cell_index);

}
