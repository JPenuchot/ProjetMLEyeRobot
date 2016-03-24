/**
 * Implementation of the IO interface for the contiguous CSV format
 * 
 * @author Théophile Walter
 */

package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import image.Image;
import image.ImageDB;

public class CSVContiguous implements IO {

	/**
	 * Read an image from a contiguous CSV
	 * 
	 * @param src
	 *  The source of the file containing the image
	 * @param n
	 *  The number of the image in the file
	 * @return
	 *  An Image
	 * @throws IOException 
	 */
	public Image read(String src, int n) throws IOException {
		
		// Read the line in file
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		for(int i = 0; i < n; i++) {
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
		
		// Return an image created from the line with the label
		return new Image(imgChar, (int)Math.sqrt(size), img.length % 3 == 0 ? 0 : Integer.parseInt(img[img.length - 1]));
		
	}

	/**
	 * Read an image database from  a contiguous CSV
	 * 
	 * @param src
	 *  The source file of the database
	 * @return
	 *  An ImageDB
	 * @throws IOException
	 */
	public ImageDB readDB(String src) throws IOException {
		
		// Create a database
		ImageDB db = new ImageDB();
		
		// Read the CSV
		File file = new File(src);
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

			// Add the image to the database
			db.add (new Image(imgChar, (int)Math.sqrt(size), img.length % 3 == 0 ? 0 : Integer.parseInt(img[img.length - 1])));
			
		}
		
		br.close();
		
		// Finaly, return the database
		return db;
		
	}

	/**
	 * Write an image to a contiguous CSV file
	 * 
	 * @param src
	 *  The image to write
	 * @param dest
	 *  The destination file
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public void write(Image src, String dest) throws FileNotFoundException, UnsupportedEncodingException {
		
		// Open file
		PrintWriter writer = new PrintWriter(dest, "UTF-8");
		int size = src.getWidth() * src.getHeight();
		
		// Write the header
		for (int i = 0; i < size * 3; i++) {
			writer.print("d" + i + ",");
		}
		writer.print("labels\n");
		
		// Write the datas
		for (int color : new int[] {Image.R, Image.G, Image.B}) {
			for (int j = 0; j < src.getHeight(); j++) {
				for (int i = 0; i < src.getWidth(); i++) {
					writer.print((int)src.getPixel(i, j, color) + ",");
				}
			}
		}
		
		writer.print(src.getLabel() + "\n");
		writer.close();
		
	}

	/**
	 * Write a database to a contiguous CSV file
	 * 
	 * @param src
	 *  The image database to write
	 * @param dest
	 *  The destination file
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public void writeDB(ImageDB src, String dest) throws FileNotFoundException, UnsupportedEncodingException {
		
		// Open file
		if (src.size() == 0) return;
		PrintWriter writer = new PrintWriter(dest, "UTF-8");
		
		// Write the header
		for (int i = 0; i < src.get(0).getWidth() * src.get(0).getHeight() * 3; i++) {
			writer.print("d" + i + ",");
		}
		writer.print("labels\n");
		
		// For each image
		for (Image img : src) {
			
			// Write the datas
			for (int color : new int[] {Image.R, Image.G, Image.B}) {
				for (int j = 0; j < img.getHeight(); j++) {
					for (int i = 0; i < img.getWidth(); i++) {
						writer.print((int)img.getPixel(i, j, color) + ",");
					}
				}
			}
			writer.print(img.getLabel() + "\n");
			
		}
		
		writer.close();
		
	}
	
}
