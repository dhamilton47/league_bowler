package com.tsksolutions.leaguebowler.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of league. This is used for saving the
 * list of leagues to XML.
 * 
 * @author Dan J. Hamilton
 */

	//TODO: Replace with MySQL and corresponding JDBC code

@XmlRootElement(name = "leagues")
public class LeagueListWrapper {

    private List<League> leagues;

    @XmlElement(name = "league")
    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }
}