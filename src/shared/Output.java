package shared;

import java.io.IOException;

import application.gui.MainPage;

/*
 * Class to retrieve the output data and show it on the UI
 */

public class Output {

	public Output() throws IOException {
		MainPage.getInstance().getSharedKWICIndex().setText(IndexStorage.getInstance().getOutput());
		// Need to clear instances so button can work again
		IndexStorage.getInstance().clearInstance();
		InputStorage.getInstance().clearInstance();
	}
}
