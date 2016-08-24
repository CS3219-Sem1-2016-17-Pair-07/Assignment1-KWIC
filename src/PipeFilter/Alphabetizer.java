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
		outPipe.write(new Information(temp, info.getIgnoreWords()));
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
