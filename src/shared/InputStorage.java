package shared;

import java.util.ArrayList;
import java.util.HashSet;

public class InputStorage {

	ArrayList<String> lines;
	HashSet<String> ignoreWords;

	public InputStorage(ArrayList<String> lines, HashSet<String> ignoreWords) {
		this.lines = lines;
		this.ignoreWords = ignoreWords;
	}

	public String getLine(int index) {
		return lines.get(index);
	}

	public int getSize() {
		return lines.size();
	}
	
	public boolean checkIgnoreWords(String word){
		return ignoreWords.contains(word.toLowerCase());
	}
}
