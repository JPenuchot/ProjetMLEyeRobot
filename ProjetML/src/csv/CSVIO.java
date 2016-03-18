/*
 * Class CSVLoader
 * 
 * Implements the CSV interface.
 * 
 * @author Jules Pénuchot, Théophile Walter
 */

package csv;

import java.util.ArrayList;

import image.*;

/*
 * Allows loading and handling of CSV data.
 * Specify the data type.
 * Interface for CSVContiguous And CSVTensorFlow
 */
public abstract class CSVIO {
	
	/**
	 * Return an image from a specific line in a CSV
	 * 
	 * @param line
	 * 	Line number (starts from 0)
	 * @param source
	 * 	CSV source path
	 * @return
	 * 	An image from a specific line in a CSV
	 */
	public Image getLine (int line, String source) { return null; }
	
	/**
	 * Loads a CSV file as an image database.
	 * 
	 * @param source
	 * 	CSV source path
	 * @return
	 * 	Image database
	 */
	public ImageDB getDB(String source) { return null; }
	
	/**
	 * Saves all the images in a database to a output directory
	 * File names will be 1.png, 2.png, 3.png, etc.
	 * 
	 * @param db
	 *  A database of images
	 * @param dest
	 *  The output directory for all the pictures in the database
	 */
	public void saveImageDB(ImageDB db, String dest) {
		int current = 0;
		for (Image img : db) {
			saveImage(db.get(current), dest + current+ ".png");
			current++;
		}
	}
	
	/**
	 * Saves a single image
	 * 
	 * @param img
	 *  The image to save
	 * @param dest
	 *  The file name of the image
	 */
	public void saveImage(Image img, String dest) { }
}
