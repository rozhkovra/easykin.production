package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.ITask2Payment;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.model.task.util.TaskUtil;
import ru.rrozhkov.easykin.payment.db.impl.PaymentHandler;
import ru.rrozhkov.easykin.task.db.impl.CommentHandler;
import ru.rrozhkov.easykin.task.db.impl.Task2PaymentHandler;
import ru.rrozhkov.easykin.task.db.impl.TaskHandler;
import ru.rrozhkov.easykin.task.db.impl.TaskHandlerFactory;
import ru.rrozhkov.easykin.task.impl.TaskBuilder;
import ru.rrozhkov.easykin.task.impl.TaskBuilderFactory;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverter;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class TaskService {
    private static final TaskConverterFactory taskConverterFactory = TaskConverterFactory.instance();
    private static final Task2PaymentHandler t2paymentHandler = TaskHandlerFactory.instance().task2Payment();
    private static final EntityHandler t2personHandler = TaskHandlerFactory.instance().task2Person();
    private static final PaymentHandler paymentHandler = PaymentHandler.instance();
    private static final TaskHandler taskHandler = TaskHandlerFactory.instance().task();
    private static final TaskFactory taskFactory = TaskFactory.instance();
    private static final PaymentFactory paymentFactory = PaymentFactory.instance();
    private static final TaskBuilder taskBuilder = TaskBuilderFactory.instance().task();
    final private static CommentHandler commentHandler = TaskHandlerFactory.instance().comment();

    private static class Holder {
        private static final TaskService INSTANCE = new TaskService();
    }

    static TaskService instance(){
        return Holder.INSTANCE;
    }

    private TaskService() {
    }

    public int createOrUpdate(final ITask task, final IPerson person){
        int taskId = task.getId();
        try{
            if (taskId == -1) {
                taskId = create(task, person);
            } else {
                update(task);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return taskId;
    }


    public void close(final ITask task) {
        if (task.getId()==-1) {
            return;
        }
        try {
            taskHandler.close(task);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createOrUpdate(final Collection<ITask> tasks ,final IPerson person) {
        for (ITask task : tasks) {
            createOrUpdate(task, person);
        }
    }

    protected int create(final ITask task, final IPerson person) throws SQLException {
        int taskId = taskHandler.insert(task);
        t2personHandler.insert(taskFactory.createTask2Person(-1, person.getId(), taskId));
        if(TaskUtil.withPayment(task)) {
            IPayment payment = ((TaskConverter)taskConverterFactory.task()).payment(task);
            int paymentId = paymentHandler.insert(payment);
            t2paymentHandler.insert(taskFactory.createTask2Payment(-1, paymentId, taskId));
        }
        return taskId;
    }

    protected int update(final ITask task) throws SQLException {
        int taskId = task.getId();
        taskHandler.update(task);
        if(TaskUtil.withPayment(task)) {
            ITask2Payment t2p = t2paymentHandler.selectForTask(taskId);
            int paymentId = t2p.getPaymentId();
            IPayment payment = ((TaskConverter)taskConverterFactory.task()).payment(task);
            payment = paymentFactory.createPayment(paymentId, payment.getCategory(), payment.getComment(),
                        payment.getAmount(), payment.getDate(), payment.getStatus());
            paymentHandler.update(payment);
        }
        return taskId;
    }

    public Collection tasks(final IPerson person){
        try {
            return taskBuilder.build(taskHandler.selectForPerson(person.getId()), commentHandler.selectForPerson(person.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CollectionUtil.create();
    }

    public ITask task(final int id){
        try {
            return taskBuilder.buildTask(taskHandler.selectTask(id), commentHandler.selectForTask(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Collection<ITask> tasks(final TaskFilterBean bean){
        try {
            return taskBuilder.build(taskHandler.selectForFilter(bean), commentHandler.selectForPerson(bean.getPersonId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CollectionUtil.create();
    }

}
