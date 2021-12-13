package Map;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;





public class Display implements IDisplay{
	
	private int map_wi, map_he;
	private JFrame frame;
	private Canvas canvas;
	private Dimension screen;
	
	public Display(double map_wi, double map_he)
	{
		
		this.map_wi = (int)map_wi;
		this.map_he = (int)map_he;
		this.screen = new Dimension();
		screen.setSize(map_wi,map_he);
		
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public void createDisplay() {
		
		
        frame = new JFrame("1");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(this.map_wi, this.map_he));
        frame.setLocation(0, 0);
        
        canvas = new Canvas();
        canvas.setSize(1000 , 606 );//set the size of canvas
        //canvas.setPreferredSize(this.screen);
        canvas.setBackground(Color.GREEN);
        
        canvas.setVisible(true);
          
        
        
        frame.add(canvas);
	    frame.pack();

     }
	
}