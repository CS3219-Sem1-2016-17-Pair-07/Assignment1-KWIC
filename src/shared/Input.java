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

	ArrayList<String> linesAL;
	HashSet<String> ignoreWordsHS;

	public Input() throws IOException {
		this.linesAL = removeInputDelimiters(MainPage.getInstance().getInputLines().getText());
		this.ignoreWordsHS = removeIgnoreWordsDelimiters(MainPage.getInstance().getIgnoreWords().getText());
		LineStorage.getInstance(linesAL, ignoreWordsHS);
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
