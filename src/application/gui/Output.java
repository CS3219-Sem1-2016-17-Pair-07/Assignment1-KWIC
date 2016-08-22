package application.gui;

import java.util.ArrayList;
import java.util.HashSet;

public class Output {
	
	private ArrayList<String> lines;
	
	public Output(ArrayList<String> lines, HashSet<String> ignoreWords){
		this.lines = lines;
		showOutput();
	}
	
	private void showOutput(){
		for(int i=0; i<lines.size(); i++){
			System.out.println(lines.get(i));
		}
	}	
}
