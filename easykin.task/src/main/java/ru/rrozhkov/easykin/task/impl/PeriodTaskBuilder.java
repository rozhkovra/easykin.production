package ru.rrozhkov.easykin.task.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 14.06.2018.
 */
public class PeriodTaskBuilder {
    private static final TaskFactory taskFactory = TaskFactory.instance();

    private static class Holder {
        private static final PeriodTaskBuilder INSTANCE = new PeriodTaskBuilder();
    }

    static PeriodTaskBuilder instance(){
        return Holder.INSTANCE;
    }

    private PeriodTaskBuilder() {
    }

    public Collection<ITask> build(Period period, Date untilDate, ITask source) {
        Collection<ITask> task = CollectionUtil.create();
        Date start = source.getPlanDate();
        Date end = untilDate;
        Date shiftDate = start;
        while (shiftDate.getTime() < end.getTime()) {
            task.add(taskFactory.createTask(-1, source.getName(), source.getCreateDate(),
                    shiftDate, Priority.priority(source.getPriority()), source.getCategory().getId(),
                    source.getCategory().getName(), source.getCloseDate(), Status.status(source.getStatus())));
            shiftDate = shiftDate(shiftDate, period);
        }
        return task;
    }

    private Date shiftDate(Date shiftDate, Period period) {
        Date newDate = shiftDate;
        Calendar cal = Calendar.getInstance();
        cal.setTime(newDate);
        switch (period) {
            case DAY:   cal.add(Calendar.DATE, 1);
                        break;
            case WEEK:  cal.add(Calendar.DATE, 7);
                        break;
            case MONTH: cal.add(Calendar.MONTH, 1);
                        break;
            case YEAR:  cal.add(Calendar.YEAR, 1);
                        break;
        }
        return cal.getTime();
    }
}
