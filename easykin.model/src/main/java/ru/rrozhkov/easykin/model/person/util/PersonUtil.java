package ru.rrozhkov.easykin.model.person.util;

import ru.rrozhkov.easykin.model.person.IPerson;

/**
 * Created by rrozhkov on 1/16/2018.
 */
public class PersonUtil {
    public static String fi(IPerson person) {
        return person!=null?new StringBuilder().append(person.getSurname()).append(" ").append(person.getName()).toString():"";
    }
    public static String fio(IPerson person) {
        return person!=null?new StringBuilder().append(person.getSurname()).append(" ").append(person.getName())
                .append(" ").append(person.getSecondName()).toString():"";
    }
}
