package application.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import PipeFilter.CircularShifter;
import PipeFilter.PipeAndFilter;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import shared.Shared;

public class MainPage extends AnchorPane {

	private static final String MAIN_PAGE_FXML_URL = "MainPage.fxml";

	@FXML
	public Label inputLinesLabel;
	@FXML
	private Label ignoreWordsLabel;
	@FXML
	private Label kwicIndexLabel;
	@FXML
	private Button sharedBtn;
	@FXML
	private Button pipeFilterBtn;
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
		initialise();
	}

	public TextArea getInputLines() {
		return inputLines;
	}

	public TextArea getIgnoreWords() {
		return ignoreWords;
	}

	public TextArea getKwicIndex() {
		return kwicIndex;
	}

	public Button getSharedButton() {
		return sharedBtn;
	}

	public void initialise() {
		sharedBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				String[] tempLines = inputLines.getText().split(",");
				for (int i = 0; i < tempLines.length; i++) {
					tempLines[i] = tempLines[i].trim();
				}
				ArrayList<String> lines = new ArrayList(Arrays.asList(tempLines));

				String[] tempIgnoreWords = ignoreWords.getText().split(",");
				HashSet<String> ignoreWords = new HashSet<String>();
				for (int i = 0; i < tempIgnoreWords.length; i++) {
					ignoreWords.add(tempIgnoreWords[i].trim().toLowerCase());
				}
				Shared shared = new Shared(lines, ignoreWords);
				kwicIndex.setText(shared.getOutput());
			}
		});
		
		pipeFilterBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				PipeAndFilter pipeAndFilter = new PipeAndFilter(inputLines.getText(), ignoreWords.getText());
			}
		});
		
		
	}
	
}