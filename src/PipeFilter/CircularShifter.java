package PipeFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CircularShifter extends Thread{
	
	private Pipe inPipe;
	private Pipe outPipe;
	
	public CircularShifter(Pipe inPipe, Pipe outPipe){
		this.inPipe = inPipe;
		this.outPipe = outPipe;
	}
	
	public void run(){
		while(true){
			try{
				circularShift();
			} catch(Exception e){
				// No inputs
			}
		}
	}
	
	private void circularShift(){
		Information info = inPipe.read();
		ArrayList<String> shifted = new ArrayList<String>();
		ArrayList<String> lines = info.getLines();
		HashSet<String> ignoreWordsSet = info.getIgnoreWords();
		
		for(int i=0; i< lines.size(); i++){
			ArrayList<String> words = new ArrayList<String>(Arrays.asList(lines.get(i).split(" ")));
			for(int z=0; z < words.size(); z++){
				String keyWord = words.get(0);
				
				if(!ignoreWordsSet.contains(keyWord.toLowerCase())){
					shifted.add(convertToLine(words));
				} else {
					keyWord = keyWord.toLowerCase();
				}
				
				words.remove(0);
				words.add(keyWord);
			}
		}
		
		outPipe.write(new Information(shifted, ignoreWordsSet));
	}	
	
	private String convertToLine(ArrayList<String> words){
		
		String line = "";
		for(int i=0 ; i<words.size(); i++){
			line = line + " " + words.get(i);
		}
		line = line.trim();
		
		return line;
	}
}
