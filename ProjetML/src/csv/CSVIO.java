/*
 * Class CSVLoader
 * 
 * Implements the CSV interface.
 * 
 * @author Jules Pénuchot, Théophile Walter
 */

package csv;

import java.util.ArrayList;

import image.Image;

/*
 * Allows loading and handling of CSV data.
 * Specify the data type.
 */
public class CSVIO {

	
	/**
	 * Return an ArrayList of values in a specific line from the CSV
	 * 
	 * @param line :
	 * 	Line number (starts from 0)
	 * 		source :
	 * 	CSV source path
	 * @return
	 * 	An ArrayList of values in a specific line from the CSV
	 */
	public static Image getLine (int line, String source) {
		return null;
	}
	
	/**
	 * Loads a CSV file as an image database.
	 * @param source :
	 * 	CSV source path
	 * @return
	 * 	Image database
	 */
	public static ArrayList<Image> getDB(String source){
		return null;
	}
	
	public static Image getLine_legacy(int line, String source){
		return null;
	}
	
	public static ArrayList<Image> getDB_legacy(String source){
		return null;
	}
	
	public static void saveImage(ArrayList<Image> db, String dest){
		
	}
}
