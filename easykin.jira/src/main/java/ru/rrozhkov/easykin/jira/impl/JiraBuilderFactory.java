package ru.rrozhkov.easykin.jira.impl;

/**
 * Created by rrozhkov on 12.12.2018.
 */
public class JiraBuilderFactory {
    private static class Holder {
        private static final JiraBuilderFactory INSTANCE = new JiraBuilderFactory();
    }

    public static JiraBuilderFactory instance(){
        return Holder.INSTANCE;
    }

    private JiraBuilderFactory() {
    }

    public TaskBuilder task() {return TaskBuilder.instance();}
    public WorkLogBuilder workLog() {return WorkLogBuilder.instance();}
}
