package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class MeasureConverter implements IEntityConverter<IMeasure> {
    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public String sqlInsert(IMeasure entity) {
        return null;
    }

    public Map<String, Object> map(IMeasure entity) {
        return new IConverter<IMeasure, Map<String, Object>>() {
            public Map<String, Object> convert(IMeasure measure) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", measure.getId());
                map.put("readingid", measure.getReadingId());
                map.put("measuretype", measure.getType().toString());
                map.put("measurevalue", measure.getValue().toString().replace(".0", ""));
                return map;
            }
        }.convert(entity);
    }

    public String[] stringArr(Collection<IMeasure> entries) {
        return new String[0];
    }

    public IMeasure entity(ResultSet resultSet) {
        return new IConverter<ResultSet, IMeasure>() {
            public IMeasure convert(ResultSet result){
                try{
                    return serviceFactory.createMeasure(result.getInt("id"), result.getInt("readingid"), MeasureType.type(result.getString("measuretype")), Integer.valueOf(result.getString("MEASUREVALUE")));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}
