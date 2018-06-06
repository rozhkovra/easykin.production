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
    final private static TaskConverterFactory taskConverterFactory = new TaskConverterFactory();
    final private static Task2PaymentHandler t2paymentHandler = new Task2PaymentHandler();
    final private static Task2PersonHandler t2personHandler = new Task2PersonHandler();
    final private static TaskHandler taskHandler = new TaskHandler();
    final private static PaymentHandler paymentHandler = new PaymentHandler();
    final private static TaskFactory taskFactory = new TaskFactory();

    public static int create(int personId, ITask task) throws SQLException {
        int taskId = taskHandler.insert(task);
        t2personHandler.insert(taskFactory.createTask2Person(-1, personId, taskId));
        if(TaskUtil.withPayment(task)) {
            IPayment payment = ((TaskConverter)taskConverterFactory.task()).payment(task);
            int paymentId = paymentHandler.insert(payment);
            t2paymentHandler.insert(taskFactory.createTask2Payment(-1, paymentId, taskId));
        }
        return taskId;
    }
}
