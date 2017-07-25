package ru.rrozhkov.easykin.db.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.impl.convert.AuthDBPersonConverter;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.crypt.Encrypter;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by rrozhkov on 3/9/2017.
 */
public class AuthHandler {
    private static String select = "select * from PERSON where username='#username#' and password='#password#'";
    public static IPerson auth(String username, String password) throws Exception {
        Collection<IPerson> persons = DBManager.instance().select(
                select.replace("#username#",username).replace("#password#", Encrypter.encrypt(password))
                , new AuthDBPersonConverter());
        if(persons.isEmpty() || persons.size()>1)
            return null;
        return CollectionUtil.get(persons,0);
    }
}
