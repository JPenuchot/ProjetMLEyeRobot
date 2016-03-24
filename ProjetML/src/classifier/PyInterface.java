/**
 *  Class PyInterface
 *
 *  Acts as a Java/Python interface to run ML tasks powered by Python scripts.
 *
 *  @author Jules Pénuchot
 */

 package classifier;

import java.lang.String;

import image.*;
import io.*;

public class PyInterface{
  //  SRIPT LOCATIONS

  //  Training script location
  private String trainScriptLocation = "../classifier/train.py";
  //  Classifying script location
  private String classifyScriptLocation = "../classifier/classify.py";

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
   */
  public void classify(ImageDB imdb){
	  for(Image img : imdb){
		  classify(img);
	  }
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
