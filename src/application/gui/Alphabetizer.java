package application.gui;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
	
	private ArrayList<String> alphabetized;
	
	public Alphabetizer(ArrayList<String> fromCircularShift){
		this.alphabetized = fromCircularShift;
		alphabetized();
	}
	
	private void alphabetized(){
		Collections.sort(alphabetized);
	}	
	
	public ArrayList<String> getAlphabetized(){
		return alphabetized;
	}
}
