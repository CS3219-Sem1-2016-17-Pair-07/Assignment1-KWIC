package shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Shared {

	private InputStorage inputStorage;
	private OutputStorage outputStorage;

	public Shared(String lines, String ignoreWords) {
		String[] tempLines = lines.split(",");
		for (int i = 0; i < tempLines.length; i++) {
			tempLines[i] = tempLines[i].trim();
		}
		ArrayList<String> lines1 = new ArrayList(Arrays.asList(tempLines));

		String[] tempIgnoreWords = ignoreWords.split(",");
		HashSet<String> ignoreWords1 = new HashSet<String>();
		for (int i = 0; i < tempIgnoreWords.length; i++) {
			ignoreWords1.add(tempIgnoreWords[i].trim().toLowerCase());
		}
		inputStorage = new InputStorage(lines1, ignoreWords1);
		outputStorage = new OutputStorage();
		new CircularShift(inputStorage, outputStorage);
		new Alphabetizer(outputStorage.getOutputLines(), ignoreWords1);
	}
	
	public String getOutput(){
		return outputStorage.getOutput();
	}

}
