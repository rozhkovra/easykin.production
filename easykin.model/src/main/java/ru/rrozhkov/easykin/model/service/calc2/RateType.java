package ru.rrozhkov.easykin.model.service.calc2;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public enum RateType {
    ELECTRICITY("Электричество"),
    GAZ("Газ"),
    WATERIN("Вода подача"),
    WATEROUT("Водоотведение"),
    HOTWATER("Горячая вода"),
    ANTENNA("Антенна"),
    INTERCOM("Домофон"),
    REPAIR("Кап.ремонт"),
    HEATING("Отопление");

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
    public boolean isAntenna() {return this==ANTENNA;}
    public boolean isIntercom() {return this==INTERCOM;}
    public boolean isHeating() {return this==HEATING;}
    public boolean isRepair() {return this==REPAIR;}
}
