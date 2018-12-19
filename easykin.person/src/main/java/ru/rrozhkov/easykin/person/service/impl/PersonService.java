package ru.rrozhkov.easykin.person.service.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.service.impl.EntityService;
import ru.rrozhkov.easykin.person.db.impl.PersonHandler;

import java.util.Collection;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public class PersonService extends EntityService {
    public static class PersonServiceHolder {
        public static final PersonService INSTANCE = new PersonService();
    }

    public static PersonService instance(){
        return PersonServiceHolder.INSTANCE;
    }

    public PersonService() {
        super(PersonHandler.instance());
    }

    public Collection persons(){
        Collection persons = CollectionUtil.create();
        try {
            persons = findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }
}
