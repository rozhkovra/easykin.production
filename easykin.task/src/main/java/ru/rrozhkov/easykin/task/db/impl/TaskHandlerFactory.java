package ru.rrozhkov.easykin.task.db.impl;

/**
 * Created by rrozhkov on 11.12.2018.
 */
public class TaskHandlerFactory {
    private static class Holder {
        private static final TaskHandlerFactory INSTANCE = new TaskHandlerFactory();
    }

    public static TaskHandlerFactory instance(){
        return Holder.INSTANCE;
    }

    private TaskHandlerFactory() {
    }

    public TaskHandler task(){return TaskHandler.instance();}
    public CategoryHandler category(){return CategoryHandler.instance();}
    public CommentHandler comment(){return CommentHandler.instance();}
    public Task2PaymentHandler task2Payment(){return Task2PaymentHandler.instance();}
    public Task2PersonHandler task2Person(){return Task2PersonHandler.instance();}
}
