package com.tsksolutions.leaguebowler.view;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.tsksolutions.leaguebowler.MainApp;
//import com.tsksolutions.leaguebowler.model.Bowler;
import com.tsksolutions.leaguebowler.model.League;
//import com.tsksolutions.leaguebowler.util.DateUtil;
//import com.tsksolutions.leaguebowler.model.Week;

public class LeagueOverviewController {
    @FXML
    private TableView<League> leagueTable;
    @FXML
    private TableColumn<League, String> leagueNameColumn;

    @FXML
    private Label lblLeagueName;
    @FXML
    private Label lblSanctionCenter;
    @FXML
    private Label lblTotalWeeks;
    @FXML
    private CheckBox cbHasHandicap;
//    private Label lblHasHandicap;
    @FXML
    private Label lblHandicapTarget;
    @FXML
    private Label lblHandicapPercent;
    @FXML
    private Label lblHandicapMax;
    @FXML
    private Label lblLeagueType;
/*
    private ObservableList<String> leagueTypes = FXCollections.observableArrayList("Adult", "Youth", "Adult/Youth");
    public ObservableList<String> getLeagueTypes() {
        return leagueTypes;
    }
    //System.out.print(leagueTypes.getLeagueTypes());

    
    

    @FXML
    private ComboBox<String> cboLeagueType = new ComboBox<>(leagueTypes);
*/    

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
        // Initialize the league table view with the one visible column.
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
    		lblLeagueName.setText(league.getLeagueName());
    		lblSanctionCenter.setText(league.getSanctionCenter());
    		lblTotalWeeks.setText(Integer.toString(league.getTotalWeeks()));
    		lblLeagueType.setText(league.getLeagueType());
    		
    		cbHasHandicap.setSelected(league.getHasHandicap());
    		lblHandicapTarget.setText(Float.toString(league.getHandicapTarget()));
    		lblHandicapPercent.setText(Float.toString(league.getHandicapPercent()));
    		lblHandicapMax.setText(Float.toString(league.getHandicapMax()));
    		
    	} else {
    		// league id null, remove all the text.
    		lblLeagueName.setText("");
    		lblSanctionCenter.setText("");
    		lblTotalWeeks.setText("");
    		lblLeagueType.setText("");
    		cbHasHandicap.setSelected(false);
    		lblHandicapTarget.setText("");
    		lblHandicapPercent.setText("");
    		lblHandicapMax.setText("");
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
