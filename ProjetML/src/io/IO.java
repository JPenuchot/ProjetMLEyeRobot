/*
 * I/O interface for the differents formats
 * 
 * @author Théophile Walter
 */

package io;

import image.*;

public interface IO {

	/**
	 * Read an image
	 * 
	 * @param src
	 *  The source of the file containing the image
	 * @return
	 *  An Image
	 */
	public Image read ( String src);
	
	/**
	 * Read an image database from file/folder
	 * 
	 * @param src
	 *  The source file/folder of the database
	 * @return
	 *  An ImageDB
	 */
	public ImageDB readDB ( String src);
	
	/**
	 * Write an image to a file
	 * 
	 * @param src
	 *  The image to write
	 * @param dest
	 *  The destination file
	 */
	public void write ( Image src, String dest);
	
	/**
	 * Write a database to a file/folder
	 * 
	 * @param src
	 *  The image database to write
	 * @param dest
	 *  The destination file/folder
	 */
	public void writeDB (ImageDB src, String dest);
	
}
