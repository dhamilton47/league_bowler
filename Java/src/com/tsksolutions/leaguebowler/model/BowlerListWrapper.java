package com.tsksolutions.leaguebowler.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * @author Dan J. Hamilton
 */

	//TODO: Replace with MySQL and corresponding JDBC code

@XmlRootElement(name = "bowlers")
public class BowlerListWrapper {

    private List<Bowler> bowlers;

    @XmlElement(name = "bowler")
    public List<Bowler> getBowlers() {
        return bowlers;
    }

    public void setBowlers(List<Bowler> bowlers) {
        this.bowlers = bowlers;
    }
}