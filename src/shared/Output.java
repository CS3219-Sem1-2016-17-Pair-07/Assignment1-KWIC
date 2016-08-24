package shared;

import java.util.ArrayList;

public class Output {
	private ArrayList<String> outputLines;

	public Output() {
		outputLines = new ArrayList<String>();
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
}
