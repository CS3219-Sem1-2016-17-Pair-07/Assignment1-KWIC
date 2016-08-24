package shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * Temporary input storage area for all input data
 */

public class InputStorage {

	ArrayList<String> linesAL;
	HashSet<String> ignoreWordsHS;

	public InputStorage(String lines, String ignoreWords) {
		this.linesAL = removeInputDelimiters(lines);
		this.ignoreWordsHS = removeIgnoreWordsDelimiters(ignoreWords);
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
