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
		System.out.println(MainPage.pipeKWICIndex.getText());
		if (!tempStr.equals(MainPage.pipeKWICIndex.getText()) || MainPage.pipeKWICIndex.getText() != null) {
			// Update output using tempStr
			System.out.println(tempStr);
			MainPage.pipeKWICIndex.setText(tempStr);
		}
	}

	public void run() {
		while (true) {
			try {
				showOutput();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
