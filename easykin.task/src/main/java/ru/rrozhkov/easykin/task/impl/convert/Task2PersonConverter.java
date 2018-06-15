package ru.rrozhkov.easykin.task.impl.convert;

import ru.rrozhkov.easykin.model.task.ITask2Person;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
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
public class Task2PersonConverter implements IEntityConverter<ITask2Person> {
    final static private TaskFactory taskFactory = TaskFactory.instance();

    protected Task2PersonConverter() {
    }

    public String sqlInsert(ITask2Person entity) {
        return null;
    }

    public Map<String, Object> map(ITask2Person entity) {
        return new IConverter<ITask2Person, Map<String, Object>>() {
            public Map<String, Object> convert(ITask2Person t2p) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", t2p.getId());
                map.put("person", t2p.getPersonId());
                map.put("task", t2p.getTaskId());
                return map;
            }
        }.convert(entity);
    }

    public String[] stringArr(Collection<ITask2Person> entries) {
        return new IConverter<Collection<ITask2Person>, String[]>() {
            public String[] convert(Collection<ITask2Person> entries) {
                Collection<String> items = CollectionUtil.create();
                for(ITask2Person t2p : entries)
                    items.add(String.valueOf(t2p.getId()));
                return items.toArray(new String[items.size()]);
            }
        }.convert(entries);
    }

    public ITask2Person entity(ResultSet resultSet) {
        return new IConverter<ResultSet, ITask2Person>() {
            public ITask2Person convert(ResultSet result){
                try{
                    return taskFactory.createTask2Person(result.getInt("id"), result.getInt("person"), result.getInt("task"));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}
