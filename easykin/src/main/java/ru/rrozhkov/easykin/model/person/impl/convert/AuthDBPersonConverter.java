package ru.rrozhkov.easykin.model.person.impl.convert;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.easykin.model.person.impl.PersonFactory;
import ru.rrozhkov.lib.convert.IConverter;

import java.sql.ResultSet;

/**
 * Created by rrozhkov on 6/1/2017.
 */
public class AuthDBPersonConverter implements IConverter<ResultSet, IPerson> {
    public IPerson convert(ResultSet entry) {
        try{
            return PersonFactory.create(entry.getInt("id"), entry.getString("surname"), entry.getString("name")
                    , entry.getString("secondName"), entry.getDate("birthdate"), Sex.sex(entry.getString("sex"))
                    , entry.getString("username"), entry.getString("password"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
