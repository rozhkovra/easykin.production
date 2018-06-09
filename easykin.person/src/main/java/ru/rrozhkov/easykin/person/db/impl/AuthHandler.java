package ru.rrozhkov.easykin.person.db.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.crypt.Encrypter;

import java.util.Collection;

/**
 * Created by rrozhkov on 3/9/2017.
 */
public class AuthHandler extends PersonHandler {
    private static final Encrypter encrypter = new Encrypter();

    private String selectPerson = "select * from "+getTableName()+" where username='#username#' and password='#password#'";

    public static class AuthHandlerHolder {
        public static final AuthHandler INSTANCE = new AuthHandler();
    }

    public static AuthHandler instance(){
        return AuthHandlerHolder.INSTANCE;
    }

    public IPerson auth(String username, String password) throws Exception {
        Collection<IPerson> persons = dbManager().select(
                selectPerson.replace("#username#", username).replace("#password#", encrypter.encrypt(password))
                , getConverter());
        if(persons.isEmpty() || persons.size()>1)
            return null;
        return CollectionUtil.get(persons,0);
    }
}
