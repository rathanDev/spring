package org.sliit.model;

public class Halt {

    private String name;
    private String location;
    private String nextHalt;
    private String previousHalt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNextHalt() {
        return nextHalt;
    }

    public void setNextHalt(String nextHalt) {
        this.nextHalt = nextHalt;
    }

    public String getPreviousHalt() {
        return previousHalt;
    }

    public void setPreviousHalt(String previousHalt) {
        this.previousHalt = previousHalt;
    }
}
