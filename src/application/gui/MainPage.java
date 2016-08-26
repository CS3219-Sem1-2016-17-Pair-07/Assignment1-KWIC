package application.gui;

import java.io.IOException;

import PipeFilter.PipeAndFilter;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import shared.Shared;

/*
 * This page contains all the functions for the UI 
 * (Works together with the mainpage.fxml)
 */

public class MainPage extends AnchorPane {

	private static final String MAIN_PAGE_FXML_URL = "MainPage.fxml";

	@FXML
	public Label inputLinesLabel;
	@FXML
	private Label ignoreWordsLabel;
	@FXML
	private Label kwicIndexLabel;
	@FXML
	private Label helpLabel;
	@FXML
	private Button sharedBtn;
	@FXML
	private Button pipeFilterBtn;
	@FXML
	private TextArea inputLines;
	@FXML
	private TextArea ignoreWords;
	@FXML
	private TextArea sharedKWICIndex;
	@FXML
	private TextArea pipeKWICIndex;

	private static MainPage instance = null;

	private MainPage() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MAIN_PAGE_FXML_URL));
		loadFromFxml(fxmlLoader);
	}

	public static MainPage getInstance() throws IOException {
		if (instance == null) {
			instance = new MainPage();
		}
		return instance;
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

	public TextArea getSharedKWICIndex() {
		return sharedKWICIndex;
	}

	public TextArea getPipeKWICIndex() {
		return pipeKWICIndex;
	}

	public Button getSharedButton() {
		return sharedBtn;
	}

	public void initialise() {
		Platform.runLater( () -> this.requestFocus() );
		sharedBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				try {
					new Shared();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		pipeFilterBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				PipeAndFilter.getInstance(inputLines.getText(), ignoreWords.getText());
			}
		});

	}

}