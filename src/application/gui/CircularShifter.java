package application.gui;

import java.util.ArrayList;
import java.util.Collections;

public class CircularShifter {
	
	private ArrayList<String> shifted;
	
	public CircularShifter(ArrayList<String> fromInput){
		this.shifted = fromInput;
		circularShift();
	}
	
	private void circularShift(){
		for(int i=0; i<shifted.size(); i++){
			
		}
	}	
	
	public ArrayList<String> getShifted(){
		return shifted;
	}
}
