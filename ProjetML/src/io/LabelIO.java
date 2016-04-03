/**
 * LavelSaver
 * 
 * Saves labels into text files.
 * 
 * @author Jules Pénuchot
 */

package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import image.*;

public class LabelIO {
	/**
	 * Saves an Image database's labels into a text file.
	 * @param imdb : Image database
	 * @param dest : Destination file
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void saveLabels(ImageDB imdb, String dest) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter(dest, "UTF-8");
		
		for(Image img : imdb){
			writer.println(img.getLabel());
		}
		
		writer.close();
	}
	
	/**
	 * Reads labels from a .predict file.
	 * @param src : .predict file path
	 * @return Labels in an ArrayList
	 * @throws IOException
	 */
	public static ArrayList<Integer> readLabels(String src) throws IOException{
		FileInputStream fs = new FileInputStream(src);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		String ln;
		
		while((ln = br.readLine()) != null){
			res.add(Integer.getInteger(ln));
		}
		
		return res;
	}
}
