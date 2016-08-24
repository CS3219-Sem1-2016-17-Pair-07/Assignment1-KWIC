package shared;

import java.io.IOException;

import application.gui.MainPage;

/*
 * Main controller for shared data architecture
 */

public class Shared {

	private InputStorage inputStorage;
	private OutputStorage outputStorage;

	public Shared(String lines, String ignoreWords) throws IOException {
		// Put lines and ignore words into input class
		inputStorage = new InputStorage(lines, ignoreWords);
		// Initialize output class
		outputStorage = new OutputStorage();
		// Calls the Circular Shifter
		new CircularShift(inputStorage, outputStorage);
		// Calls the Alphabetizer
		new Alphabetizer(outputStorage.getOutputLines(), inputStorage.getIgnoreWords());
		// Set the output
		MainPage.getInstance().getSharedKWICIndex().setText(outputStorage.getOutput());
	}
}
