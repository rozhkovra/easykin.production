package ru.rrozhkov.easykin.model.fin.bill;

import ru.rrozhkov.easykin.model.fin.Money;

/**
 * Created by rrozhkov on 2/14/2017.
 */
public interface IBill {
    int getId();
    String getName();
    Money getBalance();
    Money deposit(Money money);
    Money credit(Money money);
}
