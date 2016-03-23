package statistics;

import image.*;

public class ImageStats {
	private Image img;

	public ImageStats(Image _img){
		img = _img;
	}

	/**
	 * Computes the vertical histogram.
	 * @return vertical histogram
	 */
	public char[] verticalHistogram(){
		return null;
	}

	/**
	 * Computes the horizontal histogram.
	 * @return horizontal histogram
	 */
	public char[] horizontalHistogram(){
		return null;
	}

	/**
	* Computes the ratio of null values.
	* @return image sparsity
	*/
	public double sparsity(){
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
	public int label(){
		return img.getLabel();
	}
}
