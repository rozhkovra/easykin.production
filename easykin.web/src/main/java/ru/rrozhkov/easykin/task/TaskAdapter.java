package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.impl.TaskBuilder;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.easykin.task.service.impl.TaskService;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 11.05.2018.
 */
public class TaskAdapter {
    final private static TaskFilterFactory taskFilterFactory = TaskFilterFactory.instance();
    final private static AuthManager authManager = AuthManager.instance();
    final private static TaskService taskService = TaskService.instance();
    final private static TaskFactory taskFactory = TaskFactory.instance();
    final private static TaskBuilder taskBuilder = TaskBuilder.instance();
    final private static TaskBeanFactory taskBeanFactory = TaskBeanFactory.instance();

    public Collection<TaskBean> toDoTasks() {
        IPerson person = authManager.signedPerson();
        Date fromDate = DateUtil.firstDayOfMonth();
        Date toDate = DateUtil.lastDayOfMonth();
        int priorityId = -1;
        int categoryId = -1;
        int statusId = Status.status(Status.OPEN);
        TaskFilterBean filter = taskFilterFactory.bean(statusId, categoryId, priorityId, fromDate, toDate, person.getId());
        return tasks(filter);
    }

    private Collection<TaskBean> tasks(TaskFilterBean bean) {
        Collection<ITask> tasks = taskBuilder.build(bean);
        Collection<TaskBean> taskBeans = CollectionUtil.create();
        int num = 0;
        for (ITask task : tasks) {
            String taskClass = "";
            String dateClass = "";
            String comments = "";
            String doneHtml = "";
            if(Status.CLOSE.equals(task.getStatus())){
                if(task.getCloseDate().getTime()>task.getPlanDate().getTime())
                    taskClass = "label bg-gray";
                else
                    taskClass = "label bg-green";
            }else{
                taskClass  = "";
                if(Priority.IMPOTANT_FAST.equals(task.getPriority())){
                    taskClass  = "label bg-yellow";
                }
                if(Priority.IMPOTANT_NOFAST.equals(task.getPriority())){
                    taskClass  = "label bg-blue";
                }
                if (new Date().getTime()>task.getPlanDate().getTime()) {
                    dateClass = "label bg-gray";
                }
                doneHtml = "<button id=\"done"+task.getId()+"\" type=\"button\" class=\"btn btn-block btn-sm btn-success\">Выполнить</button>";
            }
            for (IComment comment : task.comments()) {
                comments += comment.getText()+" | ";
            }
            taskBeans.add(taskBeanFactory.taskBean(++num,task,taskClass,dateClass,comments,doneHtml));
        }
        return taskBeans;
    }

    public Collection<TaskBean> tasks(javax.servlet.http.HttpServletRequest request) {
        TaskFilterBean bean = filter(request);
        Collection<ITask> tasks = taskBuilder.build(bean);
        return tasks(bean);
    }

    public TaskFilterBean filter(javax.servlet.http.HttpServletRequest request) {
        IPerson person = authManager.signedPerson();
        int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
        int statusId = request.getParameter("statusId")!=null?Integer.valueOf(request.getParameter("statusId")):-1;
        int priorityId = request.getParameter("priorityId")!=null?Integer.valueOf(request.getParameter("priorityId")):-1;
        Date fromDate = request.getParameter("fromDate")!=null?DateUtil.parse(request.getParameter("fromDate")):DateUtil.parse("01.01.2000");
        Date toDate = request.getParameter("toDate")!=null?DateUtil.parse(request.getParameter("toDate")): DateUtil.parse("01.01.3000");
        return taskFilterFactory.bean(statusId, categoryId, priorityId, fromDate, toDate, person.getId());
    }

    public void done(javax.servlet.http.HttpServletRequest request) {
        int taskId = request.getParameter("taskId")!=null?Integer.valueOf(request.getParameter("taskId")):-1;
        ITask task = taskFactory.createTask(taskId, "", DateUtil.today(), DateUtil.today(), Priority.priority(Priority.SIMPLE)
                    , 1, "", null, Status.status(Status.OPEN));
        taskService.close(task);
    }
}
