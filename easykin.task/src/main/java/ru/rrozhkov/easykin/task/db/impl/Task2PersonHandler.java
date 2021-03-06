package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2PersonHandler extends EntityHandler {
    final private static TaskConverterFactory taskConverterFactory = TaskConverterFactory.instance();

    private static class Holder {
        private static final Task2PersonHandler INSTANCE = new Task2PersonHandler();
    }

    static Task2PersonHandler instance(){
        return Holder.INSTANCE;
    }

    private Task2PersonHandler() {
    }

    @Override
    protected String getTableName() {
        return "TASK2PERSON";
    }

    @Override
    protected IEntityConverter getConverter() {
        return taskConverterFactory.task2person();
    }

    @Override
    protected String getInsert() {
        return "INSERT INTO "+getTableName()
                +"(ID, PERSON, TASK)"
                +" VALUES(#id#,#person#,#task#)";
    }
}
