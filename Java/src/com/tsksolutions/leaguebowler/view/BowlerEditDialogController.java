package com.tsksolutions.leaguebowler.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import com.tsksolutions.leaguebowler.model.Bowler;
import com.tsksolutions.leaguebowler.util.DateUtil;

/**
 * Dialog to edit details of a bowler.
 * 
 * @author Dan J. Hamilton
 */
public class BowlerEditDialogController {

    @FXML
    private ComboBox<String> bowlerTypeBox;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField middleNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField suffixNameField;
    @FXML
    private TextField nicknameField;
//    TODO: set up option group for sex field
    @FXML
    private ToggleGroup sexToggleGroup;
    @FXML
    private RadioButton sexFemale;
    @FXML
    private RadioButton sexMale;
    @FXML
    private DatePicker birthdayPicker;

    @FXML
  	private TextField addressLine1Field;
  	@FXML
  	private TextField addressLine2Field;
  	@FXML
  	private TextField cityField;
  	@FXML
  	private TextField stateField;
  	@FXML
  	private TextField zipCodeField;

// TODO: Fix the phone and email classes for inclusion
//  @FXML
//  private TextField phoneField;
//  @FXML
//  private TextField emailField;


    private Stage dialogStage;
    private Bowler bowler;
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
     * Sets the bowler to be edited in the dialog.
     * 
     * @param bowler
     */
    public void setBowler(Bowler bowler) {
        this.bowler = bowler;

        bowlerTypeBox.setValue(bowler.getBowlerType());
        firstNameField.setText(bowler.getFirstName());
        middleNameField.setText(bowler.getMiddleName());
        lastNameField.setText(bowler.getLastName());
        suffixNameField.setText(bowler.getSuffixName());
        nicknameField.setText(bowler.getNickname());
        System.out.println(bowler.getBowlerType());
//        sexToggleGroup.selectToggle(bowler.getSex());
        birthdayPicker.setValue(bowler.getBirthday());
//        dateOfBirthPicker.setPromptText("dd.mm.yyyy");
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
        	bowler.setBowlerType((String)bowlerTypeBox.getValue());
        	bowler.setFirstName(firstNameField.getText());
        	bowler.setMiddleName(middleNameField.getText());
        	bowler.setLastName(lastNameField.getText());
        	bowler.setSuffixName(suffixNameField.getText());
        	bowler.setNickname(nicknameField.getText());
//        	bowler.setSex(sexField.getText());
        	bowler.setBirthday(birthdayPicker.getValue());

        	bowler.setAddressLine1(addressLine1Field.getText());
        	bowler.setAddressLine2(addressLine2Field.getText());
        	bowler.setCity(cityField.getText());
        	bowler.setState(stateField.getText());
        	bowler.setZipCode(Integer.parseInt(zipCodeField.getText()));

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
   	// Since we are using a datepicker object to obtain the value for the birthday, we should not have to test if it is a valid date.
        String errorMessage = "";
        
        /*
         * Nickname, suffix name and address line 2 are not required fields, so we will not test for validity, however, nickname will be set to first name if empty.
         */
        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }

        if (middleNameField.getText() == null || middleNameField.getText().length() == 0) {
            errorMessage += "No valid middle name!\n"; 
        }

        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }

        if (nicknameField.getText() == null || nicknameField.getText().length() == 0) {
            nicknameField.setText(firstNameField.getText()); 
        }
/*
        if (sexField.getText() == null || sexField.getText().length() == 0) {
            errorMessage += "No valid gender chosen!\n"; 
        }
*/
        if (birthdayPicker.getValue() == null) {
            errorMessage += "No valid birthday!\n";
        }

        if (addressLine1Field.getText() == null || addressLine1Field.getText().length() == 0) {
             errorMessage += "No valid street!\n"; 
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (stateField.getText() == null || stateField.getText().length() != 2) {
            errorMessage += "No valid state abbreviation!\n"; 
        }

        if (zipCodeField.getText() == null || zipCodeField.getText().length() == 0) {
            errorMessage += "No valid zip code!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(zipCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid zip code (must be an integer)!\n"; 
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