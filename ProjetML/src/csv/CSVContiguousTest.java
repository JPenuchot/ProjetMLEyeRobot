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
		String csvPath = "C:\\Users\\Théophile\\Java\\Projet ML\\data\\submit_valid.csv";
		
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
		
		// Try to rewrite a single image as CSVs
		reader.saveImage(images[0], "./1_contiguous.csv", CSVIO.CSV_CONTIGUOUS);
		reader.saveImage(images[0], "./1_interlaced.csv", CSVIO.CSV_INTERLACED);
		
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
		
		display.setVisible(false);
		
		// Save a whole database as images (uncomment to test)
		//reader.saveImageDB(db, ".\\db_out\\", CSVIO.JPEG);
		//reader.saveImageDB(db, ".\\db_out\\", CSVIO.PNG);
		
		// Save a whole database as a CSV (uncomment to test)
		//reader.saveImageDB(db,  "./db_interlaced.csv", CSVIO.CSV_INTERLACED);
		//reader.saveImageDB(db,  "./db_contiguous.csv", CSVIO.CSV_CONTIGUOUS);
	
		// ;)
		assertTrue(true);
		
	}

}
