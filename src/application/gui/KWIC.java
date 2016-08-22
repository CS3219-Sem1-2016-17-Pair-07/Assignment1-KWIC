package application.gui;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class KWIC extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void firstArchi(){
		
	}

	public void printOutput(ArrayList<String> fromAlphabetizer){
		for(int i = 0 ; i < fromAlphabetizer.size(); i++){
			System.out.println(fromAlphabetizer.get(i));
		}
	}
	
	public void secondArchi(){
		
	}
}
