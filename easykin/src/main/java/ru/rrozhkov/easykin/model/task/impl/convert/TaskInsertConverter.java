package ru.rrozhkov.easykin.model.task.impl.convert;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.lib.convert.IConverter;

/**
 * Created by rrozhkov on 6/19/2017.
 */

public class TaskInsertConverter implements IConverter<ITask, String> {
    public String convert(ITask task) {
        return "INSERT INTO task(id, name, priority, category, status) VALUES("+task.getId()
                +", '"+task.getName()+"'"
                +", "+ Priority.priority(task.getPriority())
                +", "+ task.getCategory().getId()
                +", "+ Status.status(task.getStatus())+")";
    }
}
