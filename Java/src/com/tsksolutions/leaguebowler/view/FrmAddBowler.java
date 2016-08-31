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
//public class frmAddBowler {
public class FrmAddBowler extends Application {

	// Statement for executing queries
	private Statement stmt;
	private TextField tfBowlerID = new TextField();
	private TextField tfFirstName = new TextField();
	private TextField tfMiddleName = new TextField();
	private TextField tfLastName = new TextField();
	private TextField tfSuffix = new TextField();
	private TextField tfSex = new TextField();
	private TextField tfDOB = new TextField();
	private TextField tfBowlerType = new TextField();
	private TextField tfSanctionType = new TextField();
	private TextField tfSanctionYear = new TextField();
	private TextField tfSanctionStatus = new TextField();
	private TextField tfSanctionCenter = new TextField();
	private Label lblStatus = new Label();

	@Override // Override the start method in the Application class
	public void start(Stage addBowlerStage) {

		// Initialize database connection and create a Statement object
		initializeDB();
		
		// Create a grid pane and set its properties
		GridPane addBowlerPane = new GridPane();
		addBowlerPane.setAlignment(Pos.CENTER);
		addBowlerPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		addBowlerPane.setHgap(5.5);
		addBowlerPane.setVgap(5.5);
		
		// Place nodes in the grid pane
		addBowlerPane.add(new Label("USBC ID:"), 0, 0);
		addBowlerPane.add(new Label("First Name:"), 0, 1);
		addBowlerPane.add(new Label("Middle Name:"), 0, 2);
		addBowlerPane.add(new Label("Last Name:"), 0, 3);
		addBowlerPane.add(new Label("Suffix:"), 0, 4);
		addBowlerPane.add(new Label("Sex:"), 0, 5);
		addBowlerPane.add(new Label("Date of Birth:"), 0, 6);
		addBowlerPane.add(new Label("Bowler Type:"), 0, 7);
		addBowlerPane.add(new Label("Sanction Type:"), 0, 8);
		addBowlerPane.add(new Label("Sanction Year:"), 0, 9);
		addBowlerPane.add(new Label("Sanction Status:"), 0, 10);
		addBowlerPane.add(new Label("Sanction Center:"), 0, 11);
	
		addBowlerPane.add(tfBowlerID, 1, 0);
		addBowlerPane.add(tfFirstName, 1, 1);
		addBowlerPane.add(tfMiddleName, 1, 2);
		addBowlerPane.add(tfLastName, 1, 3);
		addBowlerPane.add(tfSuffix, 1, 4);
		addBowlerPane.add(tfSex, 1, 5);
		addBowlerPane.add(tfDOB, 1, 6);
		addBowlerPane.add(tfBowlerType, 1, 7);
		addBowlerPane.add(tfSanctionType, 1, 8);
		addBowlerPane.add(tfSanctionYear, 1, 9);
		addBowlerPane.add(tfSanctionStatus, 1, 10);
		addBowlerPane.add(tfSanctionCenter, 1, 11);
		
		Button btAddBowler = new Button("Add Bowler");
		addBowlerPane.add(btAddBowler, 0, 12);
		GridPane.setHalignment(btAddBowler, HPos.RIGHT);
		
		Button btExit = new Button("Exit");
		addBowlerPane.add(btExit,  1,  12);
		GridPane.setHalignment(btExit, HPos.RIGHT);
		
		// Create and register the button click handler(s)
		btAddBowler.setOnAction((ActionEvent e) -> addBowler());
		btExit.setOnAction(e-> System.out.println("Exit button pressed"));
			
		// Create a scene and place it in the stage
		Scene scene = new Scene(addBowlerPane);
		addBowlerStage.setTitle("Add Bowler"); // Set the stage title
		addBowlerStage.setScene(scene); // Place the scene in the stage
		addBowlerStage.show(); // Display the stage 
	}
			
	private void initializeDB() {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Database Driver Loaded");
		
			// Establish a connection
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/leaguebowler", "root", "");
			System.out.println("Database Connected");
			
			// Create a statement
			stmt = connection.createStatement();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
			
	private void addBowler() {
		// Get values from text fields
		String bowlerId = tfBowlerID.getText();
		String firstName = tfFirstName.getText();
		String middleName = tfMiddleName.getText();
		String lastName = tfLastName.getText();
		String suffix = tfSuffix.getText();
		String sex = tfSex.getText();
		String dob = tfDOB.getText();
		String bowlerType = tfBowlerType.getText();
		String sanctionType = tfSanctionType.getText();
		String sanctionYear = tfSanctionYear.getText();
		String sanctionStatus = tfSanctionStatus.getText();
		String sanctionCenter = tfSanctionCenter.getText();

		try {
			String queryString = 
				"insert into bowler " +
				"values ('" + bowlerId + "', '" +
					firstName + "', '" +
					middleName + "', '" +
					lastName + "', '" +
					suffix + "', '" +
					sex + "', '" +
					dob + "', '" +
					bowlerType +  "', '" +
					sanctionType +  "', '" +
					sanctionYear +  "', '" +
					sanctionStatus +  "', '" +
					sanctionCenter + "');";
					
			stmt.executeUpdate(queryString);
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
