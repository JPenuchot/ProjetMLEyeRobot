/*
 * Implementation of the IO interface for the PNG format
 * 
 * @author Théophile Walter
 */

package io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import image.Image;
import image.ImageDB;

public class PNG implements IO {

	/**
	 * Read an image from a PNG
	 * 
	 * @param src
	 *  The source of the file containing the image
	 * @param n
	 *  Useless here
	 * @return
	 *  An Image
	 * @throws IOException 
	 */
	public Image read(String src, int n) throws IOException {

		// Read the image
		BufferedImage bui = ImageIO.read(new File(src));
        int width = bui.getWidth();
        int height = bui.getHeight();
        int[] pixels = bui.getRGB(0, 0, width, height, null, 0, width);
        
        // Convert int[] to char[]*3
        int length = width * height * 3;
 		char[] imgChar = new char[length];
 		for (int i = 0; i < length; i += 3) {
 			imgChar[i] = (char)((pixels[i/3] & 0xFF0000) >> 16);
 			imgChar[i + 1] = (char)((pixels[i/3] & 0xFF00) >> 8);
 			imgChar[i + 2] = (char)(pixels[i/3] & 0xFF);
 		}
 		
 		// Return an image
 		return new Image(imgChar, width);
 		
	}

	/**
	 * Read an image database from folder
	 * All *.png files will be added to the database
	 * 
	 * @param src
	 *  The source folder of the database
	 * @return
	 *  An ImageDB
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	public ImageDB readDB(String src) throws IOException {

		// Create a database
		ImageDB db = new ImageDB();
		
		// Add a slash to src if needed
		String addSlash = (!src.substring(src.length() - 1).equals("\\") && !src.substring(src.length() - 1).equals("/")) ? "/" : "";
		
		// List all the images in the directory
		File folder = new File(src);
		File[] list = folder.listFiles();
		for (File f : list) {
			if (f.isFile() && f.getName().substring(f.getName().length() - 4).equals(".png")) {
				db.add(this.read(src + addSlash + f.getName(), 0));
			}
		}
		
		// Return the database
		return db;
		
	}

	/**
	 * Write an image to a PNG file
	 * 
	 * @param src
	 *  The image to write
	 * @param dest
	 *  The destination file
	 */
	public void write(Image src, String dest) {

		// Create a bufured image
		BufferedImage biOut = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		
		// Set the pixels
		int size = src.getWidth() * src.getHeight();
		int[] pixels = new int[size];
		for (int j = 0; j < src.getHeight(); j++) {
			for (int i = 0; i < src.getWidth(); i++) {
				pixels[i + j * src.getWidth()] = (int)((src.getPixel(i, j, Image.R) << 16) + (src.getPixel(i, j, Image.G) << 8) + src.getPixel(i, j, Image.B));
			}
		}
		biOut.setRGB(0, 0, src.getWidth(), src.getHeight(), pixels, 0, src.getWidth());
		
		// Save the file
		try {
			ImageIO.write(biOut, "PNG", new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Write a database to a folder
	 * File names will be like 1.png, 2.png, 3.png, etc.
	 * 
	 * @param src
	 *  The image database to write
	 * @param dest
	 *  The destination folder
	 */
	public void writeDB(ImageDB src, String dest) {
		
		// Add a slash to dest if needed
		String addSlash = (!dest.substring(dest.length() - 1).equals("\\") && !dest.substring(dest.length() - 1).equals("/")) ? "/" : "";
		
		// Save all the images in the database
		int current = 0;
		for (Image img : src) {
			write(img, dest + addSlash + current + ".png");
			current++;
		}
		
	}

}
