package com.tsksolutions.leaguebowler.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.tsksolutions.leaguebowler.model.Week;

/**
 * Dialog to edit details of a bowler.
 * 
 * @author Dan J. Hamilton
 */
public class WeekEditDialogController {

    @FXML
    private TextField leagueNameField;
    @FXML
    private TextField bowlerNameField;
    @FXML
    private TextField game1Field;
    @FXML
    private TextField game2Field;
    @FXML
    private TextField game3Field;


    private Stage dialogStage;
    private Week week;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the week to be edited in the dialog.
     * 
     * @param week
     */
    public void setWeek(Week week) {
        this.week = week;

        leagueNameField.setText(week.getLeagueName());
        bowlerNameField.setText(week.getBowlerName());
        game1Field.setText(Integer.toString(week.getGame1()));
        game2Field.setText(Integer.toString(week.getGame2()));
        game3Field.setText(Integer.toString(week.getGame3()));
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	week.setLeagueName(leagueNameField.getText());
        	week.setBowlerName(bowlerNameField.getText());
        	week.setGame1(Integer.parseInt(game1Field.getText()));
        	week.setGame2(Integer.parseInt(game2Field.getText()));
        	week.setGame3(Integer.parseInt(game3Field.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (leagueNameField.getText() == null || leagueNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }

        if (bowlerNameField.getText() == null || bowlerNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }

        if (game1Field.getText() == null || game1Field.getText().length() == 0) {
            errorMessage += "No valid game 1 score!\n"; 
        } else {
            // try to parse the game 1 score into an int.
            try {
                Integer.parseInt(game1Field.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid game 1 score (must be an integer)!\n"; 
            }
        }

        if (game2Field.getText() == null || game2Field.getText().length() == 0) {
            errorMessage += "No valid game 2 score!\n"; 
        } else {
            // try to parse the game 2 score into an int.
            try {
                Integer.parseInt(game2Field.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid game 2 score (must be an integer)!\n"; 
            }
        }

        if (game3Field.getText() == null || game3Field.getText().length() == 0) {
            errorMessage += "No valid game 3 score!\n"; 
        } else {
            // try to parse the game 3 score into an int.
            try {
                Integer.parseInt(game3Field.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid game 3 score (must be an integer)!\n"; 
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}