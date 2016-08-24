package shared;

public class Shared {

	private InputStorage inputStorage;
	private OutputStorage outputStorage;

	public Shared(String lines, String ignoreWords) {
		inputStorage = new InputStorage(lines, ignoreWords);
		outputStorage = new OutputStorage();
		new CircularShift(inputStorage, outputStorage);
		new Alphabetizer(outputStorage.getOutputLines(), inputStorage.getIgnoreWords());
	}
	
	public String getOutput(){
		return outputStorage.getOutput();
	}

}
