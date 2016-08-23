package PipeFilter;

import java.util.ArrayList;
import java.util.HashSet;

public class Information {
	
	private ArrayList<String> lines;
	private HashSet<String> ignoreWords;
	
	public Information(ArrayList<String> lines, HashSet<String> ignoreWords){
		this.lines = lines;
		this.ignoreWords = ignoreWords;
	}
	
	public ArrayList<String> getLines(){
		return lines;
	}
	
	public HashSet<String> getIgnoreWords(){
		return ignoreWords;
	}
}
