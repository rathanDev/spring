package org.jana.model;

import java.util.Date;

public class Journey {

    private Date date;

    private Halt fromHalt;
    private String fromHaltName;

    private Halt toHalt;
    private String toHaltName;

    public Journey() {
    }

    public Journey(Halt fromHalt, Halt toHalt) {
        this.fromHalt = fromHalt;
        this.toHalt = toHalt;
    }

    public Journey(Date date, Halt fromHalt, Halt toHalt) {
        this.date = date;
        this.fromHalt = fromHalt;
        this.toHalt = toHalt;
    }

    public Journey(Date date, String fromHaltName, String toHaltName) {
        this.date = date;
        this.fromHaltName = fromHaltName;
        this.toHaltName = toHaltName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Halt getFromHalt() {
        return fromHalt;
    }

    public void setFromHalt(Halt fromHalt) {
        this.fromHalt = fromHalt;
    }

    public String getFromHaltName() {
        return fromHaltName;
    }

    public void setFromHaltName(String fromHaltName) {
        this.fromHaltName = fromHaltName;
    }

    public Halt getToHalt() {
        return toHalt;
    }

    public void setToHalt(Halt toHalt) {
        this.toHalt = toHalt;
    }

    public String getToHaltName() {
        return toHaltName;
    }

    public void setToHaltName(String toHaltName) {
        this.toHaltName = toHaltName;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "fromHalt=" + fromHalt +
                ", toHalt=" + toHalt +
                '}';
    }

}
