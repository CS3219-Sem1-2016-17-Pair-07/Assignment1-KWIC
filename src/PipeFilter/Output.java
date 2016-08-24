package PipeFilter;

import java.io.IOException;
import java.util.ArrayList;

import application.gui.MainPage;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Output extends Thread {

	private Pipe inPipe;
	private Information prevInfo;
	
	public Output(Pipe inPipe) {
		this.inPipe = inPipe;
	}

	private void showOutput() throws IOException {
		Information info = inPipe.read();
		
		// If input is modified, update output
		if(prevInfo == null || (!prevInfo.equals(info) && info!=null)){
			prevInfo = info;
			ArrayList<String> lines = info.getLines();
			String tempStr = "";
			
			for (int i = 0; i < lines.size(); i++) {
				tempStr = tempStr + lines.get(i)+ "\n";
			}
			tempStr = tempStr.trim();
			final String finalStr = tempStr;
			TextArea textArea = MainPage.getInstance().getPipeKWICIndex();
			// Need to wait for FX thread to modify
			Platform.runLater(new Runnable() {
	            @Override public void run() {
	            	textArea.setText(finalStr);
	            }
	        });
		}
	}


	public void run() {
		while (true) {
			try {
				showOutput();
				// Sleep is needed if not will hang! Listen every sec
				Output.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
