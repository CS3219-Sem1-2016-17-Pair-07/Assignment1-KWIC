package PipeFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Input extends Thread {
	
	private String inputLines;
	private String inputIgnoreWords;
	private Pipe outPipe;
	
	public Input(String inputLines, String inputIgnoreWords, Pipe outPipe){
		this.inputLines = inputLines;
		this.inputIgnoreWords = inputIgnoreWords;
		this.outPipe = outPipe;
	}
	
	public void run(){
        outPipe.write(parseInput(inputLines,inputIgnoreWords));
	}
	
	public static Information parseInput(String lines, String ignoreWords){
		String [] tempLines = lines.split(",");
		for(int i=0; i<tempLines.length; i++){
			tempLines[i] = tempLines[i].trim();
		}
		ArrayList<String> linesList = new ArrayList<String>(Arrays.asList(tempLines));
		
        String [] tempIgnoreWords = ignoreWords.split(",");
        HashSet<String> ignoreWordsSet = new HashSet<String>();
        for(int i=0; i<tempIgnoreWords.length ;i++){
			ignoreWordsSet.add(tempIgnoreWords[i].trim().toLowerCase());
		}
        return new Information(linesList, ignoreWordsSet);
	}
}
