/*
 * Class ImageDB
 * 
 * Represents a standardized set of Images.
 * 
 * @author Jules Pénuchot, Théophile Walter
 */

package image;

import java.util.ArrayList;
import image.Image;

public class ImageDB {
	
	private ArrayList<Image> imDB;
	
	/**
	 * Create the database from an ArrayList
	 */
	public ImageDB ( ArrayList<Image> db) {
		imDB = db;
	}
	
	/**
	 * Create a void database
	 */
	public ImageDB () {
		imDB = new ArrayList<Image> ();
	}
	
	/**
	 * Add an image to the database
	 */
	public void add ( Image img) {
		imDB.add(img);
	}
	
	/**
	 * Remove an image from the database
	 */
	public Image remove ( int index) {
		return imDB.remove(index);
	}
	
	/**
	 * Return the size of the database
	 */
	public int size () {
		return imDB.size();
	}
	
}
