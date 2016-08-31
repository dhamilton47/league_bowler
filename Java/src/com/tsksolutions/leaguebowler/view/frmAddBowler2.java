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

/**
 * @author Dan
 *
 */
//public class frmAddBowler {
public class frmAddBowler2 extends Application {

	// Statement for executing queries
	private Statement stmt;
	private TextField tfBowlerID = new TextField();
	private TextField tfFirstName = new TextField();
	private TextField tfMiddleName = new TextField();
	private TextField tfLastName = new TextField();
	private TextField tfSuffix = new TextField();
	private TextField tfSex = new TextField();
	private TextField tfDOB = new TextField();
	private Label lblStatus = new Label();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Statement for executing queries
//		private Statement stmt;
//		TextField tfBowlerID = new TextField();
//		TextField tfFirstName = new TextField();
//		TextField tfMiddleName = new TextField();
//		TextField tfLastName = new TextField();
//		TextField tfSuffix = new TextField();
//		TextField tfSex = new TextField();
//		TextField tfDOB = new TextField();
//		Label lblStatus = new Label();

		// Initialize database connection and create a Statement object
		initializeDB();
		
		// Create a grid pane and set its properties
//		GridPane pane = new GridPane();
//		pane.setAlignment(Pos.CENTER);
//		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
//		pane.setHgap(5.5);
//		pane.setVgap(5.5);
		
		// Create stack panes and set their properties
		VBox stpane1 = new VBox();
		VBox stpane2 = new VBox();
		
		this.tfBowlerID.setPrefColumnCount(10);
		this.tfFirstName.setPrefColumnCount(25);
		this.tfMiddleName.setPrefColumnCount(25);
		this.tfLastName.setPrefColumnCount(25);
		this.tfSuffix.setPrefColumnCount(5);
		this.tfSex.setPrefColumnCount(1);
		this.tfDOB.setPrefColumnCount(10);

		// Place nodes in the grid pane
//		pane.add(new Label("USBC ID:"), 0, 0);
//		pane.add(new Label("First Name:"), 0, 1);
//		pane.add(new Label("Middle Name:"), 0, 2);
//		pane.add(new Label("Last Name:"), 0, 3);
//		pane.add(new Label("Suffix:"), 0, 4);
//		pane.add(new Label("Sex:"), 0, 5);
//		pane.add(new Label("Date of Birth:"), 0, 6);
		
		// Place node labels in stack 1
		stpane1.getChildren().addAll(new Label("USBC ID:"), new Label("First Name:"), new Label("Middle Name:"), 
				new Label("Last Name:"), new Label("Suffix:"), new Label("Sex:"), new Label("Date of Birth:"));
//		stpane1.getChildren().add(new Label("USBC ID:"));
//		stpane1.getChildren().add(new Label("First Name:"));
//		stpane1.getChildren().add(new Label("Middle Name:"));
//		stpane1.getChildren().add(new Label("Last Name:"));
//		stpane1.getChildren().add(new Label("Suffix:"));
//		stpane1.getChildren().add(new Label("Sex:"));
//		stpane1.getChildren().add(new Label("Date of Birth:"));
		
//		pane.add(tfBowlerID, 1, 0);
//		pane.add(tfFirstName, 1, 1);
//		pane.add(tfMiddleName, 1, 2);
//		pane.add(tfLastName, 1, 3);
//		pane.add(tfSuffix, 1, 4);
//		pane.add(tfSex, 1, 5);
//		pane.add(tfDOB, 1, 6);
//		Button btExit = new Button("Exit");
//		pane.add(btExit,  1,  7);
//		GridPane.setHalignment(btExit, HPos.RIGHT);

		// Place nodes in stack 2
		stpane2.getChildren().addAll(tfBowlerID, tfFirstName, tfMiddleName, tfLastName, tfSuffix, tfSex, tfDOB);
//		stpane2.getChildren().add(tfBowlerID);
//		stpane2.getChildren().add(tfFirstName);
//		stpane2.getChildren().add(tfMiddleName);
//		stpane2.getChildren().add(tfLastName);
//		stpane2.getChildren().add(tfSuffix);
//		stpane2.getChildren().add(tfSex);
//		stpane2.getChildren().add(tfDOB);
		
		Button btExit = new Button("Exit");
		stpane2.getChildren().add(btExit);

		HBox hBox = new HBox(20);
		hBox.getChildren().addAll(stpane1, stpane2); 

//		Button btShowGrade = new Button("Show Grade");
//		HBox hBox = new HBox(5);
//		hBox.getChildren().addAll(
//			new Label("USBC ID"), tfBowlerID, 
//			new Label("First Name"), tfFirstName,
//			new Label("Middle Name"), tfMiddleName,
//			new Label("Last Name"), tfLastName,
//			new Label("Suffix"), tfSuffix,
//			new Label("Sex"), tfSex,
//			new Label("Date of Birth"), tfDOB,
//			(btShowGrade));
//			
//		VBox vBox = new VBox(10);
//		vBox.getChildren().addAll(hBox, lblStatus);
			
//		btShowGrade.setOnAction(e -> showBowlers());
			
		// Create a scene and place it in the stage
//		Scene scene = new Scene(pane);
		Scene scene = new Scene(hBox);
//		Scene scene = new Scene(stpane2);
		primaryStage.setTitle("Add Bowler"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage 
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
			
	private void showBowlers() {
		String bowlerId = tfBowlerID.getText();
		String firstName = tfFirstName.getText();
		String middleName = tfMiddleName.getText();
		String lastName = tfLastName.getText();
		String suffix = tfSuffix.getText();
		String sex = tfSex.getText();
		String dob = tfDOB.getText();

		try {
			String queryString = 
				"select bowlerID, " +
					"firstName, " +
					"middleName, " +
					"lastName, " +
					"suffixName, " +
					"sex, " +
					"dateOfBirth " +
				"from bowleryouth " +
				"where bowleryouth.bowlerID = '" + bowlerId + "'";
			
			ResultSet rset = stmt.executeQuery(queryString);
			
			if (rset.next()) {
//				String lastName = rset.getString(1);
//				String mi = rset.getString(2);
//				String firstName = rset.getString(3);
//				String title = rset.getString(4);
//				String grade = rset.getString(5);
//			
				// Display result in a label
//				lblStatus.setText(firstName + " " + mi +
//					" " + lastName + "'s grade on course " + title + " is " +
//					grade);
			} else {
				lblStatus.setText("Not found");
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
