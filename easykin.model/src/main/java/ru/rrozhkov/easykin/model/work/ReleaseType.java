package ru.rrozhkov.easykin.model.work;

/**
 * Created by rrozhkov on 1/15/2018.
 */
public enum ReleaseType {
    R800("8.0.0"),
    R810("8.1.0"),
    R900("9.0.0"),
    R901("9.0.1"),
    R1000("10.0.0"),
    R1100("11.0.0"),
    R1200("12.0.0"),
    R1210("12.1.0"),
    R1400("14.0.0"),
    R1500("15.0.0"),
    NORELEASE("Вне релиза"),
    L4("L4"),
    ANOTHER("Другое");

    private final String name;

    private ReleaseType (String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }

    public static ReleaseType type(String str){
        if(R800.toString().equals(str))
            return R800;
        else if(R810.toString().equals(str))
            return R810;
        else if(R900.toString().equals(str))
            return R900;
        else if(R901.toString().equals(str))
            return R901;
        else if(R1000.toString().equals(str))
            return R1000;
        else if(R1100.toString().equals(str))
            return R1100;
        else if(R1200.toString().equals(str))
            return R1200;
        else if(R1210.toString().equals(str))
            return R1210;
        else if(R1400.toString().equals(str))
            return R1400;
        else if(R1500.toString().equals(str))
            return R1500;
        else if(NORELEASE.toString().equals(str))
            return NORELEASE;
        else if(L4.toString().equals(str))
            return L4;

        return ANOTHER;
    }
}
