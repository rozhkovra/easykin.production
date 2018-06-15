package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.model.task.util.TaskUtil;
import ru.rrozhkov.easykin.payment.db.impl.PaymentHandler;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.db.impl.Task2PaymentHandler;
import ru.rrozhkov.easykin.task.db.impl.Task2PersonHandler;
import ru.rrozhkov.easykin.task.db.impl.TaskHandler;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverter;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.task.impl.period.Period;
import ru.rrozhkov.easykin.task.impl.period.PeriodTaskBuilder;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class TaskService {
    private static final TaskConverterFactory taskConverterFactory = TaskConverterFactory.instance();
    private static final Task2PaymentHandler t2paymentHandler = Task2PaymentHandler.instance();
    private static final Task2PersonHandler t2personHandler = Task2PersonHandler.instance();
    private static final PaymentHandler paymentHandler = PaymentHandler.instance();
    private static final TaskHandler taskHandler = TaskHandler.instance();
    private static final TaskFactory taskFactory = TaskFactory.instance();
    private static final AuthManager authManager = AuthManager.instance();
    private static final PeriodTaskBuilder periodTaskBuilder = PeriodTaskBuilder.instance();

    public static class TaskServiceHolder {
        public static final TaskService INSTANCE = new TaskService();
    }

    public static TaskService instance(){
        return TaskServiceHolder.INSTANCE;
    }

    private TaskService() {
    }

    public int createOrUpdate(ITask task){
        int taskId = task.getId();
        try{
            if (taskId == -1) {
                taskId = create(task);
            } else {
                taskHandler.update(task);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return taskId;
    }


    public void close(ITask task) {
        if (task.getId()==-1) {
            return;
        }
        try {
            taskHandler.close(task);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createPeriod(Period period, Date untilDate, ITask source) {
        periodTaskBuilder.create(period, untilDate, source);
    }

    protected int create(ITask task) throws SQLException {
        int personId = authManager.signedPerson().getId();
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
