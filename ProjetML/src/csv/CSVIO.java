/*
 * Class CSVIO
 * 
 * Abstract the CSV interface (raw contiguous format or interlaced).
 * 
 * @author Jules Pénuchot, Théophile Walter
 */

package csv;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import image.*;

/*
 * Allows loading and handling of CSV data.
 * Specify the data type.
 * Abstract class for CSVContiguous And CSVInterlaced
 */
public abstract class CSVIO {
	
	public static final char PNG = 0;
	public static final char JPEG = 1;
	public static final char CSV_CONTIGUOUS = 2;
	public static final char CSV_INTERLACED = 3;
	
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
		if (format == CSVIO.PNG || format == CSVIO.JPEG) { // If output format is an image
			int current = 0;
			String ext = (new String[] {".png", ".jpg"})[format];
			for (Image img : db) {
				saveImage(img, dest + current + ext, format);
				current++;
			}
		} else if (format == CSVIO.CSV_CONTIGUOUS || format == CSVIO.CSV_INTERLACED) { // Output is a CSV
			if (db.size() == 0) return;
			PrintWriter writer = new PrintWriter(dest, "UTF-8");
			for (int i = 0; i < db.get(0).getBuffer().length; i++) { // Write the header
				writer.print("d" + i + ",");
			}
			writer.print("labels\n");
			if (format == CSVIO.CSV_CONTIGUOUS) {
				for (Image img : db) {
					char[] buffer = img.getBuffer();
					int size = img.getWidth() * img.getHeight();
					for (int i = 0; i < size * 3; i++) {
						writer.print((int)buffer[((i - (i%size)) / size) + ((i%size) * 3)] + ",");
					}
					writer.print(img.getLabel() + "\n");
				}
			} else if (format == CSVIO.CSV_INTERLACED) {
				for (Image img : db) {
					char[] buffer = img.getBuffer();
					for (char b : buffer) {
						writer.print((int)b + ",");
					}
					writer.print(img.getLabel() + "\n");
				}
			}
			writer.close();
		} else { // Output format error
			System.out.println("CSVIO::saveImageDB(): Error, incorrect output format!");
			return;
		}
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
		if (format == CSVIO.PNG || format == CSVIO.JPEG) { // Output as an image
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
		} else if (format == CSVIO.CSV_CONTIGUOUS || format == CSVIO.CSV_INTERLACED) { // Output as a CSV
			PrintWriter writer = new PrintWriter(dest, "UTF-8");
			for (int i = 0; i < img.getBuffer().length; i++) { // Write the header
				writer.print("d" + i + ",");
			}
			writer.print("labels\n");
			if (format == CSVIO.CSV_CONTIGUOUS) {
				char[] buffer = img.getBuffer();
				int size = img.getWidth() * img.getHeight();
				for (int i = 0; i < size * 3; i++) {
					writer.print((int)buffer[((i - (i%size)) / size) + ((i%size) * 3)] + ",");
				}
				writer.print(img.getLabel() + "\n");
			} else if (format == CSVIO.CSV_INTERLACED) {
				char[] buffer = img.getBuffer();
				for (char b : buffer) {
					writer.print((int)b + ",");
				}
				writer.print(img.getLabel() + "\n");
			}
			writer.close();
		} else { // Output format error
			System.out.println("CSVIO::saveImage(): Error, incorrect output format!");
			return;
		}
	}
}
