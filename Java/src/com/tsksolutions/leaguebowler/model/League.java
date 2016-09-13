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
    private final IntegerProperty totalWeeks;
    private final BooleanProperty hasHandicap;
    private final FloatProperty handicapTarget;
    private final FloatProperty handicapPercent;
    private final FloatProperty handicapMax;
    private final StringProperty user;

    /**
     * Default constructor.
     */
    public League() {
        this(0, null, null, 0, false, 0f, 0f, 0f);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param leagueID
     * @param leagueName
     */
    public League(int leagueID, String leagueName, String sanctionCenter, int totalWeeks, 
    		boolean hasHandicap, float handicapTarget, float handicapPercent, float handicapMax) {
        this.leagueID = new SimpleIntegerProperty(leagueID);
        this.leagueName = new SimpleStringProperty(leagueName);
        this.sanctionCenter = new SimpleStringProperty(sanctionCenter);
        this.totalWeeks = new SimpleIntegerProperty(totalWeeks);
        this.hasHandicap = new SimpleBooleanProperty(hasHandicap);
        this.handicapTarget = new SimpleFloatProperty(handicapTarget);
        this.handicapPercent = new SimpleFloatProperty(handicapPercent);
        this.handicapMax = new SimpleFloatProperty(handicapMax);
        this.user = new SimpleStringProperty("Dan");
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

    public int getTotalWeeks() {
        return totalWeeks.get();
    }

    public void setTotalWeeks(int totalWeeks) {
        this.totalWeeks.set(totalWeeks);
    }

    public IntegerProperty totalWeeksProperty() {
        return totalWeeks;
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

    public float getHandicapTarget() {
        return handicapTarget.get();
    }

    public void setHandicapTarget(float handicapTarget) {
        this.handicapTarget.set(handicapTarget);
    }

    public FloatProperty handicapTargetProperty() {
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
    public float getHandicapMax() {
        return handicapMax.get();
    }

    public void setHandicapMax(float handicapMax) {
        this.handicapMax.set(handicapMax);
    }

    public FloatProperty handicapMaxProperty() {
        return handicapMax;
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

}