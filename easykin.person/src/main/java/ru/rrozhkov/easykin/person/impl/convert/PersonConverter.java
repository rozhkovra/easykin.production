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
    private static final IConverter<ResultSet, IPerson> converter = new AuthDBPersonConverter();

    public String sqlInsert(IPerson entity) {
        return new IConverter<IPerson, String>() {
            public String convert(IPerson iPerson) {
                return new StringBuilder("INSERT INTO person (id, surname, name, secondname, sex, username, password)")
                        .append(" VALUES(")
                        .append(iPerson.getId()).append(",'")
                        .append(iPerson.getSurname()).append("','")
                        .append(iPerson.getName()).append("','")
                        .append(iPerson.getSecondName()).append("','")
                        .append(iPerson.getSex()).append("','")
                        .append(iPerson.getUsername()).append("','")
                        .append(iPerson.getPassword())
                        .append("')").toString();
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
        return converter.convert(resultSet);
    }
}
