/*
 * JUnit test for CSVContiguous IO class
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

public class CSVContiguousTest {

	@Test
	public void CSVContiguous() throws IOException, InterruptedException {

		/**
		 * Change this to the path of your CSV
		 */
		String csvPath = "C:\\Users\\Théophile\\Java\\Projet ML\\data\\submit_valid.csv";
		
		// Load the 5 first pictures
		IO reader = new CSVContiguous();
		Image[] images = new Image[5];
		for (int i = 0; i < 5; i++) {
			images[i] = reader.read(csvPath, i + 1);
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
		IO jpg = new JPEG();
		jpg.write(images[0], "./1.jpg");
		
		// Try to rewrite a single image as CSVs
		reader.write(images[0], "./1_contiguous.csv");
		IO csvInterlaced = new CSVInterlaced();
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
		jpg.writeDB(db, ".\\db_out\\");
		
		// Save a whole database as a CSV
		csvInterlaced.writeDB(db,  "./db_interlaced.csv");
		reader.writeDB(db,  "./db_contiguous.csv");
	
		// ;)
		assertTrue(true);
		
	}

}
