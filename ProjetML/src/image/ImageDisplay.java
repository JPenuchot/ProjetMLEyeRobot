/*
 *  Class ImageDisplay
 *
 *  Displays Image objects.
 *
 *  @author Jules Pénuchot, Théophile Walter
 */

package image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ImageDisplay extends JFrame {
	
	private Image displayImage;
	private static final int SIZE = 10;
	private boolean currentState = false;
	
	/**
	 * Constructor
	 */
	public ImageDisplay ( Image img) {
		displayImage = img;
		this.setPreferredSize(new Dimension(img.getWidth()*SIZE, img.getHeight()*SIZE));
		this.pack();
	}
	
	/**
	 * Display/hide the window
	 */
	public void setVisible (boolean state) {
		super.setVisible(state);
		currentState = state;
	}
	
	/**
	 * Change the image
	 */
	public void setImage (Image img) {
		displayImage = img;
		if (currentState) {
			super.repaint(); // Redraw the window if it is currently displayed
		}
	}
	
	/**
	 * This method must be reimplemented to modify the drawing of the window
	 */
	@Override
	public void paint(Graphics g) {
		
		// Call the initial method
		super.paint(g);
		
		// Draw the image
		char[] pixels = displayImage.getBuffer();
		int size = pixels.length/3;
		for (int i = 0; i < size; i++) {
			g.setColor(new Color(pixels[i*3], pixels[i*3 + 1], pixels[i*3 + 2]));
			int x = i % displayImage.getWidth(), y = (i - x) / displayImage.getWidth();
			g.fillRect(x*SIZE, y*SIZE, SIZE, SIZE);
		}
		
	}
  
}
