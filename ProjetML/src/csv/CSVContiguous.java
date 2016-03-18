/*
 * Class CSVContiguous
 * 
 * Implements the CSVIO abstract class.
 * 
 * @author Théophile Walter
 */

package csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import image.Image;
import image.ImageDB;

/*
 * Specific for the loading of the contiguous CSV images
 */
public class CSVContiguous extends CSVIO {

	/**
	 * Return an image from a specific line in a CSV
	 * 
	 * @param line
	 * 	Line number (starts from 0)
	 * @param source
	 * 	CSV source path
	 * @return
	 * 	An image from a specific line in a CSV
	 * @throws IOException 
	 */
	@Override
	public Image getLine(int line, String source) throws IOException {
		
		// Read the line in file
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(source);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		for(int i = 0; i < line; i++) {
			br.readLine();
		}
		String lineContent = br.readLine();
		br.close();
		
		// Return an image created from the line
		int size = (int)Math.sqrt(lineContent.split(",").length/3);
		return new Image(lineContent, size, size);
		
	}

	/**
	 * Loads a CSV file as an image database.
	 * 
	 * @param source
	 * 	CSV source path
	 * @return
	 * 	Image database
	 * @throws IOException 
	 */
	@Override
	public ImageDB getDB(String source) throws IOException {
		
		// Create a database
		ImageDB db = new ImageDB();
		
		// Read the CSV
		File file = new File(source);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line;
		line = br.readLine(); // The first line is not an image!
		while ((line = br.readLine()) != null) {
			int size = (int)Math.sqrt(line.split(",").length/3);
			db.add (new Image(line, size, size));
		}
		br.close();
		
		// Finaly, return the database
		return db;
		
	}
	
	/**
	 * Saves all the images in a database to a output directory
	 * File names will be 1.ext, 2.ext, 3.ext, etc.
	 * Ext will depend on @param format.
	 * 
	 * @param db
	 *  A database of images
	 * @param dest
	 *  The output directory for all the pictures in the database
	 * @param Format
	 *  The output image format : CSVIO.PNG or CSVIO.JPEG
	 * @throws IOException 
	 */
	public void saveImageDB(ImageDB db, String dest, char format) throws IOException {
		super.saveImageDB(db, dest, format);
	}
	
	/**
	 * Saves a single image
	 * 
	 * @param img
	 *  The image to save
	 * @param dest
	 *  The file name of the image
	 * @param Format
	 *  The output image format : CSVIO.PNG or CSVIO.JPEG
	 * @throws IOException 
	 */
	public void saveImage (Image img, String dest, char format) throws IOException {
		super.saveImage(img, dest, format);
	}

}
