package com.tsksolutions.leaguebowler.view;

import com.tsksolutions.leaguebowler.MainApp;

import javafx.fxml.FXML;

public class WelcomeController {
    // Reference to the main application.
    @SuppressWarnings("unused")
	private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
//    public WelcomeController() {
//    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
