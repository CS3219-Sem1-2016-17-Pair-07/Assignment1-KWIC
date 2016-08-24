package shared;

import java.io.IOException;

import application.gui.MainPage;

/*
 * Main controller for shared data architecture
 */

public class Shared {

	private Output output;

	public Shared() throws IOException {
		new Input();
		// Initialize output class
		output = new Output();
		// Calls the Circular Shifter
		new CircularShift(output);
		// Calls the Alphabetizer
		new Alphabetizer(output.getOutputLines(), LineStorage.getInstance().getIgnoreWords());
		// Set the output
		MainPage.getInstance().getSharedKWICIndex().setText(output.getOutput());
	}
}
