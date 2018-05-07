package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.model.task.util.TaskUtil;
import ru.rrozhkov.easykin.payment.db.impl.PaymentHandler;
import ru.rrozhkov.easykin.task.db.impl.Task2PaymentHandler;
import ru.rrozhkov.easykin.task.db.impl.Task2PersonHandler;
import ru.rrozhkov.easykin.task.db.impl.TaskHandler;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverter;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;

import java.sql.SQLException;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class TaskService {
    public static int create(int personId, ITask task) throws SQLException {
        int taskId = TaskHandler.insert(task);
        Task2PersonHandler.insert(TaskFactory.createTask2Person(-1, personId, taskId));
        if(TaskUtil.withPayment(task)) {
            IPayment payment = ((TaskConverter)TaskConverterFactory.task()).payment(task);
            int paymentId = PaymentHandler.insert(payment);
            Task2PaymentHandler.insert(TaskFactory.createTask2Payment(-1, paymentId, taskId));
        }
        return taskId;
    }
}
