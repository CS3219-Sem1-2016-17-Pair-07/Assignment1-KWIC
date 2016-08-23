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
import shared.Shared;


public class KWIC extends Application {
	
	MainPage page;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			page = new MainPage();
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
	
}
