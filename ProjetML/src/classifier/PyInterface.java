/**
 *  Class PyInterface
 *
 *  Acts as a Java/Python interface to run ML tasks powered by Python scripts.
 *
 *  @author Jules Pénuchot
 */

 package classifier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.util.ArrayList;

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
  private String trainDataFile = "../classifier/data/in/train.csv";

  //  Where the input datasets are located (Unknown labels)
  private String inputDataFile = "../classifier/data/in/classify.csv";
  //  Where the output labels will be located (Guessed labels)
  private String outputDataFile = "../classifier/data/out/labels.predict";
  
  
  public void train(ImageDB imdb) throws FileNotFoundException, UnsupportedEncodingException{
	  //	Sauvegarde de la DB
	  IO writer = new CSVContiguous();
	  writer.writeDB(imdb, trainDataFile);
	  
	  //	Lancement du script
	  
	  //	TODO
	  
  }
  
  /**
   * Classifies an every Image in an ImageDB.
   * @param imdb : ImageDB to classify
 * @throws IOException 
   */
  public void classify(ImageDB imdb) throws IOException{
	  //	Sauvegarde de la DB
	  IO writer = new CSVContiguous();
	  writer.writeDB(imdb, inputDataFile);
	  
	  //	Lancement du script

	  //	TODO
	  
	  //	Lecture des labels
	  ArrayList<Integer> labels = LabelIO.readLabels(outputDataFile);
	  
	  //	Assignation des labels
	  for(int i = 0; i < labels.size(); i++){
		  imdb.get(i).setLabel(labels.get(i).intValue());
	  }
  }
  
  /**
   * Classifies an image.
   * @param img : Image to classify
   */
  public void classify(Image img){
	  //	Sauvegarde de la DB
	  
	  //	Lancement du script
	  
	  //	TODO
	  
	  //	Lecture du label
	  
	  
	  //	Assignation du label
  }
}
