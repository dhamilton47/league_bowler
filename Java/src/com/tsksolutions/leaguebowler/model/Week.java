package com.tsksolutions.leaguebowler.model;

// import java.time.LocalDate;

// import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

// import com.tsksolutions.leaguebowler.util.LocalDateAdapter;
import javafx.beans.property.IntegerProperty;
// import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
// import javafx.beans.property.SimpleObjectProperty;
// import javafx.beans.property.SimpleStringProperty;
// import javafx.beans.property.StringProperty;

/**
 * Model class for results from a Week.
 *
 * @author Dan J. Hamilton
 */
public class Week {
    private final IntegerProperty leagueID;
    private final IntegerProperty bowlerID;
    private final StringProperty leagueName;
    private final StringProperty bowlerName;
    private final IntegerProperty weekNumber;
    private final IntegerProperty game1;
    private final IntegerProperty game2;
    private final IntegerProperty game3;
    private final IntegerProperty scratchPinfallBegin;
    private final IntegerProperty scratchPinfallWeek;
    private final IntegerProperty scratchPinfallEnd;
    private final IntegerProperty gameCountBegin;
    private final IntegerProperty gameCountWeek;
    private final IntegerProperty gameCountEnd;
    private final IntegerProperty scratchAverageBegin;
    private final IntegerProperty scratchAverageEnd;
    private final IntegerProperty handicapBegin;
    private final IntegerProperty handicapEnd;
//    private final ObjectProperty<LocalDate> lastUpdate;

    /**
     * Default constructor.
     */
    public Week() {
        this(0, 0);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param leagueName
     * @param bowlerName
     */
    public Week(int leagueID, int bowlerID) {
        this.leagueID = new SimpleIntegerProperty(leagueID);
        this.bowlerID = new SimpleIntegerProperty(bowlerID);
        this.leagueName = new SimpleStringProperty("Some League");
        this.bowlerName = new SimpleStringProperty("Some Bowler");

        // Some initial dummy data, just for convenient testing.
        this.weekNumber = new SimpleIntegerProperty(1);
        this.game1 = new SimpleIntegerProperty(120);
        this.game2 = new SimpleIntegerProperty(120);
        this.game3 = new SimpleIntegerProperty(120);
        this.scratchPinfallBegin = new SimpleIntegerProperty(120);
        this.scratchPinfallWeek = new SimpleIntegerProperty(120);
        this.scratchPinfallEnd = new SimpleIntegerProperty(120);
        this.gameCountBegin = new SimpleIntegerProperty(120);
        this.gameCountWeek = new SimpleIntegerProperty(120);
        this.gameCountEnd = new SimpleIntegerProperty(120);
        this.scratchAverageBegin = new SimpleIntegerProperty(120);
        this.scratchAverageEnd = new SimpleIntegerProperty(120);
        this.handicapBegin = new SimpleIntegerProperty(120);
        this.handicapEnd = new SimpleIntegerProperty(120);
        
    }

    public int getLeagueID() {
        return leagueID.get();
    }

    public void setFirstName(int leagueID) {
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

    public int getBowlerID() {
        return bowlerID.get();
    }

    public void setBowlerID(int bowlerID) {
        this.bowlerID.set(bowlerID);
    }

    public IntegerProperty bowlerIDProperty() {
        return bowlerID;
    }

    public String getBowlerName() {
        return bowlerName.get();
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName.set(bowlerName);
    }

    public StringProperty bowlerNameProperty() {
        return bowlerName;
    }

    public int getWeekNumber() {
        return weekNumber.get();
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber.set(weekNumber);
    }

    public IntegerProperty weekNumberProperty() {
        return weekNumber;
    }

    public int getGame1() {
        return game1.get();
    }

    public void setGame1(int game1) {
        this.game1.set(game1);
    }

    public IntegerProperty game1Property() {
        return game1;
    }

    public int getGame2() {
        return game2.get();
    }

    public void setGame2(int game2) {
        this.game2.set(game2);
    }

    public IntegerProperty game2Property() {
        return game2;
    }

    public int getGame3() {
        return game3.get();
    }

    public void setGame3(int game3) {
        this.game3.set(game3);
    }

    public IntegerProperty game3Property() {
        return game3;
    }

    public int getScratchPinfallBegin() {
        return scratchPinfallBegin.get();
    }

    public void setScratchPinfallBegin(int scratchPinfallBegin) {
        this.scratchPinfallBegin.set(scratchPinfallBegin);
    }

    public IntegerProperty scratchPinfallBeginProperty() {
        return scratchPinfallBegin;
    }

    public int getScratchPinfallWeek() {
        return scratchPinfallWeek.get();
    }

    public void setScratchPinfallWeek(int scratchPinfallWeek) {
        this.scratchPinfallWeek.set(scratchPinfallWeek);
    }

    public IntegerProperty scratchPinfallWeekProperty() {
        return scratchPinfallWeek;
    }

    public int getScratchPinfallEnd() {
        return scratchPinfallEnd.get();
    }

    public void setScratchPinfallEnd(int scratchPinfallEnd) {
        this.scratchPinfallEnd.set(scratchPinfallEnd);
    }

    public IntegerProperty scratchPinfallEndProperty() {
        return scratchPinfallEnd;
    }

    public int getGameCountBegin() {
        return gameCountBegin.get();
    }

    public void setGameCountBegin(int gameCountBegin) {
        this.gameCountBegin.set(gameCountBegin);
    }

    public IntegerProperty gameCountBeginProperty() {
        return gameCountBegin;
    }

    public int getGameCountWeek() {
        return gameCountWeek.get();
    }

    public void setGameCountWeek(int gameCountWeek) {
        this.gameCountWeek.set(gameCountWeek);
    }

    public IntegerProperty gameCountWeekProperty() {
        return gameCountWeek;
    }

    public int getGameCountEnd() {
        return gameCountEnd.get();
    }

    public void setGameCountEnd(int gameCountEnd) {
        this.gameCountEnd.set(gameCountEnd);
    }

    public IntegerProperty gameCountEndProperty() {
        return gameCountEnd;
    }

    public int getScratchAverageBegin() {
        return scratchAverageBegin.get();
    }

    public void setScratchAverageBegin(int scratchAverageBegin) {
        this.scratchAverageBegin.set(scratchAverageBegin);
    }

    public IntegerProperty scratchAverageBeginProperty() {
        return scratchAverageBegin;
    }

    public int getScratchAverageEnd() {
        return scratchAverageEnd.get();
    }

    public void setScratchAverageEnd(int scratchAverageEnd) {
        this.scratchAverageEnd.set(scratchAverageEnd);
    }

    public IntegerProperty scratchAverageEndProperty() {
        return scratchAverageEnd;
    }

    public int getHandicapBegin() {
        return handicapBegin.get();
    }

    public void setHandicapBegin(int handicapBegin) {
        this.handicapBegin.set(handicapBegin);
    }

    public IntegerProperty handicapBeginProperty() {
        return handicapBegin;
    }

    public int getHandicapEnd() {
        return handicapEnd.get();
    }

    public void setHandicapEnd(int handicapEnd) {
        this.handicapEnd.set(handicapEnd);
    }

    public IntegerProperty handicapEndProperty() {
        return handicapEnd;
    }

}
