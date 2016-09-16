package com.tsksolutions.leaguebowler.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.tsksolutions.leaguebowler.MainApp;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Dan J. Hamilton
 */
public class MainStageLayoutController {

    // Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
/*
    /**
     * Creates an empty address book.
     */
/*    @FXML
    private void handleNew() {
        mainApp.getBowlerData().clear();
    }
*/
    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
 /*   @FXML
    private void handleOpen() {
            mainApp.loadBowlerData();
    }
*/
    /**
     * Saves the file to the bowler file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
/*    @FXML
    private void handleSave() {
    	mainApp.saveBowlerData();
    }
*/
    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("League Bowler");
        alert.setHeaderText("About");
        alert.setContentText("Author: Dan J. Hamilton\nWebsite: http://www.tsk-solutions.com");

        alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
//      mainApp.showBirthdayStatistics();
    }
    
    /**
     * Show the LeagueOverview scene
     */
    @FXML
    private void handleShowLeagueOverview() {
    	mainApp.showLeagueOverview();
    }
    
    /**
     * Show the BowlerOverview scene
     */
    @FXML
    private void handleShowBowlerOverview() {
    	mainApp.showBowlerOverview();
    }

    /**
     * Show the GameDayOverview scene
     */
    @FXML
    private void handleShowGameDayOverview() {
    	mainApp.showGameDayOverview();
    }

}
