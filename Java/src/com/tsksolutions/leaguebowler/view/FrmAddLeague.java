/**
 * 
 */
package com.tsksolutions.leaguebowler.view;

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
public class FrmAddLeague extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage addLeagueStage) {
		
		GridPane addLeaguePane = new GridPane();
		addLeaguePane.getChildren().addAll();
		
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(addLeaguePane);
		addLeagueStage.setTitle("Add League"); // Set the stage title
		addLeagueStage.setScene(scene); // Place the scene in the stage
		addLeagueStage.show(); // Display the stage 
	}
}
