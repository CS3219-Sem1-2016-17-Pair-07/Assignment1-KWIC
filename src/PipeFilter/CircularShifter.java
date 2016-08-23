package PipeFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CircularShifter {
	
	private ArrayList<String> shifted;
	private ArrayList<String> lines;
	private HashSet<String> ignoreWords;
	
	public CircularShifter( ArrayList<String> lines, HashSet<String> ignoreWords){
		this.lines = lines;
		this.ignoreWords = ignoreWords;
		shifted = new ArrayList<String>();
		circularShift();
		new Alphabetizer(shifted, ignoreWords);
	}
	
	private void circularShift(){
		for(int i=0; i< lines.size(); i++){
			ArrayList<String> words = new ArrayList(Arrays.asList(lines.get(i).split(" ")));
			for(int z=0; z < words.size(); z++){
				String keyWord = words.get(0);
				
				if(!ignoreWords.contains(keyWord.toLowerCase())){
					shifted.add(convertToLine(words));
				} else {
					keyWord = keyWord.toLowerCase();
				}
				
				words.remove(0);
				words.add(keyWord);
			}
		}
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
