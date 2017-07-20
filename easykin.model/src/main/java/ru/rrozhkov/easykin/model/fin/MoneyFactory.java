package ru.rrozhkov.easykin.model.fin;

/**
 * Created by rrozhkov on 2/14/2017.
 */
public class MoneyFactory {
    public static Money create(double value){
        return new Money(value);
    }
    public static Money create(){
        return new Money(0.0);
    }
    public static Money create(String text){
        return new Money(Double.valueOf(text));
    }
    public static Money create(Money value){
        return new Money(value);
    }
}
