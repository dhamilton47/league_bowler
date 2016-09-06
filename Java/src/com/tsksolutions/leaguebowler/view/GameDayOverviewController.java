package com.tsksolutions.leaguebowler.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.tsksolutions.leaguebowler.MainApp;
import com.tsksolutions.leaguebowler.model.Week;
//import com.tsksolutions.leaguebowler.util.DateUtil;

public class GameDayOverviewController {
    @FXML
    private TableView<Week> weekTable;
    @FXML
    private TableColumn<Week, String> leagueNameColumn;
    @FXML
    private TableColumn<Week, String> bowlerNameColumn;

    @FXML
    private Label bowlerNameLabel;
    @FXML
    private Label leagueNameLabel;
    @FXML
    private Label game1Label;
    @FXML
    private Label game2Label;
    @FXML
    private Label game3Label;
    @FXML
    private Label scratchPinfallWeekLabel;
    @FXML
    private Label handicapBeginLabel;
    @FXML
    private Label handicapTotalWeekLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public GameDayOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        leagueNameColumn.setCellValueFactory(cellData -> cellData.getValue().leagueNameProperty());
        bowlerNameColumn.setCellValueFactory(cellData -> cellData.getValue().bowlerNameProperty());
        
        // Clear person details.
        showWeekDetails(null);
        
        // Listen for selection changes and show the person details when changed.
        weekTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showWeekDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        weekTable.setItems(mainApp.getWeekData());
    }
    
    /**
     *  Fills all text fields to show details about the week.
     *  If the specified week is null, all text fields are cleared.
     *  
     *  @param week the week or null
     */
    private void showWeekDetails(Week week) {
    	if (week != null) {
    		// Fill the labels with info from the person object.
    		bowlerNameLabel.setText(week.getBowlerName());
    		leagueNameLabel.setText(week.getLeagueName());
    		game1Label.setText(Integer.toString(week.getGame1()));
    		game2Label.setText(Integer.toString(week.getGame2()));
    		game3Label.setText(Integer.toString(week.getGame3()));
    		scratchPinfallWeekLabel.setText(Integer.toString(week.getScratchPinfallWeek()));
    		handicapBeginLabel.setText(Integer.toString(week.getHandicapBegin()));
    		handicapTotalWeekLabel.setText(Integer.toString(week.getScratchPinfallWeek() + 3 * week.getHandicapBegin()));
    	} else {
    		// league id null, remove all the text.
    		bowlerNameLabel.setText("");
    		leagueNameLabel.setText("");
    		game1Label.setText("");
    		game2Label.setText("");
    		game3Label.setText("");
    		scratchPinfallWeekLabel.setText("");
    		handicapBeginLabel.setText("");
    		handicapTotalWeekLabel.setText("");
    	}
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteWeek() {
    	int selectedIndex = weekTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	weekTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Week Selected");
            alert.setContentText("Please select a week in the table.");

            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewWeek() {
    	Week tempWeek = new Week();
        boolean okClicked = mainApp.showWeekEditDialog(tempWeek);
        if (okClicked) {
            mainApp.getWeekData().add(tempWeek);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditWeek() {
        Week selectedWeek = weekTable.getSelectionModel().getSelectedItem();
        if (selectedWeek != null) {
            boolean okClicked = mainApp.showWeekEditDialog(selectedWeek);
            if (okClicked) {
                showWeekDetails(selectedWeek);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Week Selected");
            alert.setContentText("Please select a week in the table.");

            alert.showAndWait();
        }
    }
}
