package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.service.calc2.impl.convert.ServiceConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;
import ru.rrozhkov.lib.db.impl.EntityHandler;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class MeasureHandler extends EntityHandler {
    private static final ServiceConverterFactory converterFactory = new ServiceConverterFactory();

    public String selectForReading = "SELECT * FROM "+getTableName()+" WHERE READINGID=#readingid#";

    @Override
    protected String getTableName() {
        return "SERVICE_MEASURE";
    }

    @Override
    protected IEntityConverter getConverter() {
        return converterFactory.measure();
    }

    @Override
    protected String getSelect() {
        return "SELECT * FROM "+getTableName();
    }

    @Override
    protected String getInsert() {
        return "INSERT INTO "+getTableName()
                +"(ID, READINGID, MEASURETYPE, MEASUREVALUE)"
                +" VALUES(#id#, #readingid#, '#measuretype#','#measurevalue#')";
    }

    @Override
    protected String getUpdate() {
        return null;
    }

    public Collection<IMeasure> selectForReading(int id) throws Exception {
        return dbManager().select(selectForReading.replace("#readingid#", String.valueOf(id)), getConverter());
    }
}
