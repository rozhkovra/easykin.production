package ru.rrozhkov.easykin.model.service.calc2;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public enum MeasureType {
    ELECTRICITY("?????????????"),
    GAZ("???"),
    COLDWATER("????"),
    HOTWATER("??????? ????");

    private final String name;

    private MeasureType (String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
