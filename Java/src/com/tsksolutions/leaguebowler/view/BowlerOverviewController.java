package com.tsksolutions.leaguebowler.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.tsksolutions.leaguebowler.MainApp;
import com.tsksolutions.leaguebowler.model.Bowler;
import com.tsksolutions.leaguebowler.util.DateUtil;

public class BowlerOverviewController {
    @FXML
    private TableView<Bowler> bowlerTable;
    @FXML
    private TableColumn<Bowler, String> firstNameColumn;
    @FXML
    private TableColumn<Bowler, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public BowlerOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        // Clear person details.
        showBowlerDetails(null);
        
        // Listen for selection changes and show the person details when changed.
        bowlerTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showBowlerDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        bowlerTable.setItems(mainApp.getBowlerData());
    }
    
    /**
     *  Fills all text fields to show details about the person.
     *  If the specified person is null, all text fields are cleared.
     *  
     *  @param bowler the bowler or null
     */
    private void showBowlerDetails(Bowler bowler) {
    	if (bowler != null) {
    		// Fill the labels with info from the bowler object.
    		firstNameLabel.setText(bowler.getFirstName());
    		lastNameLabel.setText(bowler.getLastName());
    		streetLabel.setText(bowler.getStreet());
    		postalCodeLabel.setText(Integer.toString(bowler.getPostalCode()));
    		cityLabel.setText(bowler.getCity());
    		birthdayLabel.setText(DateUtil.format(bowler.getBirthday()));
    	} else {
    		// Bowler id null, remove all the text.
    		firstNameLabel.setText("");
    		lastNameLabel.setText("");
    		streetLabel.setText("");
    		postalCodeLabel.setText("");
    		cityLabel.setText("");
    		birthdayLabel.setText("");
    	}
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteBowler() {
    	int selectedIndex = bowlerTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	bowlerTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Bowler Selected");
            alert.setContentText("Please select a bowler in the table.");

            alert.showAndWait();
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new bowler.
     */
    @FXML
    private void handleNewBowler() {
        Bowler tempBowler = new Bowler();
        boolean okClicked = mainApp.showBowlerEditDialog(tempBowler);
        if (okClicked) {
            mainApp.getBowlerData().add(tempBowler);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected bowler.
     */
    @FXML
    private void handleEditBowler() {
        Bowler selectedBowler = bowlerTable.getSelectionModel().getSelectedItem();
        if (selectedBowler != null) {
            boolean okClicked = mainApp.showBowlerEditDialog(selectedBowler);
            if (okClicked) {
                showBowlerDetails(selectedBowler);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Bowler Selected");
            alert.setContentText("Please select a bowler in the table.");

            alert.showAndWait();
        }
    }
}
