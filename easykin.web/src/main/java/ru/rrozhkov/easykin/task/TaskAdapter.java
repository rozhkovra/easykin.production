package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.db.impl.TaskHandler;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.util.DateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 11.05.2018.
 */
public class TaskAdapter {
    public static Collection<TaskBean> tasks(javax.servlet.http.HttpServletRequest request) {
        TaskFilterBean bean = filter(request);
        Collection<ITask> tasks = Module.tasks(bean);
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
            taskBeans.add(new TaskBean(++num,task,taskClass,dateClass,comments,doneHtml));
        }
        return taskBeans;
    }

    public static TaskFilterBean filter(javax.servlet.http.HttpServletRequest request) {
        IPerson person = AuthManager.instance().signedPerson();
        int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
        int statusId = request.getParameter("statusId")!=null?Integer.valueOf(request.getParameter("statusId")):-1;
        int priorityId = request.getParameter("priorityId")!=null?Integer.valueOf(request.getParameter("priorityId")):-1;
        Date fromDate = request.getParameter("fromDate")!=null?DateUtil.parse(request.getParameter("fromDate")):DateUtil.parse("01.01.2000");
        Date toDate = request.getParameter("toDate")!=null?DateUtil.parse(request.getParameter("toDate")): DateUtil.parse("01.01.3000");
        return TaskFilterFactory.bean(statusId, categoryId, priorityId, fromDate, toDate, person.getId());
    }

    public static void done(javax.servlet.http.HttpServletRequest request) {
        int taskId = request.getParameter("taskId")!=null?Integer.valueOf(request.getParameter("taskId")):-1;
        if (taskId!=-1) {
            ITask task = TaskFactory.createTask(taskId, "", new Date(), new Date(), Priority.priority(Priority.SIMPLE)
                    , 1, "", null, Status.status(Status.OPEN));
            try {
                TaskHandler.close(task);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
