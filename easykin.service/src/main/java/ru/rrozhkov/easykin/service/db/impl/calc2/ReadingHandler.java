package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.service.calc2.impl.convert.ServiceConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.impl.EntityHandler;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class ReadingHandler extends EntityHandler {
    private static final ServiceConverterFactory converterFactory = new ServiceConverterFactory();

    @Override
    protected String getTableName() {
        return "SERVICE_READING";
    }

    @Override
    protected IEntityConverter getConverter() {
        return converterFactory.reading();
    }

    @Override
    protected String getSelect() {
        return "SELECT * FROM "+getTableName();
    }

    @Override
    protected String getInsert() {
        return "INSERT INTO "+getTableName()
                +"(ID, REDDATE)"
                +" VALUES(#id#,'#reddate#')";
    }

    @Override
    protected String getUpdate() {
        return null;
    }
}
