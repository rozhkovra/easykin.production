package ru.rrozhkov.easykin.model.service.calc2;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public enum MeasureType {
    ELECTRICITY("Свет"),
    GAZ("Газ"),
    COLDWATER("Вода"),
    HOTWATER("Горячая вода");

    private final String name;

    private MeasureType (String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
    public boolean isElectricity() {return this==ELECTRICITY;}
    public boolean isGaz() {return this==GAZ;}
    public boolean isColdWater() {return this==COLDWATER;}
    public boolean isHotWater() {return this==HOTWATER;}
}
