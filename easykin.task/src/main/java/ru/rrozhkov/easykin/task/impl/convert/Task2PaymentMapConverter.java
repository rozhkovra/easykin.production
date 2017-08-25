package ru.rrozhkov.easykin.task.impl.convert;

import ru.rrozhkov.easykin.model.task.ITask2Payment;
import ru.rrozhkov.lib.convert.IConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2PaymentMapConverter implements IConverter<ITask2Payment, Map<String, Object>> {

    public Map<String, Object> convert(ITask2Payment t2p) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", t2p.getId());
        map.put("payment", t2p.getPaymentId());
        map.put("task", t2p.getTaskId());
        return map;
    }
}
