package ru.rrozhkov.easykin.task.impl.convert;

import ru.rrozhkov.easykin.model.task.ITask2Payment;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.convert.IEntityConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class Task2PaymentConverter implements IEntityConverter<ITask2Payment> {
    public String sqlInsert(ITask2Payment entity) {
        return null;
    }

    public Map<String, Object> map(ITask2Payment entity) {
        return new IConverter<ITask2Payment, Map<String, Object>>() {
            public Map<String, Object> convert(ITask2Payment t2p) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", t2p.getId());
                map.put("payment", t2p.getPaymentId());
                map.put("task", t2p.getTaskId());
                return map;
            }
        }.convert(entity);
    }

    public String[] stringArr(Collection<ITask2Payment> entries) {
        return new String[0];
    }

    public ITask2Payment entity(ResultSet resultSet) {
        return new IConverter<ResultSet, ITask2Payment>() {
            public ITask2Payment convert(ResultSet result){
                try{
                    return TaskFactory.createTask2Payment(result.getInt("id"), result.getInt("payment"), result.getInt("task"));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}
