/*
 * Class Image
 *
 *  Stores images in raw buffers.
 *
 *  @author Jules Pénuchot, Théophile Walter
 */

package image;

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
	public Image (char[] img, int width, int height) {
		this.img = img;
		this.label = 0;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Store data from CSV
	 */
	public Image (String imgLine,  int width, int height) {
		
		// Convert the CSV string to char[]
		String[] img = imgLine.split(",");
		int size = (int) Math.sqrt(img.length/3);
		this.img = new char[img.length];
		for (int i = 0; i < size; i++) {
			this.img[i] = (char)Integer.parseInt(img[i]);
			this.img[i+1] = (char)Integer.parseInt(img[i + 2 * size]);
			this.img[i+2] = (char)Integer.parseInt(img[i + 3 * size]);
		}
		
		// Store the informations
		this.label = 0;
		this.width = width;
		this.height = height;
		
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
	
	/**
	 * Set the label
	 */
	public void setLabel ( int label) {
		this.label = label;
	}
	
}
