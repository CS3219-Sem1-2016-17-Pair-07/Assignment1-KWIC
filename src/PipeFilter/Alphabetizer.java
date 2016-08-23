package PipeFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Alphabetizer extends Thread {
	
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
	
	public void run() {
		try {
			while (true) {
				//transform();
			}
		} catch (Exception ex) {
			// input stream closed
		}
    }
	
}
