package ru.rrozhkov.easykin.model.fin.bill.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.bill.IBill;

/**
 * Created by rrozhkov on 2/14/2017.
 */
public abstract class Bill implements IBill {
    protected int id;
    protected String name;
    protected Money balance;

    public Bill(int id, String name, Money balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getBalance() {
        return balance;
    }

    public Money deposit(Money money) {
        return balance.add(money);
    }

    public Money credit(Money money) {
        return balance.substract(money);
    }
}
