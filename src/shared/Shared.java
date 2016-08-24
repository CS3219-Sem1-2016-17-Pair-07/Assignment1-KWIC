package shared;

import java.io.IOException;

import application.gui.MainPage;

/*
 * Main controller for shared data architecture
 */

public class Shared {

	private Input input;
	private Output output;

	public Shared() throws IOException {
		// Calls the input to get the data from UI
		input = new Input();
		// Initialize output class
		output = new Output();
		// Calls the Circular Shifter
		new CircularShift(input, output);
		// Calls the Alphabetizer
		new Alphabetizer(output.getOutputLines(), input.getIgnoreWords());
		// Set the output
		MainPage.getInstance().getSharedKWICIndex().setText(output.getOutput());
	}
}
