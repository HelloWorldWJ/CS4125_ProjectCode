package Map;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Draw_map implements I_Draw_map{
	private int index;
	private int Map_size_x;
	private int Map_size_y;
	private Road road;
	private IDisplay display;
	private Graphics2D graphics;
	private BufferStrategy buffer;
	private BufferedImage background;
	private final String BACKGROUND_PATH;
	
	//private Road road
	
	
	public Draw_map(IDisplay idis, double map_wi, double map_he, Road road)
	{
		this.Map_size_x = (int)map_wi;
		this.Map_size_y = (int)map_he;
		this.road = road;
		this.display = idis;
		this.background =  create_background();
		this.set_map();
		this.BACKGROUND_PATH = "1.jpg";
	}
	


	private void set_map() //create the graphics of map
	{
		this.display.getCanvas().createBufferStrategy(2);
		this.buffer = display.getCanvas().getBufferStrategy();
		
        this.graphics = (Graphics2D) buffer.getDrawGraphics();
    	this.graphics.clearRect(0, 0, Map_size_x, Map_size_y);
		
	}
	private void drawroad()
	{
		
	}
	
	private void drawbackground() {
		this.graphics.drawImage(this.background, 0,0,null);
	}
	
	public void render() {
		this.drawbackground();
		this.buffer.show();
	}
	
	private BufferedImage create_background()
	{
		
		try {
			System.out.print("ad");
			return ImageIO.read(new File(BACKGROUND_PATH));
			
			
            } 
		catch (Exception e) {
            return null;
        }
		
	}
		
	
	

}
