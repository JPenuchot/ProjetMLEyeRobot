package program;

import image.*;
import io.*; 
import classifier.*;

import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException{
		IO imLoader = new CSVContiguous();
		ImageDB imdb = imLoader.readDB("C:\\Users\\Jules\\git\\ProjetMLEyeRobot\\ProjetML\\data\\local_train.csv");
		
		System.out.println("Just read " + imdb.size() + " images and still standing !");
				
		PyInterface mlModel = new PyInterface();
		
		//	This step is meant to train the TensorFlow model.
		mlModel.train(imdb);
		
		//	Classifying submit_test
		imdb = imLoader.readDB("C:\\Users\\Jules\\git\\ProjetMLEyeRobot\\ProjetML\\data\\submit_test.csv");
		mlModel.classify(imdb);
		
		System.out.println("Successfully classified submit_test.csv, saving labels...");
		
		LabelSaver.saveLabels(imdb, "C:\\Users\\Jules\\git\\ProjetMLEyeRobot\\ProjetML\\data\\submit_valid_result.txt");
		
		//	Classifying submit_valid
		imdb = imLoader.readDB("C:\\Users\\Jules\\git\\ProjetMLEyeRobot\\ProjetML\\data\\submit_valid.csv");
		mlModel.classify(imdb);
		
		System.out.println("Successfully classified submit_valid.csv, saving labels...");
		
		LabelSaver.saveLabels(imdb, "C:\\Users\\Jules\\git\\ProjetMLEyeRobot\\ProjetML\\data\\submit_test_result.txt");
		
	}
}
