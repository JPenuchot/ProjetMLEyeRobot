/*
 * Class Exec
 * Execute a programme and return the output
 * 
 * @author Théophile Walter
 */

package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exec {
	
	private String r = "";

	/**
	 * Run a programm and retrun the standard output
	 * 
	 * @param command
	 *  The commande line of programm to run
	 * @return The StdOut of the programme
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String getProcessStdOut(String command) throws IOException, InterruptedException {

		// Run the process
		final Process p = Runtime.getRuntime().exec(command);
		resetStdOut();

		// Create a thread to get the StdOut
		new Thread(new Runnable() {
			public void run() {
				BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line = null;

				try {
					while ((line = input.readLine()) != null)
						updateStdOut(line + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();

		// Wait the en of the programm
		p.waitFor();

		// Return the out
		return getStdOut();

	}
	
	// Very ugly ^^
	private void updateStdOut(String s) { r += s; }
	private void resetStdOut() { r = ""; }
	private String getStdOut() { return r; }

}
