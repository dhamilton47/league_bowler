package com.tsksolutions.leaguebowler;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.tsksolutions.leaguebowler.model.Bowler;
import com.tsksolutions.leaguebowler.model.BowlerListWrapper;
import com.tsksolutions.leaguebowler.view.BowlerEditDialogController;
import com.tsksolutions.leaguebowler.view.BowlerOverviewController;

import com.tsksolutions.leaguebowler.model.League;
//import com.tsksolutions.leaguebowler.model.LeagueListWrapper;
import com.tsksolutions.leaguebowler.view.LeagueEditDialogController;
import com.tsksolutions.leaguebowler.view.LeagueOverviewController;

import com.tsksolutions.leaguebowler.model.Week;
//import com.tsksolutions.leaguebowler.model.WeekListWrapper;
import com.tsksolutions.leaguebowler.view.WeekEditDialogController;
import com.tsksolutions.leaguebowler.view.GameDayOverviewController;

//import com.tsksolutions.leaguebowler.view.MainStageLayoutController;
import com.tsksolutions.leaguebowler.view.MainStageLayoutController;
//import com.tsksolutions.leaguebowler.view.WeekEditDialogController;
//import com.tsksolutions.leaguebowler.view.WelcomeController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane mainStageLayout;

    private Statement stmt;
    private PreparedStatement getBowlerTable;
    private PreparedStatement getLeagueTable;
    private PreparedStatement getGameDayTable;
    private PreparedStatement addBowlerTable;
    private PreparedStatement addLeagueTable;
    private PreparedStatement addGameDayTable;
    private PreparedStatement updateBowlerTable;
    private PreparedStatement updateLeagueTable;
    private PreparedStatement updateGameDayTable;
    private PreparedStatement deleteBowlerTable;
    private PreparedStatement deleteLeagueTable;
    private PreparedStatement deleteGameDayTable;
	
	private String username = "Dan";
	private String password = "trouble";

    /**
     * The data are observable lists of Bowlers and Leagues.
     */
    private ObservableList<Bowler> bowlerData = FXCollections.observableArrayList();
    private ObservableList<League> leagueData = FXCollections.observableArrayList();
    private ObservableList<Week> weekData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
/*        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
*/
    }

    /**
     * Returns the data as observable lists of Bowlers and Leagues. 
     * @return
     */
    public ObservableList<Bowler> getBowlerData() {
        return bowlerData;
    }

    public ObservableList<League> getLeagueData() {
        return leagueData;
    }

    public ObservableList<Week> getWeekData() {
        return weekData;
    }

	@Override
	public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("League Bowler");

        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:resources/images/tsk-favicon-32.png"));

        initMainStageLayout();

        showWelcome();

		initDB(username, password);

}

	public static void main(String[] args) {
		launch(args);
	}

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Initializes the root layout and tries to load the last opened person file.
     */
    public void initMainStageLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainStageLayout.fxml"));
            mainStageLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(mainStageLayout);
            primaryStage.setScene(scene);
            
            // Give the controller access to the main app.
            MainStageLayoutController controller = loader.getController();
            controller.setMainApp(this);
            
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Try to load the last opened person file.
/*        File file = getPersonFilePath();
        if (file != null) {
        	loadBowlerDataFromFile(file);
        }
*/
    }

    /**
     * Shows the welcome scene on initial load of main stage.
     */
    public void showWelcome() {
        try {
            // Load welcome scene.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Welcome.fxml"));
            AnchorPane welcome = (AnchorPane) loader.load();

            // Set welcome into the center of root layout.
            mainStageLayout.setCenter(welcome);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the bowler overview inside the main stage layout.
     */
    public void showBowlerOverview() {
        try {
            // Load bowler overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BowlerOverview.fxml"));
            AnchorPane bowlerOverview = (AnchorPane) loader.load();

            // Set bowler overview into the center of root layout.
            mainStageLayout.setCenter(bowlerOverview);

            // Give the controller access to the main app.
            BowlerOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
            // Try to load the bowler table.
        	loadBowlerData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified bowler. If the user
     * clicks OK, the changes are saved into the provided bowler object and true
     * is returned.
     * 
     * @param bowler the bowler object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showBowlerEditDialog(Bowler bowler) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BowlerEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("New/Edit Bowler");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.getIcons().add(new Image("file:resources/images/tsk-favicon-32.png"));

            // Set the bowler into the controller.
            BowlerEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setBowler(bowler);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Shows the league overview inside the main stage layout.
     */
    public void showLeagueOverview() {
        try {
            // Load league overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LeagueOverview.fxml"));
            AnchorPane leagueOverview = (AnchorPane) loader.load();

            // Set league overview into the center of root layout.
            mainStageLayout.setCenter(leagueOverview);

            // Give the controller access to the main app.
            LeagueOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
            // Try to load the league table.
        	loadLeagueData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified league. If the user
     * clicks OK, the changes are saved into the provided league object and true
     * is returned.
     * 
     * @param league the league object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showLeagueEditDialog(League league) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LeagueEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("New/Edit League");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.getIcons().add(new Image("file:resources/images/tsk-favicon-32.png"));

            // Set the league into the controller.
            LeagueEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setLeague(league);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Shows the game day overview inside the main stage layout.
     */
    public void showGameDayOverview() {
        try {
            // Load game day overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GameDayOverview.fxml"));
            AnchorPane gameDayOverview = (AnchorPane) loader.load();

            // Set game day overview into the center of root layout.
            mainStageLayout.setCenter(gameDayOverview);

            // Give the controller access to the main app.
            GameDayOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified league. If the user
     * clicks OK, the changes are saved into the provided league object and true
     * is returned.
     * 
     * @param league the league object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showWeekEditDialog(Week week) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/WeekEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("New/Edit Week");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.getIcons().add(new Image("file:resources/images/tsk-favicon-32.png"));

            // Set the league into the controller.
            WeekEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setWeek(week);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     */
    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("League Bowler - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("League Bowler");
        }
    }

    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     * 
     * @param file
     */
    public void loadBowlerDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(BowlerListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            BowlerListWrapper wrapper = (BowlerListWrapper) um.unmarshal(file);

            bowlerData.clear();
            bowlerData.addAll(wrapper.getBowlers());

            // Save the file path to the registry.
            setPersonFilePath(file);

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    /**
     * Saves the current person data to the specified file.
     * 
     * @param file
     */
    public void saveBowlerDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(BowlerListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            BowlerListWrapper wrapper = new BowlerListWrapper();
            wrapper.setBowlers(bowlerData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setPersonFilePath(file);
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    /**
     * Opens a dialog to show birthday statistics.
     */
    public void showBirthdayStatistics() {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BirthdayStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the persons into the controller.
//            BirthdayStatisticsController controller = loader.getController();
//            controller.setBowlerData(bowlerData);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the database connection with MySQL and creates a stmt object.
     */
    private void initDB(String username, String password) {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Database Driver Loaded");
		
			// Establish a connection
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/leaguebowler", username, password);
			System.out.println("Database Connected");
			
			// Create a statement
			stmt = connection.createStatement();
			
			/*
			 * Create the prepared statements for the various queries.
			 */
			
			// Bowler table select query
			String query = "SELECT bowlerID, bowlerType, firstName, middleName, lastName, suffixName, nickname, sex, dateOfBirth, user, lastUpdate " +
					"FROM bowler";
			
			getBowlerTable = connection.prepareStatement(query);
			
			// Bowler table add query
			query = "INSERT INTO bowler " +
					"(bowlerType, firstName, middleName, lastName, suffixName, nickname, sex, dateOfBirth, user) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, user);";
			
			addBowlerTable = connection.prepareStatement(query);
			
			// Bowler table update query
			query = "UPDATE bowler " +
					"SET bowlerType = ?, firstName = ?, middleName = ?, lastName = ?, suffixName = ?, " +
						"nickname = ?, sex = ?, dateOfBirth = ?, user = ? " +
					"WHERE bowlerID = ?;";
			
			updateBowlerTable = connection.prepareStatement(query);
			
			// Bowler table delete query
			query = "DELETE FROM bowler WHERE bowlerID = ?;";
			
			deleteBowlerTable = connection.prepareStatement(query);
			
			// League table select query
			query = "SELECT leagueID, leagueName, sanctionCenter, totalWeeks, hasHandicap, handicapTarget, handicapPercent, handicapMax, user, lastUpdate " +
					"FROM league";
			
			getLeagueTable = connection.prepareStatement(query);
			
			// League table add query
			query = "INSERT INTO league " +
					"(leagueName, sanctionCenter, totalWeeks, hasHandicap, handicapTarget, handicapPercent, handicapMax, user) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, user);";
			
			addLeagueTable = connection.prepareStatement(query);
			
			// League table update query
			query = "UPDATE league " +
					"SET leagueName = ?, sanctionCenter = ?, totalWeeks = ?, hasHandicap = ?, handicapTarget = ?, handicapPercent = ?, handicapMax = ?, user = ? " +
					"WHERE leagueID = ?;";
			
			updateLeagueTable = connection.prepareStatement(query);
			
			// League table delete query
			query = "DELETE FROM league WHERE bowlerID = ?;";
			
			deleteLeagueTable = connection.prepareStatement(query);
			
			// Game day table select query
			query = "SELECT id, leagueID, bowlerID, " +
						"weekNum, game1, game2, game3, " +
						"scratchPinfallBegin, scratchPinfallWeek, scratchPinfallEnd, " + 
						"gameCountBegin, gameCountWeek, gameCountEnd, " +
						"scratchAverageBegin, scratchAverageEnd, isLocked, user, lastUpdate " +
					"FROM weekly_results";
			
			getGameDayTable = connection.prepareStatement(query);
			
			// Game day add query
			query = "INSERT INTO weekly_results " +
					"(leagueID, bowlerID, " +
					"weekNum, game1, game2, game3, " +
					"scratchPinfallBegin, scratchPinfallWeek, scratchPinfallEnd," + 
					"gameCountBegin, gameCountWeek, gameCountEnd, " +
					"scratchAverageBegin, scratchAverageEnd, isLocked, user) " +
					"VALUES (?, ?, " +
					"?, ?, ?, ?, " +
					"?, ?, ?, " + 
					"?, ?, ?, " + 
					"?, ?, ?, user);"; 
			
			addGameDayTable = connection.prepareStatement(query);
			
			// Game day update query
			query = "UPDATE weekly_results " +
					"SET leagueID = ?, bowlerID = ?, " +
						"weekNum = ?, game1 = ?, game2 = ?, game3 = ?, " +
						"scratchPinfallBegin = ?, scratchPinfallWeek = ?, scratchPinfallEnd = ?," + 
						"gameCountBegin = ?, gameCountWeek = ?, gameCountEnd = ?, " +
						"scratchAverageBegin = ?, scratchAverageEnd = ?, isLocked = ?, user = ? " +
					"WHERE id = ?;";
			
			updateGameDayTable = connection.prepareStatement(query);
			
			// Game day delete query
			query = "DELETE FROM weekly_results " + 
					"WHERE id = ?;";
			
			deleteGameDayTable = connection.prepareStatement(query);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
			
    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     */
    public void loadBowlerData() {
        try {
        	ResultSet resultBowlerList = getBowlerTable.executeQuery();
        	
        	/* Cycle thru the records in the result set, assigning the field 
        	 * values to the corresponding bowler object properties and 
		 	 * adding them to the ArrayList<Bowler> collection
		 	 */
         	bowlerData.clear();
         	
         	while (resultBowlerList.next()) {
         		Bowler bowler = new Bowler();
        		bowler.setBowlerID(resultBowlerList.getInt("bowlerID"));
        		bowler.setBowlerType(resultBowlerList.getString("bowlerType"));
        		bowler.setFirstName(resultBowlerList.getString("firstName"));
        		bowler.setMiddleName(resultBowlerList.getString("middleName"));
        		bowler.setLastName(resultBowlerList.getString("lastName"));
        		bowler.setSuffixName(resultBowlerList.getString("suffixName"));
        		bowler.setNickname(resultBowlerList.getString("nickname"));
        		bowler.setSex(resultBowlerList.getString("sex"));
//        		bowler.setBirthday((LocalDate)resultBowlerList.getDate("dateOfBirth"));
        		bowler.setUser(resultBowlerList.getString("user"));
//        		bowler.setLastUpdate(resultBowlerList.getString("lastUpdate"));
        		
        		bowlerData.add(bowler);
//        		System.out.println(bowlerData);
      
        	}
        }
        
        catch( SQLException e ) {
        	System.out.println( "SQLException: " + e.getMessage() );
        	System.out.println( "SQLState:     " + e.getSQLState() );
        	System.out.println( "VendorError:  " + e.getErrorCode() );
        	e.printStackTrace();
        }
    }

    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     * 
     * @param file
     */
    public void loadLeagueData() {
        try {
        	ResultSet resultLeagueList = getLeagueTable.executeQuery();
        	
        	/* Cycle thru the records in the result set, assigning the field 
        	 * values to the corresponding league object properties and 
		 	 * adding them to the ArrayList<League> collection
		 	 */
        	leagueData.clear();
         	
         	while (resultLeagueList.next()) {
         		League league = new League();
         		league.setLeagueID(resultLeagueList.getInt("leagueID"));
         		league.setLeagueName(resultLeagueList.getString("leagueName"));
         		league.setSanctionCenter(resultLeagueList.getString("sanctionCenter"));
         		league.setTotalWeeks(resultLeagueList.getInt("totalWeeks"));
         		league.setHasHandicap(resultLeagueList.getBoolean("hasHandicap"));
         		league.setHandicapTarget(resultLeagueList.getFloat("handicapTarget"));
         		league.setHandicapPercent(resultLeagueList.getFloat("handicapPercent"));
         		league.setHandicapMax(resultLeagueList.getFloat("handicapMax"));
         		league.setUser(resultLeagueList.getString("user"));
//        		bowler.setLastUpdate(resultBowlerList.getString("lastUpdate"));
        		
        		leagueData.add(league);
        	}
        }
        
        catch( SQLException e ) {
        	System.out.println( "SQLException: " + e.getMessage() );
        	System.out.println( "SQLState:     " + e.getSQLState() );
        	System.out.println( "VendorError:  " + e.getErrorCode() );
        	e.printStackTrace();
        }
    }

    /**
     * Saves the current person data to the specified file.
     * 
     * @param file
     */
    public void saveBowlerDataToDB(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(BowlerListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            BowlerListWrapper wrapper = new BowlerListWrapper();
            wrapper.setBowlers(bowlerData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setPersonFilePath(file);
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

	private void addBowler() {
		// Get values from text fields
/*		String bowlerId = tfBowlerID.getText();
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
*/
/*		try {
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
*/	}
}
