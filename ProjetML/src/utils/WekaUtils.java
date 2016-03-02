package utils;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WekaUtils {
	
	/**
	 * Converts an Arff file into a CSV file.
	 * @param	source		The Arff source file
	 * @param	destination	The CSV destination file
	 * @throws IOException
	 */
	public static void Arff2CSV(String source, String destination) throws IOException{
		//	Loader init
		ArffLoader loader = new ArffLoader();
		loader.setSource(new File(source));
		
		//	Getting instances
		Instances data = loader.getDataSet();
		
		//	Saver init
		CSVSaver saver = new CSVSaver();
		saver.setInstances(data);
		
		//	Saving instances
		saver.setFile(new File(destination));
		saver.writeBatch();
	}
	
	/**
	 * Converts a CSV file into an Arff file.
	 * @param source		The CSV source file
	 * @param destination	The Arff destination file
	 * @throws IOException
	 */
	public static void CSV2Arff(String source, String destination) throws IOException{
		 // load CSV
	    CSVLoader loader = new CSVLoader();
	    loader.setSource(new File(source));
	    Instances data = loader.getDataSet();//get instances object
	    
	    // save ARFF
	    ArffSaver saver = new ArffSaver();
	    saver.setInstances(data);//set the dataset we want to convert
	    //and save as ARFF
	    saver.setFile(new File(destination));
	    saver.writeBatch();
	}
	
	/**
	 * Adds a header line to the specified file and saves it in dest.
	 * @param source	Source CSV file
	 * @param dest		Destination CSV file
	 * @throws FileNotFoundException
	 */
	public static void addCSVHeader(String source, String dest) throws FileNotFoundException{
		
	}
}
