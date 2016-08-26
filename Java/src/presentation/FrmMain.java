/**
 * 
 */
package presentation;

import java.sql.*;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Dan
 *
 */
//public class MainForm {
public class FrmMain extends Application {
		
	@Override // Override the start method in the Application class
	public void start(Stage mainStage) {
		// Create a border pane
		BorderPane mainPane = new BorderPane();

		// Place nodes in the pane
		mainPane.setTop(new CustomPane("Top"));
		mainPane.setRight(new CustomPane("Right"));
		mainPane.setBottom(new CustomPane("Bottom"));
		mainPane.setLeft(new CustomPane("Left"));
		mainPane.setCenter(new CustomPane("Center"));
		
		
		Button btShowBowler = new Button("Bowler Management");
		Button btShowLeague = new Button("League Management");
		Button btShowGameDay = new Button("Game Day");
		Button btExit = new Button("Exit");

		// Create and register the button click handler(s)
		btShowBowler.setOnAction(e ->System.out.println("Bowler Management Button pressed"));
		btShowLeague.setOnAction(e-> System.out.println("League Management button pressed"));
		btShowGameDay.setOnAction(e-> System.out.println("Game Day button pressed"));
		btExit.setOnAction(e-> System.out.println("Exit button pressed"));
		
		StackPane mainButtonPane = new StackPane();
		mainButtonPane.getChildren().addAll(btShowBowler, btShowLeague, btShowGameDay, btExit);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(mainPane, 1000, 500);
		mainStage.setTitle("League Bowler"); // Set the stage title
		mainStage.setScene(scene); // Place the scene in the stage
		mainStage.show(); // Display the stage 
	}
	
	// Define a custom pane to hold a label in the center of the pane
	class CustomPane extends StackPane {
		public CustomPane(String title) {
			getChildren().add(new Label(title));
			setStyle("-fx-border-color: red");
			setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		}
	}
		
	private void showBowlers() {

	}
}
