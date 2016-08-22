package application.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Alphabetizer {
	
	private ArrayList<String> alphabetized;
	private ArrayList<String> lines;
	
	public Alphabetizer(ArrayList<String> lines, HashSet<String> ignoreWords){
		this.lines = lines;
		alphabetized();
		new Output(alphabetized, ignoreWords);
	}
	
	private void alphabetized(){
		Collections.sort(lines);
		alphabetized = lines;
	}	
}
