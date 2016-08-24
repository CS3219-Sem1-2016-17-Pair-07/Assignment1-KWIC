package PipeFilter;

import java.util.ArrayList;
import java.util.Collections;

/*
 * This class capitalize the first letter of every line and sorts them according to alphabetical order
 */
public class Alphabetizer extends Thread {
	
	private Pipe inPipe;
	private Pipe outPipe;
	private Information prevInfo;
	
	public Alphabetizer(Pipe inPipe, Pipe outPipe){
		this.inPipe = inPipe;
		this.outPipe = outPipe;
	}
	
	private void alphabetized(){
		Information info = inPipe.read();
		if(prevInfo == null || (!prevInfo.equals(info) && info!=null)){
			prevInfo = info;
			ArrayList<String> temp = info.getLines();
			temp = capKeywords(temp);
			Collections.sort(temp);
			outPipe.write(new Information(temp, info.getIgnoreWords()));
		}
	}	
	
	private ArrayList<String> capKeywords(ArrayList<String> lines){
		for(int i=0; i<lines.size(); i++){
			String tempStr = lines.get(i);
			lines.set(i, tempStr.substring(0, 1));
			
			if(tempStr.length() > 1){
				lines.set(i, tempStr.substring(0, 1).toUpperCase() + tempStr.substring(1).toLowerCase());
			} else {
				lines.set(i, tempStr.substring(0, 1).toUpperCase());
			}
		}
		return lines;
	}
	
	public void run() {
		while(true){
			try{
				alphabetized();
				// Sleep is needed if not will hang! Listen every sec
				Alphabetizer.sleep(1000);
			} catch(Exception e){
				System.out.println("Alphabetizer encounters error : " + e.getMessage());
			}
		}
    }
	
}
