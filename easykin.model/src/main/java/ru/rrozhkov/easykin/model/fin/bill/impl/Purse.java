package ru.rrozhkov.easykin.model.fin.bill.impl;

import ru.rrozhkov.easykin.model.fin.Money;

/**
 * Created by rrozhkov on 2/14/2017.
 */
public class Purse extends Bill {
    public Purse(int id, String name, Money balance) {
        super(id, name, balance);
    }
}
