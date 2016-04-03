/**
 *  Class PyInterface
 *
 *  Acts as a Java/Python interface to run ML tasks powered by Python scripts.
 *
 *  @author Jules Pénuchot
 */

 package classifier;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.String;

import image.*;
import io.*;

public class PyInterface{
  //  SRIPT LOCATIONS

  //  Training script location
  private String trainScriptLocation = "../scripts/train.py";
  //  Classifying script location
  private String classifyScriptLocation = "../scripts/classify.py";

  //  DATA LOCATIONS

  //  Where the training datasets are located
  private String trainDataFolder = "../classifier/data/in/train";
  //  Where the testing datasets are located
  private String testDataFolder = "../classifier/data/in/test";

  //  Where the input datasets are located (Unknown labels)
  private String inputDataFolder = "../classifier/data/in/classify";
  //  Where the output labels will be located (Guessed labels)
  private String outputDataFolder = "../classifier/data/out/labels";
  
  
  public void train(ImageDB imdb){
	  System.out.println("Function not implemented... Yet.");
	  return;
  }
  
  /**
   * Classifies an every Image in an ImageDB.
   * @param imdb : ImageDB to classify
 * @throws UnsupportedEncodingException 
 * @throws FileNotFoundException 
   */
  public void classify(ImageDB imdb) throws FileNotFoundException, UnsupportedEncodingException{
	  //	Sauvegarde de la DB
	  IO writer = new CSVContiguous();
	  writer.writeDB(imdb, inputDataFolder);
	  
	  //	Lancement du script
	  
	  
	  //	Lecture des labels
	  
	  //	Assignation des labels
	  
  }
  
  /**
   * Classifies an image.
   * @param img : Image to classify
   */
  public void classify(Image img){
	  //	TODO : Implementation
	  img.setLabel(0);
  }
}
