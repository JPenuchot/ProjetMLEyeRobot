/*
 * I/O interface for the differents formats
 * 
 * @author Théophile Walter
 */

package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import image.Image;
import image.ImageDB;

public interface IO {

	/**
	 * Read an image
	 * 
	 * @param src
	 *  The source of the file containing the image
	 * @param n
	 *  The number of the image in the file (only for the CSV)
	 * @return
	 *  An Image
	 * @throws IOException 
	 */
	public Image read ( String src, int n) throws IOException;
	
	/**
	 * Read an image database from file/folder
	 * 
	 * @param src
	 *  The source file/folder of the database
	 * @return
	 *  An ImageDB
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	public ImageDB readDB ( String src) throws IOException;
	
	/**
	 * Write an image to a file
	 * 
	 * @param src
	 *  The image to write
	 * @param dest
	 *  The destination file
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public void write ( Image src, String dest) throws FileNotFoundException, UnsupportedEncodingException;
	
	/**
	 * Write a database to a file/folder
	 * 
	 * @param src
	 *  The image database to write
	 * @param dest
	 *  The destination file/folder
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public void writeDB (ImageDB src, String dest) throws FileNotFoundException, UnsupportedEncodingException;
	
}
