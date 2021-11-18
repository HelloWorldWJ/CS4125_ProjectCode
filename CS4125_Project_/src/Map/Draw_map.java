package Map;
import java.awt.BasicStroke;
import java.awt.Color;
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







public class Draw_map implements I_Draw_map{
	private int index;
	private int Map_size_x;
	private int Map_size_y;
	private Road road;//may not be used
	private Lane lane;
	private IDisplay display;
	private Graphics2D graphics;
	private BufferStrategy buffer;
	private BufferedImage background;
	private final String BACKGROUND_PATH;
	private Point center;
	
	//private Road road
	
	
	public Draw_map(IDisplay idis, double map_wi, double map_he, Road road)
	{
		System.out.println("Draw_map "+Map_size_x+" "+Map_size_y);

		this.Map_size_x = (int)map_wi;
		this.Map_size_y = (int)map_he;   		
	    this.road = road;//may not be used
	    
	    this.center = new Point((Map_size_x), (Map_size_y));
	    int currentX = (int) center.getX();
        int currentY = (int) center.getY();
        System.out.println("Draw_map class currentX: "+currentX+" currentY "+currentY);
        
        
        
	    this.lane = new Lane(450, 10, Map_size_y, Map_size_y, 25,1000, new Color(71, 73, 76));//will use the arraylist
	    		
	    
	    
		this.display = idis;	
		this.BACKGROUND_PATH = "background.png";
		this.background =  create_background();
		this.set_map();
	
	}
	


	private void set_map() //create the graphics of map
	{
		
		this.display.getCanvas().createBufferStrategy(1);
		
		this.buffer = display.getCanvas().getBufferStrategy();
		
        this.graphics = (Graphics2D) buffer.getDrawGraphics();
        
   
         //this.graphics.setColor(Color.BLACK);
         this.graphics.clearRect(0, 0, 700, 700);
        


	}
	

	private void drawVehicle()
	{
		
	}
	
	
	private void drawLane(Lane lane)
	{
		this.graphics.setColor(lane.getLaneColor());
		this.graphics.setStroke(new BasicStroke(lane.getline_width()));
		this.graphics.draw(new Ellipse2D.Double(lane.getX(), lane.getY(), lane.getWi(), lane.getHe()));
		
	}
	
	
	
	private void drawbackground() {
		this.graphics.drawImage(this.background, 0,0,null);
	}
	
	
	
	
	public void render() {
		
		
		this.drawbackground();
		this.drawLane(lane);
		
		this.buffer.show();
	}
	
	
	
	
	private BufferedImage create_background()
	{
		
		try {
			
			return ImageIO.read(new File(this.BACKGROUND_PATH));
			

            } 
		
		
		catch (Exception e) {
			
			System.out.print(e);
            return null;
        }
		
	}
		
	
	

}
