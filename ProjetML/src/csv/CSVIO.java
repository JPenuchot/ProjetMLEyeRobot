/*
 * Class CSVIO
 * 
 * Abstract the CSV interface (raw contiguous format or for TensorFlow).
 * 
 * @author Jules Pénuchot, Théophile Walter
 */

package csv;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import image.*;

/*
 * Allows loading and handling of CSV data.
 * Specify the data type.
 * Interface for CSVContiguous And CSVTensorFlow
 */
public abstract class CSVIO {
	
	public static final char PNG = 0;
	public static final char JPEG = 1;
	
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
	public abstract Image getLine (int line, String source) throws IOException;
	
	/**
	 * Loads a CSV file as an image database.
	 * 
	 * @param source
	 * 	CSV source path
	 * @return
	 * 	Image database
	 * @throws IOException 
	 */
	public abstract ImageDB getDB(String source) throws IOException;
	
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
		if (format != CSVIO.PNG && format != CSVIO.JPEG) {
			System.out.println("CSVIO::saveImageDB(): Error, incorrect output format!");
			return;
		}
		int current = 0;
		String ext = (format == CSVIO.PNG ? ".png" : ".jpg");
		for (Image img : db) {
			saveImage(img, dest + current + ext, format);
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
	 * @param Format
	 *  The output image format : CSVIO.PNG or CSVIO.JPEG
	 * @throws IOException 
	 */
	public void saveImage (Image img, String dest, char format) throws IOException {
		if (format != CSVIO.PNG && format != CSVIO.JPEG) {
			System.out.println("CSVIO::saveImage(): Error, incorrect output format!");
			return;
		}
		
		// Create a bufured image
		BufferedImage biOut = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		
		// Set the pixels
		int size = img.getWidth()*img.getHeight();
		int[] pixels = new int[size];
		char[] originalsPixels = img.getBuffer();
		for (int i = 0; i < size; i++) {
			pixels[i] = (originalsPixels[i*3] << 16) + (originalsPixels[i*3+1] << 8) + originalsPixels[i*3+2];
		}
		biOut.setRGB(0, 0, img.getWidth(), img.getHeight(), pixels, 0, img.getWidth());
		
		// Save the file
		ImageIO.write(biOut, format == CSVIO.PNG ? "PNG" : "JPEG", new File(dest));
	}
}
