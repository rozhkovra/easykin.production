package ru.rrozhkov.easykin.ws.convert;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.ws.bean.TaskBean;
import ru.rrozhkov.lib.convert.IConverter;

/**
 * Created by rrozhkov on 2/28/2017.
 */
public class TaskWSConverter implements IConverter<TaskBean, ITask> {

    public ITask convert(TaskBean bean) {
        return TaskFactory.createTask(bean.getId(),bean.getName(),bean.getCreateDate(),bean.getPlanDate(),bean.getPriority(),bean.getCategory(),bean.getCategoryName(),null,bean.getStatus());
    }
}
