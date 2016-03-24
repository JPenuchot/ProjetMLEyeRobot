package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import image.*;

public class LabelSaver {
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
}
