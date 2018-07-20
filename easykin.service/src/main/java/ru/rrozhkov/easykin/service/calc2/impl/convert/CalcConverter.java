package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 11.07.2018.
 */
public class CalcConverter implements IEntityConverter<ICalculation> {
    private static final ServiceFactory serviceFactory = ServiceFactory.instance();

    protected CalcConverter() {
    }

    public String sqlInsert(ICalculation entity) {
        return null;
    }

    public Map<String, Object> map(ICalculation entity) {
        return new IConverter<ICalculation, Map<String, Object>>() {
            public Map<String, Object> convert(ICalculation calc) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", calc.getId());
                map.put("paid", calc.isPaid()?1:0);
                map.put("readingid", calc.getReadingId());
                map.put("calctype", calc.getType().toString());
                map.put("amount", calc.getAmount().getValue());
                return map;
            }
        }.convert(entity);
    }

    public String[] stringArr(Collection entries) {
        return new String[0];
    }

    public ICalculation entity(ResultSet resultSet) {
        return new IConverter<ResultSet, ICalculation>() {
            public ICalculation convert(ResultSet result){
                try{
                    return serviceFactory.createCalc(result.getInt("id"), result.getInt("readingid"),  CalculationType.type(result.getString("calctype"))
                            , result.getInt("paid")>0, Money.valueOf(result.getString("amount")));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}
