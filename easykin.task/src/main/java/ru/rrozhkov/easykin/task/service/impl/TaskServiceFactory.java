package ru.rrozhkov.easykin.task.service.impl;

/**
 * Created by rrozhkov on 11.12.2018.
 */
public class TaskServiceFactory {
    private static class Holder {
        private static final TaskServiceFactory INSTANCE = new TaskServiceFactory();
    }

    public static TaskServiceFactory instance(){
        return Holder.INSTANCE;
    }

    private TaskServiceFactory() {
    }

    public CategoryService category() {return CategoryService.instance();}
    public CommentService comment() {return CommentService.instance();}
    public TaskService task() {return TaskService.instance();}
}
