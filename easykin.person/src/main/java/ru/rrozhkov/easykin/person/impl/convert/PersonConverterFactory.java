package ru.rrozhkov.easykin.person.impl.convert;

import ru.rrozhkov.lib.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class PersonConverterFactory {
    public IEntityConverter person(){return new PersonConverter();}
}
