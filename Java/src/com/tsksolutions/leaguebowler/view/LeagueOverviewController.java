package com.tsksolutions.leaguebowler.view;

//import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.tsksolutions.leaguebowler.MainApp;
import com.tsksolutions.leaguebowler.model.League;
//import com.tsksolutions.leaguebowler.util.DateUtil;

public class LeagueOverviewController {
    @FXML
    private TableView<League> leagueTable;
    @FXML
    private TableColumn<League, Integer> leagueIDColumn;
    @FXML
    private TableColumn<League, String> leagueNameColumn;

    @FXML
    private Label leagueIDLabel;
    @FXML
    private Label leagueNameLabel;
    @FXML
    private Label sanctionCenterLabel;
    @FXML
    private Label hasHandicapLabel;
    @FXML
    private Label handicapTargetLabel;
    @FXML
    private Label handicapPercentLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LeagueOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
//        leagueIDColumn.setCellValueFactory(cellData -> cellData.getValue().leagueIDProperty());
        leagueNameColumn.setCellValueFactory(cellData -> cellData.getValue().leagueNameProperty());
        
        // Clear league details.
        showLeagueDetails(null);
        
        // Listen for selection changes and show the league details when changed.
        leagueTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showLeagueDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        leagueTable.setItems(mainApp.getLeagueData());
    }
    
    /**
     *  Fills all text fields to show details about the person.
     *  If the specified person is null, all text fields are cleared.
     *  
     *  @param person the person or null
     */
    private void showLeagueDetails(League league) {
    	if (league != null) {
    		// Fill the labels with info from the person object.
    		leagueIDLabel.setText(Integer.toString(league.getLeagueID()));
    		leagueNameLabel.setText(league.getLeagueName());
    		sanctionCenterLabel.setText(league.getSanctionCenter());
    		hasHandicapLabel.setText(Boolean.toString(league.getHasHandicap()));
    		handicapTargetLabel.setText(Integer.toString(league.getHandicapTarget()));
    		handicapPercentLabel.setText(Float.toString(league.getHandicapPercent()));
    	} else {
    		// league id null, remove all the text.
    		leagueIDLabel.setText("");
    		leagueNameLabel.setText("");
    		sanctionCenterLabel.setText("");
    		hasHandicapLabel.setText("");
    		handicapTargetLabel.setText("");
    		handicapPercentLabel.setText("");
    	}
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteLeague() {
    	int selectedIndex = leagueTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	leagueTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No League Selected");
            alert.setContentText("Please select a league in the table.");

            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewLeague() {
    	League tempLeague = new League();
        boolean okClicked = mainApp.showLeagueEditDialog(tempLeague);
        if (okClicked) {
            mainApp.getLeagueData().add(tempLeague);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditLeague() {
        League selectedLeague = leagueTable.getSelectionModel().getSelectedItem();
        if (selectedLeague != null) {
            boolean okClicked = mainApp.showLeagueEditDialog(selectedLeague);
            if (okClicked) {
                showLeagueDetails(selectedLeague);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No League Selected");
            alert.setContentText("Please select a league in the table.");

            alert.showAndWait();
        }
    }
}
