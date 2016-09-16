package com.tsksolutions.leaguebowler.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
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
    private TextField fldLeagueName;
    @FXML
    private TextField fldSanctionCenter;
    @FXML
    private TextField fldTotalWeeks;
    @FXML
    private RadioButton rbHasHandicap;
    @FXML
    private TextField fldHandicapTarget;
    @FXML
    private TextField fldHandicapPercent;
    @FXML
    private TextField fldHandicapMax;


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

        fldLeagueName.setText(league.getLeagueName());
        fldSanctionCenter.setText(league.getSanctionCenter());
        fldTotalWeeks.setText(Integer.toString(league.getTotalWeeks()));
        rbHasHandicap.setText(Boolean.toString(league.getHasHandicap()));
        fldHandicapTarget.setText(Float.toString(league.getHandicapTarget()));
        fldHandicapPercent.setText(Float.toString(league.getHandicapPercent()));
        fldHandicapMax.setText(Float.toString(league.getHandicapMax()));
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
        	league.setLeagueName(fldLeagueName.getText());
        	league.setSanctionCenter(fldSanctionCenter.getText());
        	league.setTotalWeeks(Integer.parseInt(fldTotalWeeks.getText()));
        	league.setHasHandicap(Boolean.parseBoolean(rbHasHandicap.getText()));
        	league.setHandicapTarget(Float.parseFloat(fldHandicapTarget.getText()));
        	league.setHandicapPercent(Float.parseFloat(fldHandicapPercent.getText()));
        	league.setHandicapMax(Float.parseFloat(fldHandicapMax.getText()));

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

        if (fldLeagueName.getText() == null || fldLeagueName.getText().length() == 0) {
            errorMessage += "No valid league name!\n"; 
        }

        if (fldSanctionCenter.getText() == null || fldSanctionCenter.getText().length() == 0) {
            errorMessage += "No valid bowling center!\n"; 
        }

        if (rbHasHandicap.getText() == null || rbHasHandicap.getText().length() == 0) {
            errorMessage += "No valid handicap option!\n"; 
        } else {
            // try to parse the has handicap option into a boolean.
            try {
                Boolean.parseBoolean(rbHasHandicap.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid has handicap option (must be a boolean)!\n"; 
            }
        }

        if (fldTotalWeeks.getText() == null || fldTotalWeeks.getText().length() == 0) {
            errorMessage += "No valid total weeks for season!\n"; 
        } else {
            // try to parse the total weeks into an float.
            try {
                Integer.parseInt(fldHandicapTarget.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid total weeks (must be an integer)!\n"; 
            }
        }

        if (fldHandicapTarget.getText() == null || fldHandicapTarget.getText().length() == 0) {
            errorMessage += "No valid handicap target!\n"; 
        } else {
            // try to parse the handicap target into an int.
            try {
                Integer.parseInt(fldHandicapTarget.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid handicap target (must be an integer)!\n"; 
            }
        }

        if (fldHandicapPercent.getText() == null || fldHandicapPercent.getText().length() == 0) {
            errorMessage += "No valid handicap percent!\n"; 
        } else {
            // try to parse the handicap percent into a float.
            try {
                Float.parseFloat(fldHandicapPercent.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid handicap percent (must be a decimal)!\n"; 
            }
        }

        if (fldHandicapMax.getText() == null || fldHandicapMax.getText().length() == 0) {
            errorMessage += "No valid handicap max!\n"; 
        } else {
            // try to parse the handicap max into a float.
            try {
                Float.parseFloat(fldHandicapMax.getText());
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