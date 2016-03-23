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
		
		// Convert the CSV string to char[]
		String[] img = lineContent.split(",");
		int length = img.length - (img.length % 3); // The length must be a multiple of 3
		char[] imgChar = new char[length];
		int size = length/3;
		for (int i = 0; i < length; i++) {
			imgChar[((i - (i%size)) / size) + ((i%size) * 3)] = (char)Integer.parseInt(img[i]);
		}
		
		// Return an image created from the line
		int widthHeight = (int)Math.sqrt(size);
		return new Image(imgChar, widthHeight, widthHeight);
		
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
			
			// Convert the CSV string to char[]
			String[] img = line.split(",");
			int length = img.length - (img.length % 3); // The length must be a multiple of 3
			char[] imgChar = new char[length];
			int size = length/3;
			for (int i = 0; i < length; i++) {
				imgChar[((i - (i%size)) / size) + ((i%size) * 3)] = (char)Integer.parseInt(img[i]);
			}
			
			int widthHeight = (int)Math.sqrt(size);
			db.add (new Image(imgChar, widthHeight, widthHeight));
		}
		br.close();
		
		// Finaly, return the database
		return db;
		
	}
	
	/**
	 * Saves all the images in a database to a output directory or a CSV file
	 * For CSVIO.PNG and CSVIO.jpeg, file names will be 1.ext, 2.ext, 3.ext, etc.
	 * CSV header will be based on the first image in the database.
	 * Ext will depend on @param format.
	 * 
	 * @param db
	 *  A database of images
	 * @param dest
	 *  The output directory/CSV for all the pictures in the database
	 * @param Format
	 *  The output image format : CSVIO.PNG, CSVIO.JPEG, CSCIO.CSV_CONTIGUOUS or CSVIO.CSV_INTERLACED
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
	 *  The file name of the image/CSV file
	 * @param Format
	 *  The output image format : CSVIO.PNG, CSVIO.JPEG, CSCIO.CSV_CONTIGUOUS or CSVIO.CSV_INTERLACED
	 * @throws IOException 
	 */
	public void saveImage (Image img, String dest, char format) throws IOException {
		super.saveImage(img, dest, format);
	}

}
