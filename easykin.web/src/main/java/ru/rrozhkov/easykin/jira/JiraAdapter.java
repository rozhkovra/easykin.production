package ru.rrozhkov.easykin.jira;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.jira.impl.TaskBuilder;
import ru.rrozhkov.easykin.jira.impl.WorkLogBuilder;
import ru.rrozhkov.easykin.model.jira.JiraTask;
import ru.rrozhkov.easykin.model.jira.JiraWorkLog;

import java.util.*;

/**
 * Created by rrozhkov on 20.09.2018.
 */
public class JiraAdapter {
    private static final TaskBuilder taskBuilder = TaskBuilder.instance();
    private static final WorkLogBuilder workLogBuilder = WorkLogBuilder.instance();

    public Collection<JiraWorkLogBean> worklogs() {
        Collection<JiraWorkLog> worklogs = workLogBuilder.worklogs();
        Collections.sort((List) worklogs, new Comparator<JiraWorkLog>() {
            public int compare(JiraWorkLog o1, JiraWorkLog o2) {
                return DateUtil.formatSql(o2.getDate()).compareTo(DateUtil.formatSql(o1.getDate()));
            }
        });

        Map<Date, Integer> dayTime = new HashMap<Date, Integer>();
        for(JiraWorkLog worklog : worklogs){
            int curTime = worklog.getTime();
            if (dayTime.containsKey(worklog.getDate())) {
                curTime += dayTime.get(worklog.getDate());
            }
            dayTime.put(worklog.getDate(), curTime);
        }

        Collection<JiraWorkLogBean> worklogBeans = CollectionUtil.create();
        int i = 0;
        for (JiraWorkLog worklog : worklogs) {
            if (Integer.valueOf(8).equals(dayTime.get(worklog.getDate()))) {
                worklogBeans.add(new JiraWorkLogBean(++i, worklog, "label bg-green"));
            } else {
                worklogBeans.add(new JiraWorkLogBean(++i, worklog,"label bg-yellow"));
            }
        }
        return worklogBeans;
    }

    public Collection<JiraTaskBean> tasks() {
        Collection<JiraTaskBean> taskBeans = CollectionUtil.create();
        int i = 0;
        for (JiraTask task : taskBuilder.tasks()) {
            taskBeans.add(new JiraTaskBean(++i, task));
        }
        return taskBeans;
    }
}
