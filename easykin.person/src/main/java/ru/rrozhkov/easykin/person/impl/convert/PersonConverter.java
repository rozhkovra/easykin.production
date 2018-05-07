package ru.rrozhkov.easykin.person.impl.convert;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.convert.IEntityConverter;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class PersonConverter implements IEntityConverter<IPerson> {
    public String sqlInsert(IPerson entity) {
        return new IConverter<IPerson, String>() {
            public String convert(IPerson iPerson) {
                return "INSERT INTO person (id, surname, name, secondname, sex, username, password)"
                        +" VALUES("+iPerson.getId()
                        +", '"+iPerson.getSurname()+"'"
                        +", '"+iPerson.getName()+"'"
                        +", '"+iPerson.getSecondName()+"'"
                        +", '"+iPerson.getSex()+"'"
                        +", '"+iPerson.getUsername()+"'"
                        +", '"+iPerson.getPassword()+"')";
            }
        }.convert(entity);
    }

    public Map<String, Object> map(IPerson entity) {
        return null;
    }

    public String[] stringArr(Collection<IPerson> entries) {
        return new String[0];
    }

    public IPerson entity(ResultSet resultSet) {
        return new AuthDBPersonConverter().convert(resultSet);
    }
}
