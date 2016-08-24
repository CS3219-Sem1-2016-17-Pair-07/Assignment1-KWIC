package PipeFilter;

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
		Collections.sort(info.getLines());
		outPipe.write(new Information(info.getLines(), info.getIgnoreWords()));
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
