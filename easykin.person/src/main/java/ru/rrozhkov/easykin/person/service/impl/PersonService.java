package ru.rrozhkov.easykin.person.service.impl;

import ru.rrozhkov.easykin.person.db.impl.PersonHandler;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public class PersonService {
    private static final PersonHandler personHandler = PersonHandler.instance();

    public static class PersonServiceHolder {
        public static final PersonService INSTANCE = new PersonService();
    }

    public static PersonService instance(){
        return PersonServiceHolder.INSTANCE;
    }

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
