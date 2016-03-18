/**
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
	
	/*
	 * Store data from char array
	 */
	public Image (char[] img, int label, int width, int height) {
		this.img = img;
		this.label = label;
		this.width = width;
		this.height = height;
	}
	
	/*
	 * Store data from CSV
	 */
	public Image (String imgLine, int label, int width, int height) {
		
		// Convert the CSV string to char[]
		String[] img = imgLine.split(",");
		int size = (int) Math.sqrt(img.length/3);
		this.img = new char[img.length];
		for (int i = 0; i < size; i++) {
			this.img[i] = (char)Integer.parseInt(img[(i%3)*size+(i/3)]);
		}
		
		// Store the informations
		this.label = label;
		this.width = width;
		this.height = height;
		
	}

	/**
	 * Returns the raw image buffer.
	 * @return image buffer.
	 */
	char[] getBuffer(){
		return img;
	}
	
	/**
	 * Returns a pixel value.
	 * @param x : x coordinate
	 * @param y : y coordinate
	 * @param color : color ID (Image.R, Image.G, Image.B or 0, 1, 2)
	 * @return Pixel value.
	 */
	char getPixel(int x, int y, int color){
		return img[(y * width + x) * 3 + color];
	}
}
