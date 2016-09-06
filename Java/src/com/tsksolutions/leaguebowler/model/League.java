package com.tsksolutions.leaguebowler.model;

//import java.time.LocalDate;

//import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//import com.tsksolutions.leaguebowler.util.LocalDateAdapter;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a League.
 *
 * @author Dan J. Hamilton
 */
public class League {

    private final IntegerProperty leagueID;
    private final StringProperty leagueName;
    private final StringProperty sanctionCenter;
    private final BooleanProperty hasHandicap;
    private final IntegerProperty handicapTarget;
    private final FloatProperty handicapPercent;

    /**
     * Default constructor.
     */
    public League() {
        this(0, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param leagueID
     * @param leagueName
     */
    public League(int leagueID, String leagueName) {
        this.leagueID = new SimpleIntegerProperty(leagueID);
        this.leagueName = new SimpleStringProperty(leagueName);

        // Some initial dummy data, just for convenient testing.
        this.sanctionCenter = new SimpleStringProperty("some bowling alley");
        this.hasHandicap = new SimpleBooleanProperty(true);
        this.handicapTarget = new SimpleIntegerProperty(200);
        this.handicapPercent = new SimpleFloatProperty(0.95f);
    }

    public int getLeagueID() {
        return leagueID.get();
    }

    public void setLeagueID(int leagueID) {
        this.leagueID.set(leagueID);
    }

    public IntegerProperty leagueIDProperty() {
        return leagueID;
    }

    public String getLeagueName() {
        return leagueName.get();
    }

    public void setLeagueName(String leagueName) {
        this.leagueName.set(leagueName);
    }

    public StringProperty leagueNameProperty() {
        return leagueName;
    }

    public String getSanctionCenter() {
        return sanctionCenter.get();
    }

    public void setSanctionCenter(String sanctionCenter) {
        this.sanctionCenter.set(sanctionCenter);
    }

    public StringProperty sanctionCenterProperty() {
        return sanctionCenter;
    }

    public boolean getHasHandicap() {
        return hasHandicap.get();
    }

    public void setHasHandicap(boolean hasHandicap) {
        this.hasHandicap.set(hasHandicap);
    }

    public BooleanProperty hasHandicapProperty() {
        return hasHandicap;
    }

    public int getHandicapTarget() {
        return handicapTarget.get();
    }

    public void setHandicapTarget(int handicapTarget) {
        this.handicapTarget.set(handicapTarget);
    }

    public IntegerProperty handicapTargetProperty() {
        return handicapTarget;
    }

    public float getHandicapPercent() {
        return handicapPercent.get();
    }

    public void setHandicapPercent(float handicapPercent) {
        this.handicapPercent.set(handicapPercent);
    }

    public FloatProperty handicapPercentProperty() {
        return handicapPercent;
    }
}