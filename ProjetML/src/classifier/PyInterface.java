/**
 *  Class PyInterface
 *
 *  Acts as a Java/Python interface to run ML tasks powered by Python scripts.
 *
 *  @author Jules Pénuchot
 */

import java.lang.String;

package classifier;

class PyInterface{
  //  Where the training datasets are located
  private String trainDataFolder = "../data/in/train";
  //  Where the testing datasets are located
  private String testDataFolder = "../data/in/test";

  //  Where the input datasets are located (Unknown labels)
  private String inputDataFolder = "../data/in/classify";
  //  Where the output labels will be located (Guessed labels)
  private String outputDataFolder = "../data/out/labels";
}
