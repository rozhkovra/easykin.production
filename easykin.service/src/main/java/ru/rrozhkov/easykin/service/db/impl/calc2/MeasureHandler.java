package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.service.calc2.impl.convert.ServiceConverterFactory;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;

import java.util.Collection;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class MeasureHandler extends EntityHandler {
    private static final ServiceConverterFactory converterFactory = ServiceConverterFactory.instance();

    private String selectForReading = "SELECT * FROM "+getTableName()+" WHERE READINGID=#readingid#";

    private static class Holder {
        private static final MeasureHandler INSTANCE = new MeasureHandler();
    }

    static MeasureHandler instance(){
        return Holder.INSTANCE;
    }

    private MeasureHandler() {
    }

    @Override
    protected String getTableName() {
        return "SERVICE_MEASURE";
    }

    @Override
    protected IEntityConverter getConverter() {
        return converterFactory.measure();
    }

    @Override
    protected String getInsert() {
        return "INSERT INTO "+getTableName()
                +"(ID, READINGID, MEASURETYPE, MEASUREVALUE)"
                +" VALUES(#id#, #readingid#, '#measuretype#','#measurevalue#')";
    }

    public Collection<IMeasure> selectForReading(int id) throws Exception {
        return dbManager().select(selectForReading.replace("#readingid#", String.valueOf(id)), getConverter());
    }
}
