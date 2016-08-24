package shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import application.gui.MainPage;

/*
 * Input class to read in data from the UI to store into another class
 */

public class Input {

	private ArrayList<String> linesAL;
	private HashSet<String> ignoreWordsHS;

	// Stores the data into shared Line
	public Input() throws IOException {
		linesAL = removeInputDelimiters(MainPage.getInstance().getInputLines().getText());
		ignoreWordsHS = removeIgnoreWordsDelimiters(MainPage.getInstance().getIgnoreWords().getText());
		InputStorage.getInstance(linesAL, ignoreWordsHS);
	}

	private HashSet<String> removeIgnoreWordsDelimiters(String ignoreWords) {
		String[] tempIgnoreWords = ignoreWords.split(",");
		HashSet<String> ignoreWordsHS = new HashSet<String>();
		for (int i = 0; i < tempIgnoreWords.length; i++) {
			ignoreWordsHS.add(tempIgnoreWords[i].trim().toLowerCase());
		}
		return ignoreWordsHS;
	}

	private ArrayList<String> removeInputDelimiters(String lines) {
		String[] tempLines = lines.split(",");
		for (int i = 0; i < tempLines.length; i++) {
			tempLines[i] = tempLines[i].trim();
		}
		ArrayList<String> linesAL = new ArrayList<String>(Arrays.asList(tempLines));
		return linesAL;
	}
}
