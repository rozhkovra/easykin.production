package ru.rrozhkov.easykin.person.db.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.impl.convert.PersonConverterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.crypt.Encrypter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.util.Collection;

/**
 * Created by rrozhkov on 3/9/2017.
 */
public class AuthHandler {
    private static final Encrypter encrypter = new Encrypter();
    private static final IDBManager dbManager = DBManager.instance();
    private static final PersonConverterFactory converterFactory = new PersonConverterFactory();

    private static String select = "select * from PERSON where username='#username#' and password='#password#'";
    public static IPerson auth(String username, String password) throws Exception {
        Collection<IPerson> persons = dbManager.select(
                select.replace("#username#",username).replace("#password#", encrypter.encrypt(password))
                , converterFactory.person());
        if(persons.isEmpty() || persons.size()>1)
            return null;
        return CollectionUtil.get(persons,0);
    }
}
