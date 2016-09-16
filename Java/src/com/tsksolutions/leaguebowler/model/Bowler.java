package com.tsksolutions.leaguebowler.model;

//import java.sql.Timestamp;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tsksolutions.leaguebowler.util.LocalDateAdapter;
import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//import javafx.scene.control.Toggle;
//import javafx.scene.control.ToggleGroup;

/**
 * Model class for a Bowler.
 *
 * @author Dan J. Hamilton
 */
public class Bowler {

    private final IntegerProperty bowlerID;
    private final StringProperty bowlerType;
    private final StringProperty firstName;
    private final StringProperty middleName;
    private final StringProperty lastName;
    private final StringProperty suffixName;
    private final StringProperty nickname;
    private final StringProperty sex; 
    private final ObjectProperty<LocalDate> birthday;
    private final StringProperty user;
//    private final Timestamp lastUpdate;
    
    private final StringProperty addressLine1;
    private final StringProperty addressLine2;
    private final StringProperty city;
    private final StringProperty state;
    private final IntegerProperty zipCode;
    
//    private final LongProperty phoneNumber;
//    private final StringProperty email;
    

    /**
     * Default constructor.
     */
    public Bowler() {
        this(0, null, null, null, null, null, null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param middleName
     * @param lastName
     */
/*    public Bowler(String firstName, String middleName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.bowlerID = new SimpleIntegerProperty(1);
        this.suffixName = new SimpleStringProperty("");
        this.nickname = new SimpleStringProperty("");
        this.bowlerType = new SimpleStringProperty("Youth");
//        this.sexToggleGroup = new SimpleMapProperty<Toggle>("M");
//        this.sex = new SimpleStringProperty("M");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
        this.addressLine1 = new SimpleStringProperty("some street");
        this.addressLine2 = new SimpleStringProperty("some suite");
        this.city = new SimpleStringProperty("some city");
        this.state = new SimpleStringProperty("FL");
        this.zipCode = new SimpleIntegerProperty(12345);
        this.user = new SimpleStringProperty("Dan");
//        this.lastUpdate = CURRENT_TIMESTAMP;
    }
*/
    /**
     * Main Constructor - still contains some initial data.
     * 
     * @param bowlerType Predefined option: 'Youth' or 'Adult'
     * @param firstName Bowler's legal first name
     * @param middleName Bowler's legal middle name
     * @param lastName Bowler's legal last name
     * @param suffixName Examples are:  Sr., Jr., II, III, etc - Default is null
     * @param nickname Name bowler prefers to be called
     * @param sex Predefined option: 'F' or 'M'
     */
    public Bowler(int bowlerID, String bowlerType, String firstName, String middleName, String lastName,
    		String suffixName, String nickname, String sex) {
        this.bowlerID = new SimpleIntegerProperty(bowlerID);
        this.bowlerType = new SimpleStringProperty(bowlerType);
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);
        this.suffixName = new SimpleStringProperty(suffixName);
        this.nickname = new SimpleStringProperty(nickname);
        this.sex = new SimpleStringProperty(sex);

        // Some initial dummy data, just for convenient testing.
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
        this.addressLine1 = new SimpleStringProperty("some street");
        this.addressLine2 = new SimpleStringProperty("some suite");
        this.city = new SimpleStringProperty("some city");
        this.state = new SimpleStringProperty("FL");
        this.zipCode = new SimpleIntegerProperty(12345);
        this.user = new SimpleStringProperty("Dan");
//        this.lastUpdate = CURRENT_TIMESTAMP;
    }

    public int getBowlerID() {
        return bowlerID.get();
    }

    public void setBowlerID(int bowlerID) {
        this.bowlerID.set(bowlerID);
    }

    public IntegerProperty bowlerIDProperty() {
        return bowlerID;
    }

    public String getBowlerType() {
        return bowlerType.get();
    }

    public void setBowlerType(String bowlerType) {
        this.bowlerType.set(bowlerType);
    }

    public StringProperty bowlerTypeProperty() {
        return bowlerType;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public StringProperty middleNameProperty() {
        return middleName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getSuffixName() {
        return suffixName.get();
    }

    public void setSuffixName(String suffixName) {
        this.suffixName.set(suffixName);
    }

    public StringProperty suffixNameProperty() {
        return suffixName;
    }

    public String getNickname() {
        return nickname.get();
    }

    public void setNickname(String nickname) {
        this.nickname.set(nickname);
    }

    public StringProperty nicknameProperty() {
        return nickname;
    }

    public String getSex() {
        return sex.get();
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public StringProperty sexProperty() {
        return sex;
    }

/*
     public Toggle getSexToggleGroup() {
 
        return sexToggleGroup.getSelectedToggle();
    }

    public void setSexToggleGroup(Toggle sexToggleGroup) {
        this.sexToggleGroup.readOnlyObjectProperty<Toggle>(sexToggleGroup);
    }

    public Toggle sexProperty() {
        return sexToggleGroup;
    }
*/
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public String getUser() {
        return user.get();
    }

    public void setUser(String user) {
        this.user.set(user);
    }

    public StringProperty userProperty() {
        return user;
    }

    public String getAddressLine1() {
        return addressLine1.get();
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1.set(addressLine1);
    }

    public StringProperty addressLine1Property() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2.get();
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2.set(addressLine2);
    }

    public StringProperty addressLine2Property() {
        return addressLine2;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public StringProperty stateProperty() {
        return state;
    }

    public int getZipCode() {
        return zipCode.get();
    }

    public void setZipCode(int zipCode) {
        this.zipCode.set(zipCode);
    }

    public IntegerProperty zipCodeProperty() {
        return zipCode;
    }

}