package ru.rrozhkov.easykin.task.impl.period;

import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.task.service.impl.TaskService;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rrozhkov on 14.06.2018.
 */
public class PeriodTaskBuilder {
    private static final TaskFactory taskFactory = TaskFactory.instance();
    private static final TaskService taskService = TaskService.instance();

    private Period period;
    private Date untilDate;
    private ITask source;

    public PeriodTaskBuilder(Period period, Date untilDate, ITask source) {
        this.period = period;
        this.untilDate = untilDate;
        this.source = source;
    }

    public int create() {
        Date start = source.getPlanDate();
        Date end = untilDate;
        Date shiftDate = start;
        int taskCounter = 0;
        while (shiftDate.getTime() < end.getTime()) {
            ITask shift = taskFactory.createTask(-1, source.getName(), source.getCreateDate(),
                    shiftDate, Priority.priority(source.getPriority()), source.getCategory().getId(),
                    source.getCategory().getName(), source.getCloseDate(), Status.status(source.getStatus()));
            taskService.createOrUpdate(shift);
            shiftDate = shiftDate(shiftDate, period);
            taskCounter++;
        }
        return taskCounter;
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
