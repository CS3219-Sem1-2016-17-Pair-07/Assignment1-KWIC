package PipeFilter;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer extends Thread {
	
	private Pipe inPipe;
	private Pipe outPipe;
	
	public Alphabetizer(Pipe inPipe, Pipe outPipe){
		this.inPipe = inPipe;
		this.outPipe = outPipe;
	}
	
	private void alphabetized(){
		Information info = inPipe.read();
		ArrayList<String> temp = info.getLines();
		Collections.sort(temp);
	    temp = capKeywords(temp);
		outPipe.write(new Information(temp, info.getIgnoreWords()));
	}	
	
	private ArrayList<String> capKeywords(ArrayList<String> lines){
		for(int i=0; i<lines.size(); i++){
			String tempStr = lines.get(i);
			lines.set(i, tempStr.substring(0, 1));
			/*
			if(tempStr.length() > 1){
				lines.set(i, tempStr.substring(0, 1).toUpperCase());
			} else {
				lines.set(i, tempStr.substring(0, 1).toUpperCase());
			}*/
		}
		return lines;
	}
	
	public void run() {
		while(true){
			try{
				alphabetized();
			} catch(Exception e){
				
			}
		}
    }
	
}
