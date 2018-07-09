package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.task.ITask2Payment;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2PaymentHandler extends EntityHandler {
    final private static TaskConverterFactory converterFactory = TaskConverterFactory.instance();

    public static class Task2PaymentHandlerHolder {
        public static final Task2PaymentHandler INSTANCE = new Task2PaymentHandler();
    }

    public String selectForTask = "SELECT * FROM "+getTableName()
            +" WHERE TASK=#taskId#";


    private Task2PaymentHandler() {
    }

    public static Task2PaymentHandler instance(){
        return Task2PaymentHandlerHolder.INSTANCE;
    }

    @Override
    protected String getTableName() {
        return "TASK2PAYMENT";
    }

    @Override
    protected IEntityConverter getConverter() {
        return converterFactory.task2payment();
    }

    @Override
    protected String getInsert() {
        return "INSERT INTO "+getTableName()
                +"(ID, PAYMENT, TASK)"
                +" VALUES(#id#,#payment#,#task#)";
    }

    public ITask2Payment selectForTask(int taskId) throws SQLException {
        Collection<ITask2Payment> t2ps = dbManager().select(selectForTask.replace("#taskId#", String.valueOf(taskId)), getConverter());
        if(t2ps!=null && !t2ps.isEmpty())
            return CollectionUtil.get(t2ps, 0);
        return null;
    }
}
