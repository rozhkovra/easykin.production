package ru.rrozhkov.easykin.task.impl.convert;

import ru.rrozhkov.lib.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class TaskConverterFactory {
    public static IEntityConverter task() {return new TaskConverter();}
    public static IEntityConverter category() {return new CategoryConverter();}
    public static IEntityConverter comment() {return new CommentConverter();}
    public static IEntityConverter task2person() {return new Task2PersonConverter();}
    public static IEntityConverter task2payment() {return new Task2PaymentConverter();}
}
