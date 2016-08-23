package PipeFilter;

import java.util.ArrayList;
import java.util.HashSet;

public class Output extends Thread{
	
	private Pipe inPipe;
	
	public Output(Pipe inPipe){
		this.inPipe = inPipe;
	}
	
	private void showOutput(){
		Information info = inPipe.read();
		ArrayList<String> lines = info.getLines();
		for(int i=0; i<lines.size(); i++){
			System.out.println(lines.get(i));
		}
	}	
	
	public void run(){
		while(true){
			try{
				showOutput();
			} catch (Exception e){
				
			}
		}
	}
}
