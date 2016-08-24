package shared;

import java.io.IOException;

/*
 * Main controller for shared data architecture
 */

public class Shared {

	public Shared() throws IOException {
		// Calls the input class to read in data from UI and store into another
		// class
		new Input();
		// Calls the Circular Shifter to do the circular shifting
		new CircularShift();
		// Calls the Alphabetizer to do alphabetizing
		new Alphabetizer();
		// Calls the output class to get the output data and put to UI screen
		new Output();
	}
}
