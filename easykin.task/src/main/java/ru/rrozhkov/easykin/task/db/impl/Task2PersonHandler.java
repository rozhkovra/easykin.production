package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.impl.EntityHandler;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2PersonHandler extends EntityHandler {
    final private static TaskConverterFactory taskConverterFactory = new TaskConverterFactory();

    @Override
    protected String getTableName() {
        return "TASK2PERSON";
    }

    @Override
    protected IEntityConverter getConverter() {
        return taskConverterFactory.task2person();
    }

    @Override
    protected String getSelect() {
        return "SELECT * FROM "+getTableName();
    }

    @Override
    protected String getInsert() {
        return "INSERT INTO "+getTableName()
                +"(ID, PERSON, TASK)"
                +" VALUES(#id#,#person#,#task#)";
    }

    @Override
    protected String getUpdate() {
        return null;
    }
}
