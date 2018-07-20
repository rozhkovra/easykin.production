package ru.rrozhkov.easykin.model.fin;

/**
 * Created by rrozhkov on 11.07.2018.
 */
public interface IPayable {
    boolean isPaid();
    Money getAmount();
}
