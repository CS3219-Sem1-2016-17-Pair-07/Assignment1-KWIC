package application.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class MainPage extends AnchorPane {
	
	private static final String MAIN_PAGE_FXML_URL = "MainPage.fxml";
	
	@FXML
	public Label inputLinesLabel;
	@FXML
	private Label ignoreWordsLabel;
	@FXML
	private Label kwicIndexLabel;
	@FXML
	private Button generateBtn;
	@FXML
	private TextArea inputLines;
	@FXML
	private TextArea ignoreWords;
	@FXML
	private TextArea kwicIndex;
	

	public MainPage() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MAIN_PAGE_FXML_URL));
		loadFromFxml(fxmlLoader);
	}
	
	private void loadFromFxml(FXMLLoader fxmlLoader) throws IOException {
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
	}
	
}