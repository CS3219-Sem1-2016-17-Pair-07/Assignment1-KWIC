package shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class InputStorage {

	ArrayList<String> lines;
	HashSet<String> ignoreWords;

	private static InputStorage instance = null;

	private InputStorage(ArrayList<String> linesAL, HashSet<String> ignoreWordsHS) {
		this.lines = linesAL;
		this.ignoreWords = ignoreWordsHS;
	}

	public static InputStorage getInstance(ArrayList<String> linesAL, HashSet<String> ignoreWordsHS) throws IOException {
		if (instance == null) {
			instance = new InputStorage(linesAL, ignoreWordsHS);
		}
		return instance;
	}

	public static InputStorage getInstance() {
		return instance;
	}

	public String getLine(int index) {
		return lines.get(index);
	}

	public int getSize() {
		return lines.size();
	}

	public boolean checkIgnoreWords(String word) {
		return ignoreWords.contains(word.toLowerCase());
	}

	public HashSet<String> getIgnoreWords() {
		return ignoreWords;
	}

	public void clearInstance() {
		instance = null;
	}
}
