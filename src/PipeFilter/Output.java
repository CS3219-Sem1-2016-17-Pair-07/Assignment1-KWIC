package PipeFilter;

import java.util.ArrayList;
import java.util.HashSet;

import application.gui.MainPage;

public class Output extends Thread {

	private Pipe inPipe;

	public Output(Pipe inPipe) {
		this.inPipe = inPipe;
	}

	private void showOutput() {
		Information info = inPipe.read();
		ArrayList<String> lines = info.getLines();
		String tempStr = "";
		// If input is modified, update output
		for (int i = 0; i < lines.size(); i++) {
			tempStr = lines.get(i) + "\n" + tempStr;
		}
		tempStr = tempStr.trim();
		if (!tempStr.equals(MainPage.pipeKWICIndex.getText())) {
			// Update output using tempStr
			MainPage.pipeKWICIndex.setText(tempStr);
		}
	}

	public void run() {
		while (true) {
			try {
				showOutput();
			} catch (Exception e) {

			}
		}
	}
}
