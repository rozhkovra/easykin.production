package ru.rrozhkov.easykin.model.work;

/**
 * Created by rrozhkov on 1/15/2018.
 */
public enum TaskType {
    BUGFIX("Багфиксинг"),
    ESTIMATECR("Оцнека CR"),
    WRITEIC("Написание IC"),
    DEVELOPCR("Разработка CR"),
    PRESENTATION("Презентация"),
    DISPETCHER("Диспетчеризация"),
    HOTFIX("Hotfix"),
    TANDM("T&M"),
    LEADPM("Lead PM"),
    VACATION("Отпуск"),
    ANOTHER("Другое")
    ;

    private final String name;

    private TaskType (String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }

    public static TaskType type(String str){
        if(BUGFIX.toString().equals(str))
            return BUGFIX;
        else if(ESTIMATECR.toString().equals(str))
            return ESTIMATECR;
        else if(WRITEIC.toString().equals(str))
            return WRITEIC;
        else if(DEVELOPCR.toString().equals(str))
            return DEVELOPCR;
        else if(PRESENTATION.toString().equals(str))
            return PRESENTATION;
        else if(DISPETCHER.toString().equals(str))
            return DISPETCHER;
        else if(HOTFIX.toString().equals(str))
            return HOTFIX;
        else if(TANDM.toString().equals(str))
            return TANDM;
        else if(LEADPM.toString().equals(str))
            return LEADPM;
        else if(VACATION.toString().equals(str))
            return VACATION;
        return ANOTHER;
    }
}
