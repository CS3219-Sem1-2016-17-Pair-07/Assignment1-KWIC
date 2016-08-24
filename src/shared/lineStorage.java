package shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class LineStorage {

	ArrayList<String> lines;
	HashSet<String> ignoreWords;

	private static LineStorage instance = null;

	private LineStorage(ArrayList<String> linesAL, HashSet<String> ignoreWordsHS) {
		this.lines = linesAL;
		this.ignoreWords = ignoreWordsHS;
	}

	public static LineStorage getInstance(ArrayList<String> linesAL, HashSet<String> ignoreWordsHS) throws IOException {
		if (instance == null) {
			instance = new LineStorage(linesAL, ignoreWordsHS);
		}
		return instance;
	}

	public static LineStorage getInstance() {
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
}
