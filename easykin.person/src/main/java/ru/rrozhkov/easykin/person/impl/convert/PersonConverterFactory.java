package ru.rrozhkov.easykin.person.impl.convert;

import ru.rrozhkov.lib.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class PersonConverterFactory {
    public static class PersonConverterFactoryHolder {
        public static final PersonConverterFactory INSTANCE = new PersonConverterFactory();
    }

    public static PersonConverterFactory instance(){
        return PersonConverterFactoryHolder.INSTANCE;
    }

    public IEntityConverter person(){return new PersonConverter();}
}
