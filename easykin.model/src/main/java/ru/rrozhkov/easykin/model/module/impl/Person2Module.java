package ru.rrozhkov.easykin.model.module.impl;

import ru.rrozhkov.easykin.model.module.IPerson2Module;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public class Person2Module implements IPerson2Module {
    private int id;
    private int personId;
    private int moduleId;

    protected Person2Module(int id, int personId, int moduleId) {
        this.id = id;
        this.personId = personId;
        this.moduleId = moduleId;
    }

    public int getId() {
        return id;
    }

    public int getPersonId() {
        return personId;
    }

    public int getModuleId() {
        return moduleId;
    }
}
