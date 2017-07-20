package ru.rrozhkov.easykin.model.doc;

import ru.rrozhkov.easykin.model.doc.impl.Passport;
import ru.rrozhkov.easykin.model.doc.impl.SNILS;
import ru.rrozhkov.easykin.model.person.IPerson;

import java.io.File;
import java.util.Date;

/**
 * Created by rrozhkov on 3/13/2017.
 */
public class DocFactory {
    public static IDoc createPassport(IPerson person, String number,
                                      String series, String org, Date issueDate, File scan){
        return new Passport(person, number, series, org, issueDate, scan);
    }
    public static IDoc createSnils(IPerson person, String number, File scan){
        return new SNILS(person, number, scan);
    }
}
