package shared;

import java.util.ArrayList;
import java.util.HashSet;

public class Shared {

	private InputStorage inputStorage;
	private OutputStorage outputStorage;

	public Shared(ArrayList<String> lines, HashSet<String> ignoreWords) {
		inputStorage = new InputStorage(lines, ignoreWords);
		outputStorage = new OutputStorage();
		new CircularShift(inputStorage, outputStorage);
		new Alphabetizer(outputStorage.getOutputLines(), ignoreWords);
	}
	
	public String getOutput(){
		return outputStorage.getOutput();
	}

}
