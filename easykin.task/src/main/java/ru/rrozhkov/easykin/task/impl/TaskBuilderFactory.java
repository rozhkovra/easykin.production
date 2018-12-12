package ru.rrozhkov.easykin.task.impl;

/**
 * Created by rrozhkov on 12.12.2018.
 */
public class TaskBuilderFactory {
    private static class Holder {
        private static final TaskBuilderFactory INSTANCE = new TaskBuilderFactory();
    }

    public static TaskBuilderFactory instance(){
        return Holder.INSTANCE;
    }

    private TaskBuilderFactory() {
    }

    public TaskBuilder task(){return TaskBuilder.instance();}
    public PeriodTaskBuilder periodTask(){return PeriodTaskBuilder.instance();}
}
