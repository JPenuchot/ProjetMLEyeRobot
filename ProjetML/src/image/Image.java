/**
 * Class Image
 *
 *  Stores images in raw buffers.
 *
 *  @author Jules Pénuchot
 */

package image;

public class Image{
	public static final int R = 0;
	public static final int G = 1;
	public static final int B = 2;
	
	private int label;

	private int width, height;
	private char[] img;

	/**
	 * Returns the raw image buffer.
	 * @return image buffer.
	 */
	char[] getBuffer(){	return img;	}
	
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
