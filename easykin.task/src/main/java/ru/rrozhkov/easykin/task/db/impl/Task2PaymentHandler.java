package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2PaymentHandler extends EntityHandler {
    final private static TaskConverterFactory converterFactory = TaskConverterFactory.instance();

    public static class Task2PaymentHandlerHolder {
        public static final Task2PaymentHandler INSTANCE = new Task2PaymentHandler();
    }

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
}
