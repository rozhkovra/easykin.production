package ru.rrozhkov.easykin.model.task.impl.convert;

import ru.rrozhkov.easykin.model.task.ITask2Person;
import ru.rrozhkov.lib.convert.IConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class T2PMapConverter implements IConverter<ITask2Person, Map<String, Object>> {

    public Map<String, Object> convert(ITask2Person t2p) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", t2p.getId());
        map.put("person", t2p.getPersonId());
        map.put("task", t2p.getTaskId());
        return map;
    }
}
