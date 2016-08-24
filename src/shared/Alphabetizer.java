package shared;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {

	private ArrayList<String> tempLines;

	public Alphabetizer() {
		tempLines = new ArrayList<String>();
		IndexStorage.getInstance().updateAlphabetized(alphabetize());
	}

	private ArrayList<String> alphabetize() {
		for (int i = 0; i < IndexStorage.getInstance().getOutputLines().size(); i++) {
			String tempStr = IndexStorage.getInstance().getOutputLines().get(i);
			if (tempStr.length() > 1) {
				tempLines.add(tempStr.substring(0, 1).toUpperCase() + tempStr.substring(1, tempStr.length()));
			}
		}
		Collections.sort(tempLines);
		return tempLines;
	}

}
