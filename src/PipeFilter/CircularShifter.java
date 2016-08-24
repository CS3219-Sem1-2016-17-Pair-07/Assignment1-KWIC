package PipeFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * This class circular shift the lines retrieved from the 
 * input pipe and write the results to the output pipe
 */
public class CircularShifter extends Thread{
	
	private Pipe inPipe;
	private Pipe outPipe;
	private Information prevInfo;
	
	public CircularShifter(Pipe inPipe, Pipe outPipe){
		this.inPipe = inPipe;
		this.outPipe = outPipe;
	}
	
	public void run(){
		while(true){
			try{
				circularShift();
				// Sleep is needed if not will hang! Listen every sec
				CircularShifter.sleep(1000);
			} catch(Exception e){
				System.out.println("CircularShifter encounters error : " + e.getMessage());
			}
		}
	}
	
	private void circularShift(){
		Information info = inPipe.read();
		// If first time running or previous info is different
		if(prevInfo == null || (!prevInfo.equals(info)&& info!=null)){
			
			prevInfo = info;
			ArrayList<String> shifted = new ArrayList<String>();
			ArrayList<String> lines = info.getLines();
			HashSet<String> ignoreWordsSet = info.getIgnoreWords();
			
			for(int i=0; i< lines.size(); i++){
				ArrayList<String> words = new ArrayList<String>(Arrays.asList(lines.get(i).split(" ")));
				for(int z=0; z < words.size(); z++){
					String keyWord = words.get(0);
					
					if(!ignoreWordsSet.contains(keyWord.toLowerCase())){
						// Keyword found, add to output lines
						shifted.add(convertToLine(words));
					} else {
						keyWord = keyWord.toLowerCase();
					}
					
					words.remove(0);
					words.add(keyWord);
				}
			}
			
			// Pump info to Alphabetizer
			outPipe.write(new Information(shifted, ignoreWordsSet));
		}
	}	
	
	// Convert arraylist to lines 
	private String convertToLine(ArrayList<String> words){
		
		String line = "";
		for(int i=0 ; i<words.size(); i++){
			line = line + " " + words.get(i);
		}
		line = line.trim();
		
		return line;
	}
}
