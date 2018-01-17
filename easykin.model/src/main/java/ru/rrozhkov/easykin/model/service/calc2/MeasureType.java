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

    public static MeasureType type(String type) {
        if(ELECTRICITY.toString().equals(type))
            return ELECTRICITY;
        else if(GAZ.toString().equals(type))
                return GAZ;
        else if(COLDWATER.toString().equals(type))
            return COLDWATER;
        else if(HOTWATER.toString().equals(type))
            return HOTWATER;
        return null;
    }
}
