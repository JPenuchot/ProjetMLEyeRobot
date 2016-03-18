/*
 * JUnit test for CSVContiguous class
 * 
 * @author Théophile Walter
 */

package csv;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import image.*;

public class CSVContiguousTest {

	@Test
	public void CSVContiguous() throws IOException, InterruptedException {

		/**
		 * Change this to the path of your CSV
		 */
		String csvPath = "C:\\Users\\Théophile\\Java\\Projet ML\\data\\local_train.csv";
		
		// Load the 5 first pictures
		CSVIO reader = new CSVContiguous();
		Image[] images = new Image[5];
		for (int i = 0; i < 5; i++) {
			images[i] = reader.getLine(i + 1, csvPath);
		}
		
		// Display the images to check it
		ImageDisplay display = new ImageDisplay(images[0]);
		display.setVisible(true);
		Thread.sleep(1000);
		for (int i = 1; i < 5; i++) {
			display.setImage(images[i]);
			Thread.sleep(1000);
		}
		
		// Hide the image
		display.setVisible(false);
		
		// Try to rewrite images
		reader.saveImage(images[0], "./1.png", CSVIO.PNG);
		reader.saveImage(images[0], "./1.jpg", CSVIO.JPEG);
		
		// Load a whole CSV as a database
		System.out.println("Loading a database, this may take a certain time....");
		ImageDB db = reader.getDB(csvPath);
		System.out.println("Done.");
		
		// Display the 5 first images to check it
		display.setVisible(true);
		for (int i = 0; i < 5; i++) {
			display.setImage(db.get(i));
			Thread.sleep(1000);
		}
	
		// ;)
		assertTrue(true);
		
	}

}
