package ru.rrozhkov.easykin.model.module.impl;

import ru.rrozhkov.easykin.model.module.IModule;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public class Module implements IModule {
    private int id;
    private String name;

    protected Module(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
