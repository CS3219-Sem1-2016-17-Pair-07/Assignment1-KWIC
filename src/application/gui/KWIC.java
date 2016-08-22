package application.gui;
	
import java.util.ArrayList;
import java.util.HashSet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class KWIC extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			MainPage page = new MainPage();
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
	
	public void firstArchi(){
		ArrayList<String> lines = new ArrayList<String>();
		HashSet<String> ignoreWords = new HashSet<String>();
		new CircularShifter(lines, ignoreWords);
	}
	
	public void secondArchi(){
		
	}
}
