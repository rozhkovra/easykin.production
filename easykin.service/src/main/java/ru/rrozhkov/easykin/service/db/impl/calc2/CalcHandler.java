package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.service.calc2.impl.convert.ServiceConverterFactory;

import java.util.Collection;

/**
 * Created by rrozhkov on 11.07.2018.
 */
public class CalcHandler extends EntityHandler {
    private static final ServiceConverterFactory converterFactory = ServiceConverterFactory.instance();
    private String selectForReading = "SELECT * FROM "+getTableName()+" WHERE READINGID=#readingid#";

    public static class Holder {
        public static final CalcHandler INSTANCE = new CalcHandler();
    }

    public static CalcHandler instance(){
        return Holder.INSTANCE;
    }

    private CalcHandler() {
    }

    @Override
    protected String getTableName() {
        return "SERVICE_CALC";
    }

    @Override
    protected IEntityConverter getConverter() {
        return converterFactory.calc();
    }

    public Collection<ICalculation> selectForReading(int id) throws Exception {
        return dbManager().select(selectForReading.replace("#readingid#", String.valueOf(id)), getConverter());
    }

    protected String getUpdate() {
        return "UPDATE " + getTableName() + " SET PAID=#paid#, AMOUNT=#amount# "
                + " WHERE ID=#id#";
    }

    protected String getInsert() {
        return "INSERT INTO " + getTableName()
                + "(ID, PAID, READINGID, CALCTYPE, AMOUNT)"
                + " VALUES(#id#, #paid#, #readingid#, '#calctype#', #amount#)";
    }
}