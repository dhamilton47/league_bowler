package com.tsksolutions.leaguebowler.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.tsksolutions.leaguebowler.model.League;
//import com.tsksolutions.leaguebowler.util.DateUtil;

/**
 * Dialog to edit details of a league.
 * 
 * @author Dan J. Hamilton
 */
public class LeagueEditDialogController {

    @FXML
    private TextField leagueNameField;
    @FXML
    private TextField sanctionCenterField;
    @FXML
    private TextField totalWeeksField;
    @FXML
    private TextField hasHandicapField;
    @FXML
    private TextField handicapTargetField;
    @FXML
    private TextField handicapPercentField;
    @FXML
    private TextField handicapMaxField;


    private Stage dialogStage;
    private League league;
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
     * Sets the league to be edited in the dialog.
     * 
     * @param league
     */
    public void setLeague(League league) {
        this.league = league;

        leagueNameField.setText(league.getLeagueName());
        sanctionCenterField.setText(league.getSanctionCenter());
        totalWeeksField.setText(Integer.toString(league.getTotalWeeks()));
        hasHandicapField.setText(Boolean.toString(league.getHasHandicap()));
        handicapTargetField.setText(Float.toString(league.getHandicapTarget()));
        handicapPercentField.setText(Float.toString(league.getHandicapPercent()));
        handicapMaxField.setText(Float.toString(league.getHandicapMax()));
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
        	league.setLeagueName(leagueNameField.getText());
        	league.setSanctionCenter(sanctionCenterField.getText());
        	league.setTotalWeeks(Integer.parseInt(totalWeeksField.getText()));
        	league.setHasHandicap(Boolean.parseBoolean(hasHandicapField.getText()));
        	league.setHandicapTarget(Float.parseFloat(handicapTargetField.getText()));
        	league.setHandicapPercent(Float.parseFloat(handicapPercentField.getText()));
        	league.setHandicapMax(Float.parseFloat(handicapMaxField.getText()));

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
            errorMessage += "No valid league name!\n"; 
        }

        if (sanctionCenterField.getText() == null || sanctionCenterField.getText().length() == 0) {
            errorMessage += "No valid bowling center!\n"; 
        }

        if (hasHandicapField.getText() == null || hasHandicapField.getText().length() == 0) {
            errorMessage += "No valid handicap option!\n"; 
        } else {
            // try to parse the has handicap option into a boolean.
            try {
                Boolean.parseBoolean(hasHandicapField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid has handicap option (must be a boolean)!\n"; 
            }
        }

        if (totalWeeksField.getText() == null || totalWeeksField.getText().length() == 0) {
            errorMessage += "No valid total weeks for season!\n"; 
        } else {
            // try to parse the total weeks into an float.
            try {
                Integer.parseInt(handicapTargetField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid total weeks (must be an integer)!\n"; 
            }
        }

        if (handicapTargetField.getText() == null || handicapTargetField.getText().length() == 0) {
            errorMessage += "No valid handicap target!\n"; 
        } else {
            // try to parse the handicap target into an int.
            try {
                Integer.parseInt(handicapTargetField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid handicap target (must be an integer)!\n"; 
            }
        }

        if (handicapPercentField.getText() == null || handicapPercentField.getText().length() == 0) {
            errorMessage += "No valid handicap percent!\n"; 
        } else {
            // try to parse the handicap percent into a float.
            try {
                Float.parseFloat(handicapPercentField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid handicap percent (must be a decimal)!\n"; 
            }
        }

        if (handicapMaxField.getText() == null || handicapMaxField.getText().length() == 0) {
            errorMessage += "No valid handicap max!\n"; 
        } else {
            // try to parse the handicap max into a float.
            try {
                Float.parseFloat(handicapMaxField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid handicap max (must be an integer)!\n"; 
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