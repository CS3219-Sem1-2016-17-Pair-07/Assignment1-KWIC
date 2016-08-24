package PipeFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import application.gui.MainPage;
import javafx.scene.control.TextArea;

public class Output extends Thread {

	private Pipe inPipe;

	public Output(Pipe inPipe) {
		this.inPipe = inPipe;
	}

	private void showOutput() throws IOException {
		Information info = inPipe.read();
		ArrayList<String> lines = info.getLines();
		String tempStr = "";
		// If input is modified, update output
		for (int i = 0; i < lines.size(); i++) {
			tempStr = lines.get(i) + "\n" + tempStr;
		}
		tempStr = tempStr.trim();
		TextArea textArea = MainPage.getInstance().getPipeKWICIndex();
		if (!tempStr.equals(textArea.getText())) {
			// Update output using tempStr
			textArea.setText(tempStr);
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
