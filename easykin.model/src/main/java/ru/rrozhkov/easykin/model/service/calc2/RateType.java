package ru.rrozhkov.easykin.model.service.calc2;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public enum RateType {
    ELECTRICITY("Электричество"),
    GAZ("Газ"),
    WATERIN("Вода подача"),
    WATEROUT("Водоотведение"),
    HOTWATER("Горячая вода");

    private final String name;

    private RateType (String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
    public boolean isElectricity() {return this==ELECTRICITY;}
    public boolean isGaz() {return this==GAZ;}
    public boolean isWaterIn() {return this==WATERIN;}
    public boolean isWaterOut() {return this==WATEROUT;}
    public boolean isHotWater() {return this==HOTWATER;}

}
