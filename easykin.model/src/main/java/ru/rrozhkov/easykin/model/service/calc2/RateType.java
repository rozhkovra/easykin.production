package ru.rrozhkov.easykin.model.service.calc2;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public enum RateType{
    ELECTRICITY("Электричество"),
    GAZ("Газ"),
    WATERIN("Вода подача"),
    WATEROUT("Водоотведение"),
    HOTWATER("Горячая вода"),
    ANTENNA("Антенна"),
    INTERCOM("Домофон"),
    REPAIR("Кап.ремонт"),
    GARBAGE("Вывоз ТКО"),
    HOUSE("Квартплата"),
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
    public boolean isHouse() {return this==HOUSE;}
    public boolean isGarbage() {return this==GARBAGE;}


    public static RateType type(String type) {
        if(ELECTRICITY.toString().equals(type))
            return ELECTRICITY;
        else if(GAZ.toString().equals(type))
            return GAZ;
        else if(WATERIN.toString().equals(type))
            return WATERIN;
        else if(WATEROUT.toString().equals(type))
            return WATEROUT;
        else if(HOTWATER.toString().equals(type))
            return HOTWATER;
        else if(ANTENNA.toString().equals(type))
            return ANTENNA;
        else if(INTERCOM.toString().equals(type))
            return INTERCOM;
        else if(REPAIR.toString().equals(type))
            return REPAIR;
        else if(HOUSE.toString().equals(type))
            return HOUSE;
        else if(HEATING.toString().equals(type))
            return HEATING;
        else if(GARBAGE.toString().equals(type))
            return GARBAGE;
        return null;
    }
}
