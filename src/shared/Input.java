package shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import application.gui.MainPage;

/*
 * Temporary input storage area for all input data
 */

public class Input {

	ArrayList<String> linesAL;
	HashSet<String> ignoreWordsHS;

	public Input() throws IOException {
		this.linesAL = removeInputDelimiters(MainPage.getInstance().getInputLines().getText());
		this.ignoreWordsHS = removeIgnoreWordsDelimiters(MainPage.getInstance().getIgnoreWords().getText());
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

	public String getLine(int index) {
		return linesAL.get(index);
	}

	public int getSize() {
		return linesAL.size();
	}

	public boolean checkIgnoreWords(String word) {
		return ignoreWordsHS.contains(word.toLowerCase());
	}

	public HashSet<String> getIgnoreWords() {
		return ignoreWordsHS;
	}
}
