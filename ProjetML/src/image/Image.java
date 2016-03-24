/*
 * Class Image
 *
 *  Stores images in raw buffers.
 *
 *  @author Jules Pénuchot, Théophile Walter
 */

package image;

import java.util.Arrays;

public class Image {
	
	public static final int R = 0;
	public static final int G = 1;
	public static final int B = 2;
	
	private int label;
	private int width, height;
	private char[] img;
	
	/**
	 * Store data from char array
	 */
	public Image (char[] img, int width) {
		this.img = Arrays.copyOf(img, img.length);
		this.label = 0;
		this.width = width;
		this.height = img.length / 3 / width;
	}
	
	/**
	 * Store data from char array
	 */
	public Image (char[] img, int width, int label) {
		this.img = img;
		this.width = width;
		this.height = img.length / 3 / width;
		this.label = label;
	}

	/**
	 * Returns the raw image buffer.
	 * @return image buffer.
	 */
	public char[] getBuffer(){
		return img;
	}
	
	/*
	 * Set the color of a pixel
	 */
	public void setPixel(int x, int y, int color, char value) {
		img[(y * width + x) * 3 + color] = value;
	}
	
	/**
	 * Returns a pixel value.
	 * @param x : x coordinate
	 * @param y : y coordinate
	 * @param color : color ID (Image.R, Image.G, Image.B or 0, 1, 2)
	 * @return Pixel value.
	 */
	public char getPixel(int x, int y, int color){
		return img[(y * width + x) * 3 + color];
	}
	
	/**
	 * Set the label
	 */
	public void setLabel ( int label) {
		this.label = label;
	}
	
	/**
	 * Get the label
	 */
	public int getLabel() { return label; }
	
	/**
	 * Get the width
	 */
	public int getWidth() { return width; }
	
	/**
	 * Get the height
	 */
	public int getHeight() { return height; }
	
}
