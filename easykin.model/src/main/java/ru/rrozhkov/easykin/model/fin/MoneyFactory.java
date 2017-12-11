package ru.rrozhkov.easykin.model.fin;

/**
 * Created by rrozhkov on 2/14/2017.
 */
public class MoneyFactory {
    public static Money create(Money value){
        return new Money(value);
    }
}
