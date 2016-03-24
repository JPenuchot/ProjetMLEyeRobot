/*
 * JUnit test for JPEG IO class
 * 
 * @author Théophile Walter
 */

package io;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import image.Image;
import image.ImageDB;
import image.ImageDisplay;

public class JPEGTest {

	@Test
	public void JPEG() throws IOException, InterruptedException {

		/**
		 * Change this to the path of your folder containing your images
		 */
		String csvPath = "C:\\Users\\Théophile\\git\\ProjetMLEyeRobot\\ProjetML\\db_out\\";
		
		// Load the 5 first pictures
		IO reader = new JPEG();
		Image[] images = new Image[5];
		for (int i = 0; i < 5; i++) {
			images[i] = reader.read(csvPath + i + ".png", 0);
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
		IO png = new PNG();
		png.write(images[0], "./1.png");
		reader.write(images[0], "./1.jpg");
		
		// Try to rewrite a single image as CSVs
		IO csvContiguous = new CSVContiguous();
		csvContiguous.write(images[0], "./1_contiguous.csv");
		IO csvInterlaced = new io.CSVInterlaced();
		csvInterlaced.write(images[0], "./1_interlaced.csv");
		
		// Load a whole CSV as a database
		System.out.println("Loading a database, this may take a certain time....");
		ImageDB db = reader.readDB(csvPath);
		System.out.println("Done.");
		
		// Display the 5 first images to check it
		display.setVisible(true);
		for (int i = 0; i < 5; i++) {
			display.setImage(db.get(i));
			Thread.sleep(1000);
		}
		
		display.setVisible(false);
		
		// Save a whole database as images
		png.writeDB(db, ".\\db_out\\");
		reader.writeDB(db, ".\\db_out\\");
		
		// Save a whole database as a CSV
		csvInterlaced.writeDB(db,  "./db_interlaced.csv");
		csvContiguous.writeDB(db,  "./db_contiguous.csv");
	
		// ;)
		assertTrue(true);
		
	}

}
