package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.model.task.ITask;

/**
 * Created by rrozhkov on 04.06.2018.
 */
public class TaskBeanFactory {
    public TaskBean taskBean(int num, ITask task, String taskClass, String dateClass, String comments, String doneHtml) {
        return new TaskBean(num,task,taskClass,dateClass,comments,doneHtml);
    }
}
