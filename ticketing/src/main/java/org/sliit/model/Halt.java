package org.sliit.model;

public class Halt {

    private String name;
    private String location;
    private String nextHaltName;
    private Halt nextHalt;
    private String previousHaltName;
    private Halt previousHalt;

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

    public String getNextHaltName() {
        return nextHaltName;
    }

    public void setNextHaltName(String nextHaltName) {
        this.nextHaltName = nextHaltName;
    }

    public String getPreviousHaltName() {
        return previousHaltName;
    }

    public void setPreviousHaltName(String previousHaltName) {
        this.previousHaltName = previousHaltName;
    }

    public Halt getNextHalt() {
        return nextHalt;
    }

    public void setNextHalt(Halt nextHalt) {
        this.nextHalt = nextHalt;
    }

    public Halt getPreviousHalt() {
        return previousHalt;
    }

    public void setPreviousHalt(Halt previousHalt) {
        this.previousHalt = previousHalt;
    }

}
