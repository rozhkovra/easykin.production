package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class ReadingConverter implements IEntityConverter<IReading> {
    private static final ServiceFactory serviceFactory = new ServiceFactory();

    protected ReadingConverter() {}

    public String sqlInsert(IReading entity) {
        return null;
    }

    public Map<String, Object> map(IReading entity) {
        return new IConverter<IReading, Map<String, Object>>() {
            public Map<String, Object> convert(IReading reading) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", reading.getId());
                map.put("reddate", DateUtil.formatSql(reading.getDate()));
                return map;
            }
        }.convert(entity);
    }

    public String[] stringArr(Collection<IReading> entries) {
        return new String[0];
    }

    public IReading entity(ResultSet resultSet) {
        return new IConverter<ResultSet, IReading>() {
            public IReading convert(ResultSet result){
                try{
                    return serviceFactory.createReading(result.getInt("id"), result.getDate("reddate"));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}
