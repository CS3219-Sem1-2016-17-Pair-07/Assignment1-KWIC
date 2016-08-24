package shared;

import java.util.ArrayList;

/*
 * This class will hold all the data that is waiting to get output to the UI
 */

public class IndexStorage {

	private static IndexStorage instance = null;
	private ArrayList<String> outputLines;

	private IndexStorage() {
		outputLines = new ArrayList<String>();
	}

	public static IndexStorage getInstance() {
		if (instance == null) {
			instance = new IndexStorage();
		}
		return instance;
	}

	public void add(String word) {
		outputLines.add(word);
	}

	public ArrayList<String> getOutputLines() {
		return outputLines;
	}

	public String getOutput() {
		String output = "";
		for (int i = 0; i < outputLines.size(); i++) {
			output = output + outputLines.get(i) + "\n";
		}
		return output;
	}

	public void updateAlphabetized(ArrayList<String> tempLines) {
		outputLines = tempLines;
	}

	public void clearInstance() {
		instance = null;
	}

}
