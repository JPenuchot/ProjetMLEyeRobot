/*
 *  Class ImageDisplay
 *
 *  Displays Image objects.
 *
 *  @author Jules Pénuchot, Théophile Walter
 */

package image;

import java.awt.*; 
import javax.swing.*; 

public class ImageDisplay extends JFrame {
	
	private Image displayImage = null;
	private boolean displayed = false;
	private JPanel panel = new JPanel();
	
	/**
	 * Constructor with an image
	 */
	public ImageDisplay ( Image img) {
		displayImage = img;
	}
	
	/**
	 * Constructor without image
	 */
	public ImageDisplay () { }
	
	/**
	 * Display the window
	 */
	public void show () {
		if (displayImage == null) {
			System.out.println("ImageDisplay.java: Error, no image given in constructor!");
			return;
		}
		/**
		 * TODO: Display the image to JFrame
		 */
	}
  
}
