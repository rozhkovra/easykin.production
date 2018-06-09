package ru.rrozhkov.easykin.task.impl.convert;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class TaskConverterFactory {
    public static class TaskConverterFactoryHolder {
        public static final TaskConverterFactory INSTANCE = new TaskConverterFactory();
    }

    public static TaskConverterFactory instance(){
        return TaskConverterFactoryHolder.INSTANCE;
    }

    public IEntityConverter task() {return new TaskConverter();}
    public IEntityConverter category() {return new CategoryConverter();}
    public IEntityConverter comment() {return new CommentConverter();}
    public IEntityConverter task2person() {return new Task2PersonConverter();}
    public IEntityConverter task2payment() {return new Task2PaymentConverter();}
}
