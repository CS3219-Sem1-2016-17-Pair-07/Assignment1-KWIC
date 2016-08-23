package PipeFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Input extends Thread {
	
	private String lines;
	private String ignoreWords;
	private Pipe outPipe;
	
	public Input(String lines, String ignoreWords, Pipe outPipe){
		this.lines = lines;
		this.ignoreWords = ignoreWords;
		this.outPipe = outPipe;
	}
	
	public void run(){
		String [] tempLines = lines.split(",");
		for(int i=0; i<tempLines.length; i++){
			tempLines[i] = tempLines[i].trim();
		}
		ArrayList<String> linesList = new ArrayList<String>(Arrays.asList(tempLines));
		
        String [] tempIgnoreWords = ignoreWords.split(",");
        HashSet<String> ignoreWords = new HashSet<String>();
        for(int i=0; i<tempIgnoreWords.length ;i++){
			ignoreWords.add(tempIgnoreWords[i].trim().toLowerCase());
		}
        outPipe.write(new Information(linesList, ignoreWords));
	}
}
