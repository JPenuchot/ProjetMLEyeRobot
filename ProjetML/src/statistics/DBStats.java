package statistics;

import image.*;

public class DBStats {
	/**
	 * Computes the sum of the DB's images' histograms.
	 * @param Image dataset to work on.
	 * @return Sum of the histograms.
	 */
	public static long[] histogram(ImageDB db){
		long[] res = new long[768];
		
		for(Image img : db){
			long[] imhs = ImageStats.histogram(img);
			for(int i = 0; i < 768; i++){
				res[i] += imhs[i];
			}
		}
		
		return res;
	}
	
	/**
	 * Computes the sparsity of the whole dataset.
	 * @param Image dataset to work on.
	 * @return Dataset sparsity.
	 */
	public static double sparsity(ImageDB db){
		double res = 0;
		for(Image img : db){
			res += ImageStats.sparsity(img);
		}
		return res / (double)db.size();
	}
	
	public static int[] labelEffectives(ImageDB db){
		//	Getting max label value first
		int mxLabel = 0;
		
		for(Image img : db){
			if (img.getLabel() > mxLabel)
				mxLabel = img.getLabel();
		}
		
		int[] res = new int[mxLabel + 1];
		
		for(Image img : db){
			res[img.getLabel()]++;
		}
		
		return res;
	}
}
