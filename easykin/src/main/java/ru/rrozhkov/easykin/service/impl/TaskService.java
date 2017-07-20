package ru.rrozhkov.easykin.service.impl;

import ru.rrozhkov.easykin.db.impl.Task2PersonHandler;
import ru.rrozhkov.easykin.db.impl.TaskHandler;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;

import java.sql.SQLException;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class TaskService {
    public static int create(int personId, ITask task) throws SQLException {
        int taskId = TaskHandler.insert(task);
        Task2PersonHandler.insert(TaskFactory.createT2P(-1, personId, taskId));
        return taskId;
    }
}
