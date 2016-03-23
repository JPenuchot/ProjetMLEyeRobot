package statistics;

import image.*;

public class ImageStats {
	/**
	 * Computes the RGB histogram. The result is a histogram where the RGB values are interlaced.
	 * Ex : The number of red pixels of value 150 will be located at 150 * 3 + 0 = 450. 
	 * @return histogram.
	 */
	public static long[] histogram(Image img){
		long[] res = new long[768]; //	256 * 3
		for(int i = 0; i < img.getBuffer().length; i++){
			res[img.getBuffer()[i] * 3 + (i % 3)]++;
		}
		return res;
	}

	/**
	* Computes the ratio of null values.
	* @return image sparsity
	*/
	public static double sparsity(Image img){
		int nullCnt = 0;
		for(char px : img.getBuffer()){
			if(px == 0)
				nullCnt++;
		}
		
		return (double)nullCnt / (double)img.getBuffer().length;
	}
	
	/**
	 * Outputs the image's label.
	 * @return	image label
	 */
	public static int label(Image img){
		return img.getLabel();
	}
}
