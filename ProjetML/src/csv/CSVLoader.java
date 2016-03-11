/*
 * Class CSVLoader
 * 
 * Implements the CSV interface.
 * 
 * @author Jules Pénuchot, Théophile Walter
 */

package csv;

import java.util.ArrayList;

/*
 * Allows loading and handling of CSV data.
 * Specify the data type.
 */
public class CSVLoader<DataType> {
	
	/*
	 * Attributes to store the data
	 */
	private ArrayList<ArrayList<DataType>> data;

	/*
	 * Constructor, load a CSV file
	 * 
	 * @params
	 *   file - The path to the CSV file to load
	 * @return
	 *   None.
	 */
	public CSVLoader ( String file) { }
	
	/*
	 * Return an ArrayList of values in a specific line from the CSV
	 * 
	 * @params
	 *   line - Line number (starts from 0)
	 * @return
	 *   An ArrayList of values in a specific line from the CSV
	 */
	public ArrayList<DataType> getLine ( int line) {
		return null;
	}
	
	/*
	 * Set the values in a line from an ArrayList
	 * 
	 * @params
	 *   line - Line number where data must be rempaced (starts from 0)
	 *   data - An ArrayList of DataType containing the data
	 * @return
	 *   true  - Success
	 *   false - Error (may be the line number)
	 */
	public boolean setLine ( int line, ArrayList<DataType> data) {
		return false;
	}
	
	/*
	 * Insert values in a line from an ArrayList
	 * The values where inserted at a specific index
	 * 
	 * @params
	 *   line  - Line number where data must be inserted (starts from 0)
	 *   index - Index in the line where the datas must be inserted
	 *           eg: 0  - Insert at the start of the line
	 *               10 - Let 10 values before insertion
	 *               -1 - Insert at the end
	 *   data  - An ArrayList of DataType containing the data
	 * @return
	 *   true  - Success
	 *   false - Error (may be the line number)
	 */
	public boolean insertInLine ( int line, int index, ArrayList<DataType> data) {
		return false;
	}
	
	/*
	 * Insert a new line in the CSV
	 * 
	 * @params
	 *   line  - The number that the inserted will have (starts from 0)
	 *           eg: 0  - Insert a line at the start of the CVS
	 *               10 - Insert a line at the 11th position
	 *               -1 - Insert a line at the end of the CSV
	 *   data  - An ArrayList of DataType containing the data
	 * @return
	 *   true  - Success
	 *   false - Error (may be the line number)
	 */
	public boolean insertLine ( int line, ArrayList<DataType> data) {
		return false;
	}
	
	/*
	 * Remove a line in the CSV
	 * 
	 * @params
	 *   line - Number of the line to remove (starts from 0)
	 * @return
	 *   true  - Success
	 *   false - Error (may be the line number)
	 */
	public boolean removeLine ( int line) {
		return false;
	}
	
	/*
	 * Set a value in a line and column
	 * 
	 * @params
	 *   line   - The line number where you want to set the value (starts from 0)
	 *   column - The column number where you want to set the value (starts from 0)
	 *   value  - The value to set
	 * @return
	 *   true  - Success
	 *   false - Error (may be the line/column number)
	 */
	public boolean setValue ( int line, int column, DataType value) {
		return false;
	}
	
	/*
	 * Get a value in a line and column
	 * 
	 * @params
	 *   line   - The line number where you want to get the value (starts from 0)
	 *   column - The column number where you want to get the value (starts from 0)
	 * @return
	 *   The requested value (in DataType)
	 *   null if the line/column does not exists
	 */
	public DataType getValue ( int line, int column) {
		return null;
	}
	
	/*
	 * Save the current data to a file
	 * 
	 * @params
	 *   file - The path of the CSV file to save
	 *   line - (optionnal) The maximum number of lines to save
	 *          eg: 3 - Save the 3 first lines to the file
	 * @return
	 *   true  - Success
	 *   false - Error (may be a file IO error)
	 */
	public boolean save ( String file) {
		return false;
	}
	
}
