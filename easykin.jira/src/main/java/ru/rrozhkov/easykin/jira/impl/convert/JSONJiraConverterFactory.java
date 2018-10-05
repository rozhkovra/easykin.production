package ru.rrozhkov.easykin.jira.impl.convert;

import ru.rrozhkov.easykin.core.convert.IConverter;

/**
 * Created by rrozhkov on 05.10.2018.
 */
public class JSONJiraConverterFactory {
    public static class Holder {
        public static final JSONJiraConverterFactory INSTANCE = new JSONJiraConverterFactory();
    }

    public static JSONJiraConverterFactory instance(){
        return Holder.INSTANCE;
    }

    public IConverter task(){return new JSONJiraTaskConverter();}
    public IConverter worklog(){return new JSONJiraWorkLogConverter();}
}
