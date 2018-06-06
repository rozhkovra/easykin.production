package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.convert.IEntityConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class RateConverter implements IEntityConverter {
    private static final ServiceFactory serviceFactory = new ServiceFactory();

    protected RateConverter() {
    }

    public String sqlInsert(Object entity) {
        return null;
    }

    public Map<String, Object> map(Object entity) {
        return null;
    }

    public String[] stringArr(Collection entries) {
        return new String[0];
    }

    public Object entity(ResultSet resultSet) {
        return new IConverter<ResultSet, IRate>() {
            public IRate convert(ResultSet result){
                try{
                    return serviceFactory.createRate(result.getInt("id"), RateType.type(result.getString("rateType"))
                            , result.getString("rateValue"), result.getDate("dateFrom"), result.getDate("dateTo"));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}
