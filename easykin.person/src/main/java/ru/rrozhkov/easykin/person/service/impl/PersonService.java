package ru.rrozhkov.easykin.person.service.impl;

import ru.rrozhkov.easykin.person.db.impl.PersonHandler;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public class PersonService {
    private static final PersonHandler personHandler = new PersonHandler();

    public static Collection persons(){
        Collection persons = CollectionUtil.create();
        try {
            persons = personHandler.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }
}
