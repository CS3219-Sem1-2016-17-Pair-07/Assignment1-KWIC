package application.gui;
	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import PipeFilter.CircularShifter;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class KWIC extends Application {
	
	MainPage page;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			page = new MainPage();
			page.getGenerateButton().addEventHandler(MouseEvent.MOUSE_CLICKED, 
				    new EventHandler<MouseEvent>() {
		        @Override 
		        public void handle(MouseEvent e) {
		            pipeAndFilter();
		        }
			});
			Scene scene = new Scene(page);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void pipeAndFilter(){
		
		String [] tempLines = page.getInputLines().getText().split(",");
		for(int i=0; i<tempLines.length; i++){
			tempLines[i] = tempLines[i].trim();
		}
		ArrayList<String> lines = new ArrayList(Arrays.asList(tempLines));
		
        String [] tempIgnoreWords = page.getIgnoreWords().getText().split(",");
        HashSet<String> ignoreWords = new HashSet<String>();
        for(int i=0; i<tempIgnoreWords.length ;i++){
			ignoreWords.add(tempIgnoreWords[i].trim().toLowerCase());
		}
		
		new CircularShifter(lines, ignoreWords);
	}
	
	public void secondArchi(){
		
	}
}
