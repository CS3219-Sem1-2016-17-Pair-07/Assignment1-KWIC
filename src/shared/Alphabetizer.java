package shared;

import java.util.ArrayList;
import java.util.Collections;

/*
 * This class capitalize the first letter of every index line and sorts them according to alphabetical order
 */
public class Alphabetizer {

	private ArrayList<String> tempLines;

	// Do alphabetize and store it back to the shared index storage
	public Alphabetizer() {
		tempLines = new ArrayList<String>();
		IndexStorage.getInstance().updateAlphabetized(alphabetize());
	}

	// Alphabetize the shared index storage
	private ArrayList<String> alphabetize() {
		for (int i = 0; i < IndexStorage.getInstance().getOutputLines().size(); i++) {
			String tempStr = IndexStorage.getInstance().getOutputLines().get(i);
			if (tempStr.length() > 1) {
				tempLines.add(tempStr.substring(0, 1).toUpperCase() + tempStr.substring(1).toLowerCase());
			} else {
				tempLines.add(tempStr.substring(0, 1).toUpperCase());
			}
		}
		Collections.sort(tempLines);
		return tempLines;
	}

}
